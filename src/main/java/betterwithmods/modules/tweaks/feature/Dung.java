package betterwithmods.modules.tweaks.feature;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class Dung extends Feature {
    public static Item DUNG;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DUNG = new Item().setRegistryName("dung");
        registerItem(DUNG);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(DUNG);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        HCBouy.registerBuoyancy(DUNG, 1.0F);
    }

    private static final int[] fearLevel = {1600, 1500, 1400, 1300, 1200, 1100, 1000, 900, 800, 700, 600, 500, 400, 300, 200, 100};
    @SubscribeEvent
    public void mobDungProduction(LivingEvent.LivingUpdateEvent evt) {
        if (evt.getEntityLiving().getEntityWorld().isRemote)
            return;
        if (evt.getEntityLiving() instanceof EntityAnimal) {
            EntityAnimal animal = (EntityAnimal) evt.getEntityLiving();
            if (animal instanceof EntityWolf) {
                if (!animal.getEntityWorld().canSeeSky(animal.getPosition())) {
                    if (animal.getGrowingAge() > 99) {
                        int light = animal.getEntityWorld().getLight(animal.getPosition());
                        if (animal.getGrowingAge() == fearLevel[light]) {
                            evt.getEntityLiving().entityDropItem(new ItemStack(DUNG), 0.0F);
                            animal.setGrowingAge(99);
                        }
                    }
                }
            }
            if (!(animal instanceof EntityRabbit)) {
                if (animal.getGrowingAge() == 100) {
                    evt.getEntityLiving().entityDropItem(new ItemStack(DUNG), 0.0F);
                } else if (animal.isInLove()) {
                    if (animal.world.rand.nextInt(1200) == 0) {
                        evt.getEntityLiving().entityDropItem(new ItemStack(DUNG), 0.0F);
                    }
                }
            }
        }
    }
    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
