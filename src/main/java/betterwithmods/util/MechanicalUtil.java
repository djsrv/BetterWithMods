package betterwithmods.util;

import betterwithmods.BWMBlocks;
import betterwithmods.api.block.IAxle;
import betterwithmods.api.block.IMechanical;
import betterwithmods.api.block.IMechanicalBlock;
import betterwithmods.api.capabilities.MechanicalCapability;
import betterwithmods.blocks.BlockAxle;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MechanicalUtil {
    public static boolean isBlockPoweredOnSide(World world, BlockPos pos, EnumFacing dir) {
        boolean isPowered = isBlockPoweredByAxleOnSide(world, pos, dir);
        if (!isPowered) {
            Block block = world.getBlockState(pos.offset(dir)).getBlock();
            if (block instanceof IMechanicalBlock)
                isPowered = ((IMechanicalBlock) block).isOutputtingMechPower(world, pos.offset(dir));
        }
        return isPowered;
    }

    public static int searchForAdvMechanical(World world, BlockPos pos, EnumFacing dir) {
        int power = isBlockPoweredOnSide(world, pos, dir) ? 1 : 0;
        if (power > 0) {
            for (int i = 2; i < 5; i++) {
                BlockPos off = pos.offset(dir, i);
                Block block = world.getBlockState(off).getBlock();
                if (block instanceof IMechanical) {
                    if (((IMechanical) block).isMechanicalJunction()) {
                        if (world.getTileEntity(off) != null) {
                            TileEntity tile = world.getTileEntity(off);
                            if (tile.hasCapability(MechanicalCapability.MECHANICAL_POWER, dir.getOpposite())) {
                                power = tile.getCapability(MechanicalCapability.MECHANICAL_POWER, dir.getOpposite()).getMechanicalOutput(dir.getOpposite());
                            }
                        }
                        break;
                    }
                }
            }
        }
        return power;
    }

    public static boolean isBlockPoweredByAxleOnSide(World world, BlockPos pos, EnumFacing dir) {
        BlockPos pos2 = pos.offset(dir);
        Block block = world.getBlockState(pos2).getBlock();

        if (isAxle(block)) {
            IAxle axle = (IAxle) block;

            if (axle.isAxleOrientedToFacing(world, pos2, dir)) {
                if (axle.getPowerLevel(world, pos2) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAxle(Block block) {
        return block instanceof IAxle;
    }

    public static boolean isPoweredByCrank(World world, BlockPos pos) {
        for (int i = 1; i < 6; i++) {
            if (isPoweredByCrankOnSide(world, pos, EnumFacing.getFront(i)))
                return true;
        }
        return false;
    }

    public static boolean isPoweredByCrankOnSide(World world, BlockPos pos, EnumFacing dir) {
        BlockPos offset = pos.offset(dir);
        Block block = world.getBlockState(offset).getBlock();

        if (block == BWMBlocks.HAND_CRANK) {
            IMechanicalBlock mech = (IMechanicalBlock) block;

            if (mech.isOutputtingMechPower(world, offset))
                return true;
        }
        return false;
    }

    public static boolean isBlockPoweredByAxle(World world, BlockPos pos, IMechanicalBlock block) {
        for (int i = 0; i < 6; i++) {
            if (block.canInputPowerToSide(world, pos, EnumFacing.getFront(i))) {
                if (isBlockPoweredByAxleOnSide(world, pos, EnumFacing.getFront(i)))
                    return true;
            }
        }
        return false;
    }

    public static void destoryHorizontalAxles(World world, BlockPos pos) {
        for (int i = 2; i < 6; i++) {
            Block block = world.getBlockState(pos).getBlock();
            if (isAxle(block)) {
                BlockAxle axle = (BlockAxle) block;

                if (axle.isAxleOrientedToFacing(world, pos, EnumFacing.getFront(i)))
                    axle.breakAxle(world, pos);
            }
        }
    }
}
