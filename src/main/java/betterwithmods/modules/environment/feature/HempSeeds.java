package betterwithmods.modules.environment.feature;

import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.base.modules.Feature;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HempSeeds extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        MinecraftForge.addGrassSeed(new ItemStack(BWMBlocks.HEMP, 1, 0), 5);
    }
}
