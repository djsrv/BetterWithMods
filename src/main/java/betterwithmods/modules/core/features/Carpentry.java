package betterwithmods.modules.core.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockSaw;
import betterwithmods.modules.core.items.ItemBark;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Carpentry extends Feature {
    public static Block SAW;

    public static Item SAW_DUST;
    public static Item BARK;
    public static Item GEAR;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        SAW = new BlockSaw().setRegistryName("saw");

        SAW_DUST = new Item().setRegistryName("sawdust");
        BARK = new ItemBark().setRegistryName("bark");
        GEAR = new Item().setRegistryName("gear");


        registerBlock(SAW);

        registerItem(SAW_DUST);
        registerItem(BARK);
        registerItem(GEAR);

    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

    }

    public static FakePlayer player;

    //Initializing a static fake player for saws, so spawn isn't flooded with player equipping sounds when mobs hit the saw.
    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load evt) {
        if (evt.getWorld() instanceof WorldServer) {
            player = FakePlayerFactory.getMinecraft((WorldServer) evt.getWorld());
            ItemStack sword = new ItemStack(Items.DIAMOND_SWORD);
            sword.addEnchantment(Enchantment.getEnchantmentByLocation("looting"), 2);
            player.setHeldItem(EnumHand.MAIN_HAND, sword);
        }
    }

    //Not sure if this would be needed, but can't be too safe.
    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload evt) {
        if (evt.getWorld() instanceof WorldServer) {
            if (player != null) {
                player.setHeldItem(EnumHand.MAIN_HAND, null);
                player = null;
            }
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
