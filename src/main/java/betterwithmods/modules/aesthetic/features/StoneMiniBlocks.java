package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.mini.ItemBlockMini;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.core.blocks.mini.BlockCorner;
import betterwithmods.modules.core.blocks.mini.BlockMoulding;
import betterwithmods.modules.core.blocks.mini.BlockSiding;
import betterwithmods.modules.core.features.SoulSteel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class StoneMiniBlocks extends Feature {

    public static Block STONE_SIDING;
    public static Block STONE_MOULDING;
    public static Block STONE_CORNER;

    @Override
    public void preInit(FMLPreInitializationEvent event) {


        STONE_SIDING = new BlockSiding(Material.ROCK).setRegistryName("stone_siding");
        STONE_MOULDING = new BlockMoulding(Material.ROCK).setRegistryName("stone_moulding");
        STONE_CORNER = new BlockCorner(Material.ROCK).setRegistryName("stone_corner");



        registerBlock(STONE_SIDING, new ItemBlockMini(STONE_SIDING));
        registerBlock(STONE_MOULDING, new ItemBlockMini(STONE_MOULDING));
        registerBlock(STONE_CORNER, new ItemBlockMini(STONE_CORNER));
        //TODO recipes
        if(ModuleLoader.isFeatureEnabled(SoulSteel.class)) {
        } else {

        }
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(STONE_CORNER);
        ModelHandler.setInventoryModel(STONE_SIDING);
        ModelHandler.setInventoryModel(STONE_MOULDING);
    }

}
