package betterwithmods.modules.core.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockAnchor;
import betterwithmods.modules.core.blocks.BlockMechMachines;
import betterwithmods.modules.core.blocks.BlockPlatform;
import betterwithmods.modules.core.blocks.BlockRope;
import betterwithmods.modules.core.client.render.RenderExtendingRope;
import betterwithmods.modules.core.client.render.model.TESRFilteredHopper;
import betterwithmods.modules.core.client.render.model.TESRTurntable;
import betterwithmods.modules.core.entities.EntityExtendingRope;
import betterwithmods.modules.core.tiles.TileEntityFilteredHopper;
import betterwithmods.modules.core.tiles.TileEntityMill;
import betterwithmods.modules.core.tiles.TileEntityPulley;
import betterwithmods.modules.core.tiles.TileEntityTurntable;
import net.minecraft.block.Block;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class MechanicalBlocks extends Feature {

    //TODO would love to be able to separate the pulley from here
    public static Block PLATFORM;
    public static Block SINGLE_MACHINES;
    public static Block ANCHOR;
    public static Block ROPE;

    public static double upSpeed, downSpeed;
    public static int maxPlatforms;

    //TODO
    public static boolean dropsMill;
    public static boolean dropsPulley;
    public static boolean dropsHopper;
    public static boolean dropsTurntable;


    @Override
    public void setupConfig() {
        upSpeed = loadPropDouble("Vertical MechanicalBlocks Speed Up", "The speed at which the pulley rope and platform moves up", 0.1D, 0.0D, 1.0D);
        downSpeed = loadPropDouble("Vertical MechanicalBlocks Speed Down", "The speed at which the pulley rope and platform moves down", 0.1D, 0.0D, 1.0D);
        maxPlatforms = loadPropInt("Max Platforms", "Max Platforms that can be attached to a pulley", 128);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        SINGLE_MACHINES = new BlockMechMachines().setRegistryName("single_machine");
        ANCHOR = new BlockAnchor().setRegistryName("anchor");
        ROPE = new BlockRope().setRegistryName("rope");
        PLATFORM = new BlockPlatform().setRegistryName("platform");

        registerBlock(PLATFORM);
        registerBlock(ANCHOR);
        registerBlock(ROPE);
        registerBlock(SINGLE_MACHINES, new ItemBlockMeta(SINGLE_MACHINES));

        registerTile(TileEntityMill.class, "bwm.millstone");
        registerTile(TileEntityPulley.class, "bwm.pulley");
        registerTile(TileEntityFilteredHopper.class, "bwm.hopper");
        registerTile(TileEntityTurntable.class, "bwm.turntable");
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilteredHopper.class, new TESRFilteredHopper());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurntable.class, new TESRTurntable());

        RenderingRegistry.registerEntityRenderingHandler(EntityExtendingRope.class, RenderExtendingRope::new);
    }
}
