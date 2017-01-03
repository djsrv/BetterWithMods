package betterwithmods.modules.advancedmechpower.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.advancedmechpower.blocks.BlockAdvGearbox;
import betterwithmods.modules.advancedmechpower.tiles.TileEntityAdvancedGearbox;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class AdvancedTransfer extends Feature {
    public static Block ADVANCED_GEARBOX;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ADVANCED_GEARBOX = new BlockAdvGearbox().setRegistryName("advanced_gearbox");
        registerBlock(ADVANCED_GEARBOX);
        registerTile(TileEntityAdvancedGearbox.class, "bwm.gearbox");
    }

}
