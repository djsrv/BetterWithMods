package betterwithmods.base.blocks;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.base.util.DirUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BWMBlockPane extends BWMBlock  {


    public BWMBlockPane() {
        super(Material.WOOD);
        this.setCreativeTab(BWCreativeTabs.BWTAB);
        this.setHardness(2.0F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(DirUtils.NORTH, false).withProperty(DirUtils.EAST, false).withProperty(DirUtils.SOUTH, false).withProperty(DirUtils.WEST, false));
        this.setSoundType(SoundType.WOOD);
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
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entity) {
        state = state.getActualState(world, pos);

        float minY = 0.001F;
        float maxY = 0.999F;
        float minX = 0.4375F;
        float maxX = 0.5625F;
        float minZ = 0.4375F;
        float maxZ = 0.5625F;
        if (state.getValue(DirUtils.NORTH))
            minZ = 0.0F;
        if (state.getValue(DirUtils.SOUTH))
            maxZ = 1.0F;
        if (state.getValue(DirUtils.WEST))
            minX = 0.0F;
        if (state.getValue(DirUtils.EAST))
            maxX = 1.0F;

        AxisAlignedBB stick = new AxisAlignedBB(0.5F - 0.0625F, 0.0F, 0.5F - 0.0625F, 0.5625F, 1.0F, 0.5625F);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, stick);

        if (minZ == 0.0F || maxZ == 1.0F) {
            AxisAlignedBB extZ = new AxisAlignedBB(0.4375F, minY, minZ, 0.5625F, maxY, maxZ);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, extZ);
        }

        if (minX == 0.0F || maxX == 1.0F) {
            AxisAlignedBB extX = new AxisAlignedBB(minX, minY, 0.4375F, maxX, maxY, 0.5625F);
            addCollisionBoxToList(pos, entityBox, collidingBoxes, extX);
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        //TODO Cache AABB
        state = state.getActualState(world, pos);

        float minY = 0.0F;
        float maxY = 1.0F;
        float minX = 0.4375F;
        float maxX = 0.5625F;
        float minZ = 0.4375F;
        float maxZ = 0.5625F;
        if (state.getValue(DirUtils.NORTH))
            minZ = 0.0F;
        if (state.getValue(DirUtils.SOUTH))
            maxZ = 1.0F;
        if (state.getValue(DirUtils.WEST))
            minX = 0.0F;
        if (state.getValue(DirUtils.EAST))
            maxX = 1.0F;
        return new AxisAlignedBB(minX, minY, minZ, maxX, maxY, maxZ);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return true;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isSideSolid(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    public final boolean isIncompatibleBlock(Block block) {
        return block instanceof net.minecraft.block.BlockPane;
    }

    public final boolean isFenceGate(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        IBlockState state = world.getBlockState(pos.offset(dir));
        if (dir == EnumFacing.EAST || dir == EnumFacing.WEST)
            return state.getBlock() instanceof BlockFenceGate && (state.getValue(BlockHorizontal.FACING) == EnumFacing.NORTH || state.getValue(BlockHorizontal.FACING) == EnumFacing.SOUTH);
        else
            return state.getBlock() instanceof BlockFenceGate && (state.getValue(BlockHorizontal.FACING) == EnumFacing.EAST || state.getValue(BlockHorizontal.FACING) == EnumFacing.WEST);
    }

    public final boolean isCompatibleBlock(Block block) {
        return block.getDefaultState().isFullBlock() || block == this;
    }

    public boolean canConnectTo(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        BlockPos offset = pos.offset(dir);
        Block block = world.getBlockState(offset).getBlock();
        return isFenceGate(world, pos, dir) || isCompatibleBlock(block) || (!isIncompatibleBlock(block) && block.isSideSolid(world.getBlockState(offset), world, offset, dir.getOpposite()));
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return entity instanceof EntityPlayer;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
        if (world.getBlockState(pos).getBlock() == this) {
            return state.withProperty(DirUtils.NORTH, canConnectTo(world, pos, EnumFacing.NORTH))
                    .withProperty(DirUtils.EAST, canConnectTo(world, pos, EnumFacing.EAST))
                    .withProperty(DirUtils.SOUTH, canConnectTo(world, pos, EnumFacing.SOUTH))
                    .withProperty(DirUtils.WEST, canConnectTo(world, pos, EnumFacing.WEST));
        } else
            return state;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, DirUtils.SOUTH, DirUtils.EAST, DirUtils.NORTH, DirUtils.WEST);
    }

}
