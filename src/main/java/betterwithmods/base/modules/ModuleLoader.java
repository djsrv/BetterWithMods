/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Quark Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Quark
 *
 * Quark is Open Source and distributed under the
 * CC-BY-NC-SA 3.0 License: https://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB
 *
 * File Created @ [18/03/2016, 21:52:08 (GMT)]
 */
package betterwithmods.base.modules;

import betterwithmods.base.BWMod;
import betterwithmods.modules.advancedmechpower.AdvancedMechPower;
import betterwithmods.modules.aesthetic.Aesthetics;
import betterwithmods.modules.core.Core;
import betterwithmods.modules.hardcore.Hardcore;
import betterwithmods.modules.integration.Integration;
import betterwithmods.modules.recipes.Recipes;
import betterwithmods.modules.tweaks.Tweaks;
import betterwithmods.modules.utilities.Utilities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class ModuleLoader {

    static {
        moduleClasses = new ArrayList();

        registerModule(Core.class);
        registerModule(Hardcore.class);
        registerModule(Tweaks.class);
        registerModule(Recipes.class);
        registerModule(Integration.class);
        registerModule(AdvancedMechPower.class);
        registerModule(Aesthetics.class);
        registerModule(Tweaks.class);
        registerModule(Utilities.class);

    }

    private static List<Class<? extends Module>> moduleClasses;
    public static Map<Class<? extends Module>, Module> moduleInstances = new HashMap();
    public static Map<Class<? extends Feature>, Feature> featureInstances = new HashMap();
    public static List<Module> enabledModules;

    public static Configuration config;
    public static File configFile;

    public static void preInit(FMLPreInitializationEvent event) {
        moduleClasses.forEach(clazz -> {
            try {
                moduleInstances.put(clazz, clazz.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Can't initialize module " + clazz, e);
            }
        });

        setupConfig(event);

        forEachModule(module -> FMLLog.info("[%s] Module %s is %s",BWMod.MODID,module.name,(module.enabled ? "enabled" : "disabled")));

        forEachEnabled(module -> module.preInit(event));
    }

    public static void init(FMLInitializationEvent event) {
        forEachEnabled(module -> module.init(event));
    }

    public static void postInit(FMLPostInitializationEvent event) {
        forEachEnabled(module -> module.postInit(event));
    }

    @SideOnly(Side.CLIENT)
    public static void preInitClient(FMLPreInitializationEvent event) {
        forEachEnabled(module -> module.preInitClient(event));
    }

    @SideOnly(Side.CLIENT)
    public static void initClient(FMLInitializationEvent event) {
        forEachEnabled(module -> module.initClient(event));
    }

    @SideOnly(Side.CLIENT)
    public static void postInitClient(FMLPostInitializationEvent event) {
        forEachEnabled(module -> module.postInitClient(event));
    }

    public static void serverStarting(FMLServerStartingEvent event) {
        forEachEnabled(module -> module.serverStarting(event));
    }

    public static void setupConfig(FMLPreInitializationEvent event) {
        configFile = event.getSuggestedConfigurationFile();
        config = new Configuration(configFile);
        config.load();

        forEachModule(module -> {
            module.enabled = true;
            if(module.canBeDisabled()) {
                ConfigHelper.needsRestart = true;
                module.enabled = ConfigHelper.loadPropBool(module.name, "_modules", module.getModuleDescription(), module.isEnabledByDefault());
            }
        });

        enabledModules = new ArrayList(moduleInstances.values());
        enabledModules.removeIf(module -> !module.enabled);

        loadModuleConfigs();

        MinecraftForge.EVENT_BUS.register(new ChangeListener());
    }

    private static void loadModuleConfigs() {
        forEachModule(module -> module.setupConfig());

        if(config.hasChanged())
            config.save();
    }

    public static boolean isModuleEnabled(Class<? extends Module> clazz) {
        return moduleInstances.get(clazz).enabled;
    }

    public static boolean isFeatureEnabled(Class<? extends Feature> clazz) {
        return featureInstances.get(clazz).enabled;
    }

    public static void forEachModule(Consumer<Module> consumer) {
        moduleInstances.values().forEach(consumer);
    }

    public static void forEachEnabled(Consumer<Module> consumer) {
        enabledModules.forEach(consumer);
    }

    private static void registerModule(Class<? extends Module> clazz) {
        if(!moduleClasses.contains(clazz))
            moduleClasses.add(clazz);
    }

    public static class ChangeListener {

        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
            if(eventArgs.getModID().equals(BWMod.MODID))
                loadModuleConfigs();
        }

    }

}