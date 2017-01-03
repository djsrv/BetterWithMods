package betterwithmods.modules.utilities.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockAnchor;
import betterwithmods.modules.core.blocks.BlockPlatform;
import betterwithmods.modules.core.blocks.BlockPulley;
import betterwithmods.modules.core.features.Hemp;
import betterwithmods.modules.core.tiles.TileEntityPulley;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/3/17
 */
public class Pulley extends Feature {
    public static Block PLATFORM;
    public static Block ANCHOR;
    public static Block PULLEY;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ANCHOR = new BlockAnchor().setRegistryName("anchor");
        PULLEY = new BlockPulley().setRegistryName("pulley");
        PLATFORM = new BlockPlatform().setRegistryName("platform");

        registerBlock(PLATFORM);
        registerBlock(ANCHOR);
        registerBlock(PULLEY);

        registerTile(TileEntityPulley.class, "bwm.pulley");
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(ANCHOR);
        ModelHandler.setInventoryModel(PLATFORM);
        ModelHandler.setInventoryModel(PULLEY);
    }

    @Override
    public Class<? extends Feature>[] getDependencies() {
        return new Class[]{Hemp.class};
    }
}
