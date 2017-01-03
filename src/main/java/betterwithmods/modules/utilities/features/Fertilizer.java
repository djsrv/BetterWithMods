package betterwithmods.modules.utilities.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockFertileFarmland;
import betterwithmods.modules.utilities.items.ItemFertilizer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Fertilizer extends Feature {
    public static Item FERTILIZER;
    public static Block FERTILE_FARMLAND;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        FERTILIZER = new ItemFertilizer().setRegistryName("fertilizer");
        FERTILE_FARMLAND = new BlockFertileFarmland().setRegistryName("fertile_farmland");
        registerItem(FERTILIZER);
        registerBlock(FERTILE_FARMLAND);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(FERTILIZER);
    }
}
