package betterwithmods.modules.core.blocks;

import betterwithmods.base.BWMod;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.MechanicalUtil;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.core.tiles.TileEntityPulley;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class BlockPulley extends BlockMachine {
    public BlockPulley() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
    }

    @Override
    public boolean canInputPowerToSide(IBlockAccess world, BlockPos pos, EnumFacing dir) {
        return dir.getAxis().isHorizontal();
    }

    @Override
    public void overpower(World world, BlockPos pos) {
        if (Machines.dropsPulley)
            InvUtils.ejectBrokenItems(world, pos, new ResourceLocation(BWMod.MODID, "blocks/pulley"));
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.3F, world.rand.nextFloat() * 0.1F + 0.45F);
        world.setBlockToAir(pos);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityPulley();
    }

    @Override
    public boolean isInputtingMechPower(World world, BlockPos pos) {
        return MechanicalUtil.isBlockPoweredByAxle(world, pos, this) || MechanicalUtil.isPoweredByCrank(world, pos);
    }
}
