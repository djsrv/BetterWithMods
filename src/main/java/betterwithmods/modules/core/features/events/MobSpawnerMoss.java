package betterwithmods.modules.core.features.events;

import betterwithmods.base.modules.Feature;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class MobSpawnerMoss extends Feature {
    private static final Random rand = new Random();

    @SubscribeEvent
    public void generateMossNearSpawner(TickEvent.WorldTickEvent e) {
        List<BlockPos> positions = e.world.loadedTileEntityList.stream().filter(t -> t instanceof TileEntityMobSpawner).map(TileEntity::getPos).collect(Collectors.toList());
        Iterator<BlockPos> iter = positions.iterator();
        while (iter.hasNext()) {
            BlockPos pos = iter.next();
            int x = rand.nextInt(9) - 4;
            int y = rand.nextInt(5) - 1;
            int z = rand.nextInt(9) - 4;
            BlockPos check = pos.add(x, y, z);
            IBlockState state = e.world.getBlockState(check);
            if (rand.nextInt(30) == 0) {
                IBlockState newState = null;
                if (state.getBlock() == Blocks.COBBLESTONE) {
                    newState = Blocks.MOSSY_COBBLESTONE.getDefaultState();
                } else if (state.getBlock() == Blocks.STONEBRICK && state.getBlock().getMetaFromState(state) == 0) {
                    newState = Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY);
                }
                if (newState != null) {
                    e.world.setBlockState(check, newState);
                }
            }
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return super.hasSubscriptions();
    }
}
