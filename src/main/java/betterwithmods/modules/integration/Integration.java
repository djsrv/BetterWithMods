package betterwithmods.modules.integration;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.ConfigHelper;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.modules.Module;
import betterwithmods.modules.integration.minetweaker.MineTweaker;
import betterwithmods.modules.integration.tcon.TConstruct;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Integration extends Module {
    @Override
    public void addFeatures() {
        registerCompatFeature("biomesoplenty", BiomesOPlenty.class);
        registerCompatFeature("harvestcraft", Harvestcraft.class);
//        registerCompatFeature("immersiveengineering", ImmersiveEngineering.class);
        registerCompatFeature("MineTweaker3", MineTweaker.class);
        registerCompatFeature("Quark", Quark.class);
        registerCompatFeature("tconstruct", TConstruct.class);
        registerCompatFeature("nethercore", NetherCore.class);
    }

    public void registerCompatFeature(String modid, Class<? extends Feature> feature) {
        if (Loader.isModLoaded(modid)) {
            try {
                super.registerFeature(feature.newInstance(), modid.toLowerCase() + "_compat");
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        } else {
            FMLLog.info("[%s] '%s' could not load due to %s not being loaded", BWMod.MODID, feature.getSimpleName(), modid);
        }
    }


    @Override
    public void setupConfig() {
        if (features.isEmpty())
            addFeatures();

        forEachFeature(feature -> {
            ConfigHelper.needsRestart = feature.requiresMinecraftRestartToEnable();
            feature.enabled = loadPropBool(feature.configName, feature.getFeatureDescription(), feature.enabledByDefault) && enabled;

            feature.setupConstantConfig();

            if (!feature.forceLoad) {


                String[] incompatibilities = feature.getIncompatibleMods();
                if (incompatibilities != null) {
                    List<String> failiures = new ArrayList();

                    for (String s : incompatibilities)
                        if (Loader.isModLoaded(s)) {
                            feature.enabled = false;
                            failiures.add(s);
                        }

                    if (!failiures.isEmpty())
                        FMLLog.info("[%s] '%s' is forcefully disabled as it's incompatible with the following loaded mods: %s", BWMod.MODID, feature.configName, failiures);
                }
            }

            if (!feature.loadtimeDone) {
                feature.enabledAtLoadtime = feature.enabled;
                feature.loadtimeDone = true;
            }

            if (feature.enabled && !enabledFeatures.contains(feature))
                enabledFeatures.add(feature);
            else if (!feature.enabled && enabledFeatures.contains(feature))
                enabledFeatures.remove(feature);

            feature.setupConfig();

            if (!feature.enabled && feature.prevEnabled) {
                if (feature.hasSubscriptions())
                    MinecraftForge.EVENT_BUS.unregister(feature);
                if (feature.hasTerrainSubscriptions())
                    MinecraftForge.TERRAIN_GEN_BUS.unregister(feature);
                if (feature.hasOreGenSubscriptions())
                    MinecraftForge.ORE_GEN_BUS.unregister(feature);
            } else if (feature.enabled && (feature.enabledAtLoadtime || !feature.requiresMinecraftRestartToEnable()) && !feature.prevEnabled) {
                if (feature.hasSubscriptions())
                    MinecraftForge.EVENT_BUS.register(feature);
                if (feature.hasTerrainSubscriptions())
                    MinecraftForge.TERRAIN_GEN_BUS.register(feature);
                if (feature.hasOreGenSubscriptions())
                    MinecraftForge.ORE_GEN_BUS.register(feature);
            }

            feature.prevEnabled = feature.enabled;
        });
    }

}
