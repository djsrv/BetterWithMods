package betterwithmods.modules.core.blocks;

import betterwithmods.base.BWMod;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.MechanicalUtil;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.core.tiles.TileEntityFilteredHopper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class BlockFilteredHopper extends BlockMachine {
    public BlockFilteredHopper() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public boolean canInputPowerToSide(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return dir.getAxis().isHorizontal();
    }

    @Override
    public void overpower(World world, BlockPos pos) {
        if (Machines.dropsHopper)
            InvUtils.ejectBrokenItems(world, pos, new ResourceLocation(BWMod.MODID, "blocks/hopper"));
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.3F, world.rand.nextFloat() * 0.1F + 0.45F);
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityFilteredHopper();
    }

    @Override
    public boolean isInputtingMechPower(World world, BlockPos pos) {
        return MechanicalUtil.isBlockPoweredByAxle(world, pos, this) || MechanicalUtil.isPoweredByCrank(world, pos);
    }


    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntityFilteredHopper) {
                if (entity instanceof EntityItem || entity instanceof EntityXPOrb)
                    world.scheduleBlockUpdate(pos, this, tickRate(world), 5);//world.markBlockForUpdate(pos);
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block) {
        super.neighborChanged(state, world, pos, block);

        ((TileEntityFilteredHopper) world.getTileEntity(pos)).outputBlocked = false;
    }

    @Override
    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }


}
