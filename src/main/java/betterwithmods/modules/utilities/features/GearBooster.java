package betterwithmods.modules.utilities.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockGearBoostedRail;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class GearBooster extends Feature {
    public static Block BOOSTER;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BOOSTER = new BlockGearBoostedRail().setRegistryName("booster");
        registerBlock(BOOSTER);
    }
}
