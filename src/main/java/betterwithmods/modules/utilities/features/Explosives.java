package betterwithmods.modules.utilities.features;

import betterwithmods.base.client.BWCreativeTabs;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockMiningCharge;
import betterwithmods.modules.utilities.client.render.RenderMiningCharge;
import betterwithmods.modules.utilities.entity.EntityDynamite;
import betterwithmods.modules.utilities.entity.EntityMiningCharge;
import betterwithmods.modules.utilities.items.ItemDynamite;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/26/16
 */
public class Explosives extends Feature {
    public static Block MINING_CHARGE;
    public static Item DYNAMITE;
    public static Item BLASTING_OIL;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MINING_CHARGE = new BlockMiningCharge().setRegistryName("mining_charge");
        DYNAMITE = new ItemDynamite().setRegistryName("dynamite");
        BLASTING_OIL = new Item().setCreativeTab(BWCreativeTabs.BWTAB).setRegistryName("blasting_oil");

        registerBlock(MINING_CHARGE);
        registerItem(BLASTING_OIL);
        registerItem(DYNAMITE);

    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(BLASTING_OIL);
        ModelHandler.setInventoryModel(DYNAMITE);
        ModelHandler.setInventoryModel(MINING_CHARGE);
        RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, manager -> new RenderSnowball<>(manager, DYNAMITE, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiningCharge.class, RenderMiningCharge::new);
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @SubscribeEvent
    public void onPlayerTakeDamage(LivingHurtEvent e) {
        DamageSource BLAST_OIL = new DamageSource("blastingoil");
        EntityLivingBase living = e.getEntityLiving();
        if (living.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            IItemHandler inventory = living.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
            int count = 0;
            for (int i = 0; i < inventory.getSlots(); i++) {
                ItemStack stack = inventory.getStackInSlot(i);

                if (stack != null && stack.isItemEqual(new ItemStack(BLASTING_OIL))) {
                    count += stack.stackSize;
                    inventory.extractItem(i, stack.stackSize, false);
                }
            }
            if (count > 0) {
                living.attackEntityFrom(BLAST_OIL, Float.MAX_VALUE);
                living.getEntityWorld().createExplosion(null, living.posX, living.posY + living.height / 16, living.posZ, (float) (Math.sqrt(count / 5) / 2.5 + 1), true);
            }
        }
    }


}
