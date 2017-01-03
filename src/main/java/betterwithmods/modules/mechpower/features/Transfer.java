package betterwithmods.modules.mechpower.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.mechpower.blocks.BlockAxle;
import betterwithmods.modules.mechpower.blocks.BlockGearbox;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Transfer extends Feature {
    public static Block AXLE;
    public static Block GEARBOX;
    public static boolean dropsGearbox;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        AXLE = new BlockAxle().setRegistryName("axle");
        GEARBOX = new BlockGearbox().setRegistryName("gearbox");

        registerBlock(AXLE);
        registerBlock(GEARBOX);
    }
}
