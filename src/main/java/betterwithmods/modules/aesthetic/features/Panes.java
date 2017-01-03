package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.BWMBlockPane;
import betterwithmods.base.blocks.ItemBlockPane;
import betterwithmods.base.modules.Feature;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Panes extends Feature {
    public static Block WICKER;
    public static Block GRATE;
    public static Block SLATS;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        WICKER = new BWMBlockPane().setRegistryName("wicker");
        GRATE = new BWMBlockPane().setRegistryName("grate");
        SLATS = new BWMBlockPane().setRegistryName("slats");

        registerBlock(WICKER, new ItemBlockPane(WICKER));
        registerBlock(GRATE, new ItemBlockPane(GRATE));
        registerBlock(SLATS, new ItemBlockPane(SLATS));
    }
}
