package betterwithmods.modules.core.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.client.ColorHandlers;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockPlanter;
import betterwithmods.modules.core.blocks.BlockUnfiredPottery;
import betterwithmods.modules.core.blocks.BlockUrn;
import betterwithmods.modules.core.blocks.BlockVase;
import betterwithmods.modules.core.blocks.ItemBlockPlanter;
import betterwithmods.modules.core.tiles.TileEntityVase;
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
public class Pottery extends Feature {
    public static Block PLANTER;
    public static Block VASE;
    public static Block URN;
    public static Block UNFIRED_POTTERY;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        PLANTER = new BlockPlanter().setRegistryName("planter");
        VASE = new BlockVase().setRegistryName("vase");
        URN = new BlockUrn().setRegistryName("urn");
        UNFIRED_POTTERY = new BlockUnfiredPottery().setRegistryName("unfired_pottery");



        registerBlock(PLANTER, new ItemBlockPlanter(PLANTER));
        registerBlock(VASE, new ItemBlockMeta(VASE));
        registerBlock(URN, new ItemBlockMeta(URN));
        registerBlock(UNFIRED_POTTERY, new ItemBlockMeta(UNFIRED_POTTERY));

        registerTile(TileEntityVase.class,  "bwm.vase");

    }

    @Override
    public void initClient(FMLInitializationEvent event) {
        final BlockColors col = Minecraft.getMinecraft().getBlockColors();
        final ItemColors itCol = Minecraft.getMinecraft().getItemColors();

        col.registerBlockColorHandler(ColorHandlers.BlockPlanterColor, PLANTER);
        itCol.registerItemColorHandler(ColorHandlers.ItemPlanterColor, PLANTER);

    }
}
