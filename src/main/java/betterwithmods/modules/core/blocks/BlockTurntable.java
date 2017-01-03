package betterwithmods.modules.core.blocks;

import betterwithmods.base.BWMod;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.MechanicalUtil;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.core.tiles.TileEntityTurntable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class BlockTurntable extends BlockMachine {

    public BlockTurntable() {
        super(Material.ROCK);
    }

    @Override
    public boolean canInputPowerToSide(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return dir == EnumFacing.DOWN;
    }

    @Override
    public void overpower(World world, BlockPos pos) {
        if (Machines.dropsTurntable)
            InvUtils.ejectBrokenItems(world, pos, new ResourceLocation(BWMod.MODID, "blocks/turntable"));
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.3F, world.rand.nextFloat() * 0.1F + 0.45F);
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityTurntable();
    }

    @Override
    public boolean isInputtingMechPower(World world, BlockPos pos) {
        return MechanicalUtil.isBlockPoweredByAxle(world, pos, this);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(world, pos, state, rand);
        if (world.getTileEntity(pos) instanceof TileEntityTurntable) {
            if (!world.getGameRules().getBoolean("doDaylightCycle"))
                ((TileEntityTurntable) world.getTileEntity(pos)).toggleAsynchronous(null);
        }
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote && world.getTileEntity(pos) instanceof TileEntityTurntable) {
            return ((TileEntityTurntable) world.getTileEntity(pos)).processRightClick(player);
        }
        return true;
    }

    @Override
    public int tickRate(World worldIn) {
        return 10;
    }
}
