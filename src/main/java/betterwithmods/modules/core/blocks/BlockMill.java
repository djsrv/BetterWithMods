package betterwithmods.modules.core.blocks;

import betterwithmods.base.BWMod;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.MechanicalUtil;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.core.tiles.TileEntityMill;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class BlockMill extends BlockMachine{
    public BlockMill() {
        super(Material.ROCK);
    }

    @Override
    public boolean canInputPowerToSide(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return dir.getAxis().isVertical();
    }

    @Override
    public void overpower(World world, BlockPos pos) {
        if (Machines.dropsMill)
            InvUtils.ejectBrokenItems(world, pos, new ResourceLocation(BWMod.MODID, "blocks/mill"));
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.3F, world.rand.nextFloat() * 0.1F + 0.45F);
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityMill();
    }

    @Override
    public boolean isInputtingMechPower(World world, BlockPos pos) {
        return MechanicalUtil.isBlockPoweredByAxle(world, pos, this) || MechanicalUtil.isPoweredByCrank(world, pos);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        if(isMechanicalOn(world,pos)) {
            for (int i = 0; i < 5; i++) {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                float fX = x + rand.nextFloat();
                float fY = y + rand.nextFloat() * 0.5F + 1.0F;
                float fZ = z + rand.nextFloat();
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, fX, fY, fZ, 0.0D, 0.0D, 0.0D);
            }
        }
    }

}
