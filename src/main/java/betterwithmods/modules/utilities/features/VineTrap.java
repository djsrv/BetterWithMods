package betterwithmods.modules.utilities.features;

import betterwithmods.base.client.ColorHandlers;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockVineTrap;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class VineTrap extends Feature {

    public static Block VINE_TRAP;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        VINE_TRAP = new BlockVineTrap().setRegistryName("vine_trap");
        registerBlock(VINE_TRAP);

    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
    }

    @Override
    public void initClient(FMLInitializationEvent event) {
        final BlockColors col = Minecraft.getMinecraft().getBlockColors();
        final ItemColors itCol = Minecraft.getMinecraft().getItemColors();
        itCol.registerItemColorHandler(ColorHandlers.ItemFoliageColor, VINE_TRAP);
        col.registerBlockColorHandler(ColorHandlers.BlockFoliageColor, VINE_TRAP);
    }
}
