package betterwithmods.modules.environment.feature;

import betterwithmods.base.registry.BWMItems;
import betterwithmods.base.entity.EntityShearedCreeper;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class ShearCreeper extends Feature {
    @SubscribeEvent
    public void shearCreeper(PlayerInteractEvent.EntityInteractSpecific e) {
        Entity creeper = e.getTarget();
        if (creeper instanceof EntityCreeper) {
            if (e.getSide().isServer() && creeper.isEntityAlive() && e.getItemStack() != null) {
                if (e.getItemStack().getItem() instanceof ItemShears) {
                    InvUtils.ejectStack(e.getWorld(), creeper.posX, creeper.posY, creeper.posZ, new ItemStack(BWMItems.CREEPER_OYSTER));
                    EntityShearedCreeper shearedCreeper = new EntityShearedCreeper(e.getWorld());
                    creeper.attackEntityFrom(new DamageSource(""), 0);
                    shearedCreeper.setPositionAndRotation(creeper.posX, creeper.posY, creeper.posZ, creeper.rotationYaw, creeper.rotationPitch);
                    shearedCreeper.setRotationYawHead(creeper.getRotationYawHead());
                    e.getWorld().playSound(null, shearedCreeper.posX, shearedCreeper.posY, shearedCreeper.posZ, SoundEvents.ENTITY_SLIME_JUMP, SoundCategory.HOSTILE, 1, 0.3F);
                    e.getWorld().playSound(null, shearedCreeper.posX, shearedCreeper.posY, shearedCreeper.posZ, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.HOSTILE, 1, 1F);
                    creeper.setDead();
                    e.getWorld().spawnEntity(shearedCreeper);
                }
            }
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return super.hasSubscriptions();
    }
}
