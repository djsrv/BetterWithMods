package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockWoodBench;
import betterwithmods.modules.utilities.blocks.BlockWoodTable;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Furniture extends Feature {
    public static Block WOOD_BENCH;
    public static Block WOOD_TABLE;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        WOOD_BENCH = new BlockWoodBench().setRegistryName("wood_bench");
        WOOD_TABLE = new BlockWoodTable().setRegistryName("wood_table");

        registerBlock(WOOD_BENCH, new ItemBlockMeta(WOOD_BENCH));
        registerBlock(WOOD_TABLE, new ItemBlockMeta(WOOD_TABLE));
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(WOOD_BENCH);
        ModelHandler.setInventoryModel(WOOD_TABLE);
    }
}
