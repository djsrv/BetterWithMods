package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.mini.BlockMini;
import betterwithmods.base.blocks.mini.ItemBlockMini;
import betterwithmods.base.blocks.mini.TileEntityMultiType;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.core.blocks.mini.BlockCorner;
import betterwithmods.modules.core.blocks.mini.BlockMoulding;
import betterwithmods.modules.core.blocks.mini.BlockSiding;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class MiniBlocks extends Feature {
    public static Block WOOD_SIDING;
    public static Block WOOD_MOULDING;
    public static Block WOOD_CORNER;

    public static Block STONE_SIDING;
    public static Block STONE_MOULDING;
    public static Block STONE_CORNER;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        WOOD_SIDING = new BlockSiding(BlockMini.MINI).setRegistryName("wood_siding");
        WOOD_MOULDING = new BlockMoulding(BlockMini.MINI).setRegistryName("wood_moulding");
        WOOD_CORNER = new BlockCorner(BlockMini.MINI).setRegistryName("wood_corner");

        STONE_SIDING = new BlockSiding(Material.ROCK).setRegistryName("stone_siding");
        STONE_MOULDING = new BlockMoulding(Material.ROCK).setRegistryName("stone_moulding");
        STONE_CORNER = new BlockCorner(Material.ROCK).setRegistryName("stone_corner");

        registerBlock(WOOD_SIDING, new ItemBlockMini(WOOD_SIDING));
        registerBlock(WOOD_MOULDING, new ItemBlockMini(WOOD_MOULDING));
        registerBlock(WOOD_CORNER, new ItemBlockMini(WOOD_CORNER));

        registerBlock(STONE_SIDING, new ItemBlockMini(STONE_SIDING));
        registerBlock(STONE_MOULDING, new ItemBlockMini(STONE_MOULDING));
        registerBlock(STONE_CORNER, new ItemBlockMini(STONE_CORNER));
        registerTile(TileEntityMultiType.class, "bwm.multiType");
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
