package betterwithmods.modules.core.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockCookingPot;
import betterwithmods.modules.core.client.render.model.TESRCauldron;
import betterwithmods.modules.core.client.render.model.TESRCrucible;
import betterwithmods.modules.core.tiles.TileEntityCauldron;
import betterwithmods.modules.core.tiles.TileEntityCrucible;
import net.minecraft.block.Block;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class CookingPots extends Feature {
    public static Block COOKING_POTS;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        COOKING_POTS = new BlockCookingPot().setRegistryName("cooking_pot");
        registerBlock(COOKING_POTS,new ItemBlockMeta(COOKING_POTS));
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrucible.class, new TESRCrucible());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new TESRCauldron());
    }
}
