package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.entity.item.EntityItemBuoy;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.item.ItemExt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCBouy extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        ItemExt.initBuoyancy();
        ItemExt.initWeights();
    }

    @Override
    public boolean hasSubscriptions() {
        return super.hasSubscriptions();
    }

    /**
     * Substitute the original {@link EntityItem} by our new {@link EntityItemBuoy}.
     */
    @SubscribeEvent
    public void replaceServerEntityItem(EntityJoinWorldEvent event) {
        World world = event.getWorld();
        if (world.isRemote) return;

        if (!(event.getEntity().getClass() == EntityItem.class)) return;
        EntityItem entityItem = (EntityItem) event.getEntity();

        if (entityItem.getEntityItem().stackSize > 0) {
            event.setResult(Event.Result.DENY);
            event.setCanceled(true);
            EntityItemBuoy newEntity = new EntityItemBuoy(entityItem);
            entityItem.setDead();
            entityItem.setInfinitePickupDelay();
            world.spawnEntity(newEntity);
        }
    }
}
