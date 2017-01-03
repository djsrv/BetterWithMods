package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.aesthetic.blocks.BlockDebarkedNew;
import betterwithmods.modules.aesthetic.blocks.BlockDebarkedOld;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Debarking extends Feature {
    public static Block DEBARKED_NEW;
    public static Block DEBARKED_OLD;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DEBARKED_NEW = new BlockDebarkedNew().setRegistryName("debarked_new");
        DEBARKED_OLD = new BlockDebarkedOld().setRegistryName("debarked_old");
        registerBlock(DEBARKED_NEW, new ItemBlockMeta(DEBARKED_NEW));
        registerBlock(DEBARKED_OLD, new ItemBlockMeta(DEBARKED_OLD));
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(DEBARKED_NEW);
        ModelHandler.setInventoryModel(DEBARKED_OLD);
    }

    //EVENT TODO
    public void debark() {

    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
