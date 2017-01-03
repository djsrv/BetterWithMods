package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.aesthetic.blocks.BlockChoppingBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class ChoppingBlock extends Feature {
    public static Block CHOPPING_BLOCK;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        //TODO registry
        CHOPPING_BLOCK = new BlockChoppingBlock().setRegistryName("chopping_block");
        registerBlock(CHOPPING_BLOCK);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(CHOPPING_BLOCK);
    }
}
