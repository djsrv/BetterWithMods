package betterwithmods.modules.mechpower.features;

import betterwithmods.base.client.BWStateMapper;
import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.mechpower.blocks.BlockCreativeGenerator;
import betterwithmods.modules.mechpower.blocks.BlockWaterwheel;
import betterwithmods.modules.mechpower.blocks.BlockWindmill;
import betterwithmods.modules.mechpower.client.render.TESRVerticalWindmill;
import betterwithmods.modules.mechpower.client.render.TESRWaterwheel;
import betterwithmods.modules.mechpower.client.render.TESRWindmill;
import betterwithmods.modules.mechpower.items.ItemGenerator;
import betterwithmods.modules.mechpower.tiles.TileEntityCreativeGen;
import betterwithmods.modules.mechpower.tiles.TileEntityWaterwheel;
import betterwithmods.modules.mechpower.tiles.TileEntityWindmillHorizontal;
import betterwithmods.modules.mechpower.tiles.TileEntityWindmillVertical;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Generators extends Feature {
    public static Item MECH_GENERATOR;
    public static Block CREATIVE_GENERATOR;
    public static Block WINDMILL;
    public static Block WATERWHEEL;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MECH_GENERATOR = new ItemGenerator().setRegistryName("windmill");
        CREATIVE_GENERATOR = new BlockCreativeGenerator().setRegistryName("creative_generator");
        WINDMILL = new BlockWindmill().setRegistryName("windmill_block");
        WATERWHEEL = new BlockWaterwheel().setRegistryName("waterwheel");

        registerItem(MECH_GENERATOR);

        registerBlock(CREATIVE_GENERATOR,null);
        registerBlock(WINDMILL,null);
        registerBlock(WATERWHEEL,null);

        registerTile(TileEntityWindmillVertical.class, "bwm.vertWindmill");
        registerTile(TileEntityWindmillHorizontal.class, "bwm.horizWindmill");
        registerTile(TileEntityCreativeGen.class, "creativeGenerator");
        registerTile(TileEntityWaterwheel.class, "bwm.waterwheel");
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(MECH_GENERATOR);


        ModelLoader.setCustomStateMapper(WINDMILL, new BWStateMapper(WINDMILL.getRegistryName().toString()));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillHorizontal.class, new TESRWindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillVertical.class, new TESRVerticalWindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterwheel.class, new TESRWaterwheel());
    }
}
