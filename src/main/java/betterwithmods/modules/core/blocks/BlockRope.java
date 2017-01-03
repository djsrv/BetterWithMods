package betterwithmods.modules.core.blocks;

import betterwithmods.base.blocks.BWMBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public final class BlockRope extends BWMBlock {
    private static final AxisAlignedBB ROPE_AABB = new AxisAlignedBB(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);

    public BlockRope() {
        super(Material.CIRCUITS);
        setSoundType(SoundType.PLANT);
        this.setHardness(0.5F);
    }

    public static boolean placeRopeUnder(BlockRope rope, ItemStack stack, World world, BlockPos pos, EntityPlayer player) {
        if (stack != null || player == null) {
            BlockPos bp = getLowestRopeBlock(world, pos, rope).down();
            Block block = world.getBlockState(bp).getBlock();
            if ((world.isAirBlock(bp) || block.isReplaceable(world, bp)) && rope.canBlockStay(world, bp)) {
                world.setBlockState(bp, rope.getDefaultState());
                world.playSound(null, bp, rope.getSoundType(rope.getDefaultState(), world, null, null).getPlaceSound(), SoundCategory.BLOCKS, 1, 1);
                if (player != null && !player.capabilities.isCreativeMode) // if this is placed by a pulley, let the pulley manage the stack size
                    stack.stackSize--;
                return true;
            }
        }
        return false;
    }

    public static BlockPos getLowestRopeBlock(World world, BlockPos pos, BlockRope rope) {
        if (world != null && pos != null) {
            BlockPos down = pos.down();
            Block below = world.getBlockState(down).getBlock();
            if (below == rope) {
                return getLowestRopeBlock(world, down, rope);
            } else {
                return pos;
            }
        } else {
            return null;
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (heldItem != null && heldItem.getItem() instanceof ItemBlock && ((ItemBlock) heldItem.getItem()).getBlock() == this) {
            return placeRopeUnder(this, heldItem, worldIn, pos, playerIn);
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighbor) {
        if (!canBlockStay(world, pos)) {
            dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }
    }

    public boolean canBlockStay(World world, BlockPos pos) {
        Block blockAbove = world.getBlockState(pos.up()).getBlock();

        boolean supported = false;
        
        if (blockAbove instanceof BlockAnchor) {
            EnumFacing facing = ((BlockAnchor) blockAbove).getFacingFromBlockState(world.getBlockState(pos.up()));
            supported = facing != EnumFacing.UP;
        }
        supported &= blockAbove instanceof BlockPulley || blockAbove == this;
        return supported;
    }

    @Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
        return canBlockStay(world, pos);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return ROPE_AABB;
    }

    @Override
    public EnumFacing getFacingFromBlockState(IBlockState state) {
        return null;
    }

    @Override
    public IBlockState setFacingInBlock(IBlockState state, EnumFacing facing) {
        return state;
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return entity instanceof EntityPlayer;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }
}
