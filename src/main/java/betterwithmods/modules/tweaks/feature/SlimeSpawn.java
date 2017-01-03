package betterwithmods.modules.tweaks.feature;

import betterwithmods.base.modules.Feature;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class SlimeSpawn extends Feature {

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @SubscribeEvent
    public void denySlimeSpawns(LivingSpawnEvent.CheckSpawn evt) {
        if (evt.getResult() == Event.Result.ALLOW)
            return;
        if (evt.getWorld() != null && evt.getWorld().provider.getDimensionType() == DimensionType.OVERWORLD) {
            if (evt.getEntityLiving() instanceof EntitySlime) {
                BlockPos pos = new BlockPos(evt.getEntity().posX, evt.getEntity().posY - 1, evt.getEntity().posZ);
                if (evt.getWorld().getBlockState(pos).getMaterial() != Material.GRASS && evt.getWorld().getBlockState(pos).getMaterial() != Material.ROCK && evt.getWorld().getBlockState(pos).getMaterial() != Material.GROUND)
                    evt.setResult(Event.Result.DENY);
            }
        }
    }
}
