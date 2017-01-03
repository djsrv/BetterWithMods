package betterwithmods.modules.utilities.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import betterwithmods.modules.utilities.blocks.BlockRawPastry;
import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.ThrowableImpactEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Food extends Feature {
    public static Item RAW_EGG;
    public static Item COOKED_EGG;
    public static Item RAW_SCRAMBLED_EGG;
    public static Item COOKED_SCRAMBLED_EGG;
    public static Item RAW_OMELET;
    public static Item COOKED_OMELET;
    public static Item HAM_AND_EGGS;
    public static Item TASTY_SANDWICH;
    public static Item BEEF_DINNER;
    public static Item BEEF_POTATOES;
    public static Item CHICKEN_SOUP;
    public static Item CHOCOLATE;
    public static Item CHOWDER;
    public static Item COOKED_KEBAB;
    public static Item HEARTY_STEW;
    public static Item RAW_KEBAB;
    public static Item PORK_DINNER;
    public static Item DONUT;

    public static Block RAW_PASTRY = new BlockRawPastry().setRegistryName("raw_pastry");
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        RAW_EGG = new ItemFood(2, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("raw_egg");
        COOKED_EGG = new ItemFood(3, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("cooked_egg");
        RAW_SCRAMBLED_EGG = new ItemFood(4, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("raw_scrambled_egg");
        COOKED_SCRAMBLED_EGG = new ItemFood(5, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("cooked_scrambled_egg");
        RAW_OMELET = new ItemFood(3, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("raw_omelet");
        COOKED_OMELET = new ItemFood(4, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("cooked_omelet");
        HAM_AND_EGGS = new ItemFood(6, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("ham_and_eggs");
        TASTY_SANDWICH = new ItemFood(6, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("tasty_sandwich");
        BEEF_DINNER = new ItemFood(8, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("beef_dinner");
        BEEF_POTATOES = new ItemFood(6, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("beef_potatoes");
        CHICKEN_SOUP = new ItemSoup(8).setMaxStackSize(64).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("chicken_soup");
        CHOCOLATE = new ItemFood(2, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("chocolate");
        CHOWDER = new ItemSoup(5).setMaxStackSize(64).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("chowder");
        COOKED_KEBAB = new ItemFood(8, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("cooked_kebab");
        HEARTY_STEW = new ItemSoup(10).setMaxStackSize(64).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("hearty_stew");
        RAW_KEBAB = new ItemFood(6, false).setPotionEffect(new PotionEffect(MobEffects.HUNGER, 600, 0), 0.3F).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("raw_kebab");
        PORK_DINNER = new ItemFood(8, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("pork_dinner");
        DONUT = new ItemFood(2, false).setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("donut");


        registerItem(RAW_EGG);
        registerItem(COOKED_EGG);
        registerItem(RAW_SCRAMBLED_EGG);
        registerItem(COOKED_SCRAMBLED_EGG);
        registerItem(RAW_OMELET);
        registerItem(COOKED_OMELET);
        registerItem(HAM_AND_EGGS);
        registerItem(TASTY_SANDWICH);
        registerItem(BEEF_DINNER);
        registerItem(BEEF_POTATOES);
        registerItem(CHICKEN_SOUP);
        registerItem(CHOCOLATE);
        registerItem(CHOWDER);
        registerItem(COOKED_KEBAB);
        registerItem(HEARTY_STEW);
        registerItem(RAW_KEBAB);
        registerItem(PORK_DINNER);
        registerItem(DONUT);

        registerBlock(RAW_PASTRY, new ItemBlockMeta(RAW_PASTRY));
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(DONUT);
        ModelHandler.setInventoryModel(RAW_EGG);
        ModelHandler.setInventoryModel(COOKED_EGG);
        ModelHandler.setInventoryModel(RAW_SCRAMBLED_EGG);
        ModelHandler.setInventoryModel(COOKED_SCRAMBLED_EGG);
        ModelHandler.setInventoryModel(RAW_OMELET);
        ModelHandler.setInventoryModel(COOKED_OMELET);
        ModelHandler.setInventoryModel(HAM_AND_EGGS);
        ModelHandler.setInventoryModel(TASTY_SANDWICH);
        ModelHandler.setInventoryModel(BEEF_DINNER);
        ModelHandler.setInventoryModel(BEEF_POTATOES);
        ModelHandler.setInventoryModel(CHICKEN_SOUP);
        ModelHandler.setInventoryModel(CHOCOLATE);
        ModelHandler.setInventoryModel(CHOWDER);
        ModelHandler.setInventoryModel(COOKED_KEBAB);
        ModelHandler.setInventoryModel(HEARTY_STEW);
        ModelHandler.setInventoryModel(RAW_KEBAB);
        ModelHandler.setInventoryModel(PORK_DINNER);

    }

    @SubscribeEvent
    public void getRawEgg(ThrowableImpactEvent event) {
        if (event.getEntityThrowable() instanceof EntityEgg) {
            event.setCanceled(true);
            RayTraceResult result = event.getRayTraceResult();
            EntityThrowable egg = event.getEntityThrowable();
            Random rand = egg.getEntityWorld().rand;
            if (result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(egg, egg.getThrower()), 0.0F);
            }

            if (!egg.getEntityWorld().isRemote) {
                if (rand.nextInt(8) == 0) {
                    int i = 1;

                    if (rand.nextInt(32) == 0) {
                        i = 4;
                    }

                    for (int j = 0; j < i; ++j) {
                        EntityChicken entitychicken = new EntityChicken(egg.getEntityWorld());
                        entitychicken.setGrowingAge(-24000);
                        entitychicken.setLocationAndAngles(egg.posX, egg.posY, egg.posZ, egg.rotationYaw, 0.0F);
                        egg.getEntityWorld().spawnEntity(entitychicken);
                    }
                } else {
                    InvUtils.ejectStack(egg.getEntityWorld(), egg.posX, egg.posY, egg.posZ, new ItemStack(Food.RAW_EGG));
                }
            }

            for (int k = 0; k < 8; ++k) {
                egg.getEntityWorld().spawnParticle(EnumParticleTypes.ITEM_CRACK, egg.posX, egg.posY, egg.posZ, ((double) rand.nextFloat() - 0.5D) * 0.08D, ((double) rand.nextFloat() - 0.5D) * 0.08D, ((double) rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(Items.EGG));
            }

            if (!egg.getEntityWorld().isRemote) {
                egg.setDead();
            }
        }
    }


    @SubscribeEvent
    public void saveSoup(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem() != null) {
            if (event.getItem().getItem() instanceof ItemSoup) {
                if (event.getItem().stackSize > 0) {
                    ItemStack result = event.getResultStack();
                    event.setResultStack(event.getItem());
                    if (event.getEntityLiving() instanceof EntityPlayer) {
                        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
                        if (!player.inventory.addItemStackToInventory(result)) {
                            player.dropItem(result, false);
                        }
                    }
                }
            }
        }
    }


    @Override
    public boolean hasSubscriptions() {
        return super.hasSubscriptions();
    }
}
