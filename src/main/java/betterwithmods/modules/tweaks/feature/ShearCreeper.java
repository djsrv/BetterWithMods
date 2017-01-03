package betterwithmods.modules.tweaks.feature;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import betterwithmods.modules.tweaks.entity.EntityShearedCreeper;
import betterwithmods.modules.tweaks.entity.RenderShearedCreeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class ShearCreeper extends Feature {
    public static Item CREEPER_OYSTER;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        CREEPER_OYSTER = (new ItemFood(2, false).setPotionEffect(new PotionEffect(MobEffects.POISON, 5, 0), 1)).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("creeper_oyster");
        registerItem(CREEPER_OYSTER);

    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(CREEPER_OYSTER);
        RenderingRegistry.registerEntityRenderingHandler(EntityShearedCreeper.class, RenderShearedCreeper::new);
    }

    @SubscribeEvent
    public void shearCreeper(PlayerInteractEvent.EntityInteractSpecific e) {
        Entity creeper = e.getTarget();
        if (creeper instanceof EntityCreeper) {
            if (e.getSide().isServer() && creeper.isEntityAlive() && e.getItemStack() != null) {
                if (e.getItemStack().getItem() instanceof ItemShears) {
                    InvUtils.ejectStack(e.getWorld(), creeper.posX, creeper.posY, creeper.posZ, new ItemStack(CREEPER_OYSTER));
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
