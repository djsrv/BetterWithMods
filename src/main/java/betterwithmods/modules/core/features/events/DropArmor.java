package betterwithmods.modules.core.features.events;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class DropArmor extends Feature {
    @Override
    public boolean hasSubscriptions() {
        return super.hasSubscriptions();
    }
    @SubscribeEvent
    public void mobDrops(LivingDropsEvent evt) {
        if (evt.getEntity() instanceof EntityZombie || evt.getEntity() instanceof EntitySkeleton) {
            EntityMob mob = (EntityMob) evt.getEntity();
            List<ItemStack> drops = new ArrayList<>();
            for (EntityItem item : evt.getDrops()) {
                if (item.getEntityItem() != null) {
                    drops.add(item.getEntityItem().copy());
                }
            }
            for (ItemStack item : mob.getEquipmentAndArmor()) {
                if (item != null) {
                    if (!InvUtils.listContainsArmor(item, drops)) {
                        if (isNonDefaultArmor(mob, item)) {
                            createDamagedItem(evt, item.copy());
                        }
                    }
                }
            }
        }
    }


    private boolean isNonDefaultArmor(EntityMob mob, ItemStack stack) {
        Item item = stack.getItem();
        if (mob instanceof EntitySkeleton) {
            if (item instanceof ItemBow || item instanceof ItemSword)
                return stack.hasTagCompound();
        } else if (mob instanceof EntityPigZombie) {
            if (item == Items.GOLDEN_SWORD) {
                return stack.hasTagCompound();
            }
        }
        return true;
    }

    private void createDamagedItem(LivingDropsEvent evt, ItemStack stack) {
        if (stack.isItemStackDamageable()) {
            stack.setItemDamage((int) (evt.getEntity().world.rand.nextFloat() * stack.getMaxDamage()));
        }
        addDrop(evt, stack);
    }

    public void addDrop(LivingDropsEvent evt, ItemStack drop) {
        EntityItem item = new EntityItem(evt.getEntityLiving().getEntityWorld(), evt.getEntityLiving().posX, evt.getEntityLiving().posY, evt.getEntityLiving().posZ, drop);
        item.setDefaultPickupDelay();
        evt.getDrops().add(item);
    }
}
