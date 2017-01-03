package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.mini.BlockMini;
import betterwithmods.base.blocks.mini.ItemBlockMini;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.core.blocks.mini.BlockCorner;
import betterwithmods.modules.core.blocks.mini.BlockMoulding;
import betterwithmods.modules.core.blocks.mini.BlockSiding;
import betterwithmods.modules.core.features.Carpentry;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class WoodMiniBlocks extends Feature {
    public static Block WOOD_SIDING;
    public static Block WOOD_MOULDING;
    public static Block WOOD_CORNER;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        WOOD_SIDING = new BlockSiding(BlockMini.MINI).setRegistryName("wood_siding");
        WOOD_MOULDING = new BlockMoulding(BlockMini.MINI).setRegistryName("wood_moulding");
        WOOD_CORNER = new BlockCorner(BlockMini.MINI).setRegistryName("wood_corner");

        registerBlock(WOOD_SIDING, new ItemBlockMini(WOOD_SIDING));
        registerBlock(WOOD_MOULDING, new ItemBlockMini(WOOD_MOULDING));
        registerBlock(WOOD_CORNER, new ItemBlockMini(WOOD_CORNER));

        //TODO recipes
        if(ModuleLoader.isFeatureEnabled(Carpentry.class)) {
        } else {

        }
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(WOOD_SIDING);
        ModelHandler.setInventoryModel(WOOD_MOULDING);
        ModelHandler.setInventoryModel(WOOD_CORNER);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if(ModuleLoader.isFeatureEnabled(HCBouy.class)) {
            HCBouy.registerBuoyancy(WOOD_SIDING, 1.0F);
            HCBouy.registerBuoyancy(WOOD_MOULDING, 1.0F);
            HCBouy.registerBuoyancy(WOOD_CORNER, 1.0F);
        }
    }

}
