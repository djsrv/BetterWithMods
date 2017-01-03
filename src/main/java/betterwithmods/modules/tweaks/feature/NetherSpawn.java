package betterwithmods.modules.tweaks.feature;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.NetherSpawnWhitelist;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class NetherSpawn extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        NetherSpawnWhitelist.addBlock(Blocks.NETHERRACK);
        NetherSpawnWhitelist.addBlock(Blocks.NETHER_BRICK);
        NetherSpawnWhitelist.addBlock(Blocks.SOUL_SAND);
        NetherSpawnWhitelist.addBlock(Blocks.GRAVEL);
        NetherSpawnWhitelist.addBlock(Blocks.QUARTZ_BLOCK);
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @SubscribeEvent
    public void denyNetherSpawns(LivingSpawnEvent.CheckSpawn evt) {
        if (evt.getResult() == Event.Result.ALLOW)
            return;
        if (evt.getWorld() != null && evt.getWorld().provider.getDimension() == -1) {
            if (evt.getEntityLiving().isCreatureType(EnumCreatureType.MONSTER, false)) {
                double monX = evt.getEntity().posX;
                double monY = evt.getEntity().posY;
                double monZ = evt.getEntity().posZ;
                int x = MathHelper.floor(monX);
                int y = MathHelper.floor(monY);
                int z = MathHelper.floor(monZ);
                BlockPos pos = new BlockPos(x, y - 1, z);
                Block block = evt.getWorld().getBlockState(pos).getBlock();
                int meta = evt.getWorld().getBlockState(pos).getBlock().getMetaFromState(evt.getWorld().getBlockState(pos));
                if (!evt.getWorld().isAirBlock(pos) && !NetherSpawnWhitelist.contains(block, meta))
                    evt.setResult(Event.Result.DENY);
            }
        }
    }
}
