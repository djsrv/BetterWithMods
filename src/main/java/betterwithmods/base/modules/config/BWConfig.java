package betterwithmods.base.modules.config;

import betterwithmods.base.BWMod;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class BWConfig {
    public static final String HARDCORE = "Hardcore";
    public static final String VANILLA_TWEAKS = "Vanilla Tweaks";
    public static final String MODPACK_TWEAKS = "Modpack Tweaks";
    public static final String DEBUG = "Debug";
    public static final String PULLEY = "Pulley";
    public static final String MOD_COMPAT = "Mod Compat";
    public static ConfigCategory HARDCORE_CAT;
    public static Configuration config;
    public static boolean dropsGearbox;
    public static boolean dropsSaw;
    public static boolean dropsPulley;
    public static boolean dropsHopper;
    public static boolean dropsTurntable;
    public static boolean dropsMill;
    public static int reclaimCount;
    public static boolean debug;
    public static boolean dumpBlockData;
    public static int maxPlatformBlocks;
    public static float upSpeed;
    public static float downSpeed;
    public static int lensRange;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    private static void syncConfig() {
        dropsGearbox = config.get(MODPACK_TWEAKS, "Gearbox generating drops when overpowered", true).getBoolean();
        dropsSaw = config.get(MODPACK_TWEAKS, "Saw generating drops when overpowered", true).getBoolean();
        dropsHopper = config.get(MODPACK_TWEAKS, "Hopper generating drops when overpowered", true).getBoolean();
        dropsPulley = config.get(MODPACK_TWEAKS, "Pulley generating drops when overpowered", true).getBoolean();
        dropsMill = config.get(MODPACK_TWEAKS, "Mill generating drops when overpowered", true).getBoolean();
        dropsTurntable = config.get(MODPACK_TWEAKS, "Turntable generating drops when overpowered", true).getBoolean();


        debug = config.get(DEBUG, "Debug Mode", false, "Prints Fake Player IDs to console.").getBoolean();
        dumpBlockData = config
                .get(DEBUG, "Dump Platform Block Data", false,
                        "Dumps the platform entity's block information in xxd format when the world is saved.")
                .getBoolean();
//
        maxPlatformBlocks = config.get(PULLEY, "Max Platform Blocks", 128).getInt(128);
        upSpeed = config.getFloat("Vertical speed up", PULLEY, 0.1F, 0.0F, 1.0F, "The speed at which the pulley rope and platform moves up");
        downSpeed = config.getFloat("Vertical speed down", PULLEY, 0.1F, 0.0F, 1.0F, "The speed at which the pulley rope and platform moves down");

        lensRange = config.getInt("Lens Horizontal Range", Configuration.CATEGORY_GENERAL, 256, 32, 256, "Range that lens light will travel");

        if(config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public void onConfigChanged(OnConfigChangedEvent eventArgs) {
        if (eventArgs.getModID().equals(BWMod.MODID))
            syncConfig();
    }
}
