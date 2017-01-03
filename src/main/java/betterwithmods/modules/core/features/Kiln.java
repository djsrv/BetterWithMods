package betterwithmods.modules.core.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockKiln;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Kiln extends Feature {
    public static Block KILN;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        KILN = new BlockKiln().setRegistryName("kiln");
        registerBlock(KILN, null);
    }
}
