package betterwithmods.modules.utilities.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockPump;
import betterwithmods.modules.core.blocks.BlockTemporaryWater;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class ScrewPump extends Feature {
    public static Block PUMP;
    public static BlockLiquid TEMP_LIQUID_SOURCE;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        PUMP = new BlockPump().setRegistryName("screw_pump");
        TEMP_LIQUID_SOURCE = (BlockLiquid) new BlockTemporaryWater().setRegistryName("temporary_water");

        registerBlock(PUMP);
        registerBlock(TEMP_LIQUID_SOURCE, null);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

    }
}
