package betterwithmods.modules.mechpower.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.mechpower.blocks.BlockCrank;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class HandCrank extends Feature {
    public static Block HAND_CRANK;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        HAND_CRANK = new BlockCrank().setRegistryName("hand_crank");
        registerBlock(HAND_CRANK);
    }
}
