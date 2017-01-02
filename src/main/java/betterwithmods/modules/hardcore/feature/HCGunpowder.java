package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.items.ItemMaterial;
import betterwithmods.base.modules.Feature;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCGunpowder extends Feature {
    @SubscribeEvent
    public void mobDrops(LivingDropsEvent evt) {

        if (evt.getEntity() instanceof EntityCreeper || evt.getEntity() instanceof EntityGhast) {
            for (EntityItem item : evt.getDrops()) {
                ItemStack stack = item.getEntityItem();
                if (stack.getItem() == Items.GUNPOWDER) {
                    item.setEntityItemStack(ItemMaterial.getMaterial("niter", stack.stackSize));
                }
            }
        }
    }
    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
