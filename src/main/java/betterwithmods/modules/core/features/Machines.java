package betterwithmods.modules.core.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockFilteredHopper;
import betterwithmods.modules.core.blocks.BlockMill;
import betterwithmods.modules.core.blocks.BlockTurntable;
import betterwithmods.modules.core.client.render.model.TESRFilteredHopper;
import betterwithmods.modules.core.client.render.model.TESRTurntable;
import betterwithmods.modules.core.tiles.TileEntityFilteredHopper;
import betterwithmods.modules.core.tiles.TileEntityMill;
import betterwithmods.modules.core.tiles.TileEntityTurntable;
import net.minecraft.block.Block;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Machines extends Feature {

    public static Block MILL;
    public static Block FILTERED_HOPPER;
    public static Block TURNTABLE;


    public static double upSpeed, downSpeed;
    public static int maxPlatforms;

    //TODO
    public static boolean dropsMill;
    public static boolean dropsPulley;
    public static boolean dropsHopper;
    public static boolean dropsTurntable;


    @Override
    public void setupConfig() {
        upSpeed = loadPropDouble("Vertical Machines Speed Up", "The speed at which the pulley rope and platform moves up", 0.1D, 0.0D, 1.0D);
        downSpeed = loadPropDouble("Vertical Machines Speed Down", "The speed at which the pulley rope and platform moves down", 0.1D, 0.0D, 1.0D);
        maxPlatforms = loadPropInt("Max Platforms", "Max Platforms that can be attached to a pulley", 128);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MILL = new BlockMill().setRegistryName("millstone");
        FILTERED_HOPPER = new BlockFilteredHopper().setRegistryName("filtered_hopper");
        TURNTABLE = new BlockTurntable().setRegistryName("turntable");

        registerBlock(MILL);
        registerBlock(FILTERED_HOPPER);
        registerBlock(TURNTABLE);

        registerTile(TileEntityMill.class, "bwm.millstone");
        registerTile(TileEntityFilteredHopper.class, "bwm.hopper");
        registerTile(TileEntityTurntable.class, "bwm.turntable");
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilteredHopper.class, new TESRFilteredHopper());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurntable.class, new TESRTurntable());


        ModelHandler.setInventoryModel(MILL);
        ModelHandler.setInventoryModel(FILTERED_HOPPER);
        ModelHandler.setInventoryModel(TURNTABLE);
    }
}
