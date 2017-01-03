package betterwithmods.modules.core.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockSteelAnvil;
import betterwithmods.modules.core.tiles.TileEntitySteelAnvil;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class SoulSteel extends Feature {

    public static Block STEEL_ANVIL;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        STEEL_ANVIL = new BlockSteelAnvil().setRegistryName("steel_anvil");
        registerBlock(STEEL_ANVIL);
        registerTile(TileEntitySteelAnvil.class, "bwm.steelAnvil");
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(STEEL_ANVIL);
    }
}
