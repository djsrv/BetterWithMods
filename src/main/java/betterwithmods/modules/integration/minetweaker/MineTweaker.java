package betterwithmods.modules.integration.minetweaker;

import betterwithmods.base.modules.Feature;
import minetweaker.MineTweakerAPI;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by tyler on 9/4/16.
 */
@SuppressWarnings("unused")
public class MineTweaker extends Feature {
    public static final String MODID = "MineTweaker3";

    @Override
    public void init(FMLInitializationEvent event) {
        MineTweakerAPI.registerClass(Saw.class);
        MineTweakerAPI.registerClass(Kiln.class);
        MineTweakerAPI.registerClass(Cauldron.class);
        MineTweakerAPI.registerClass(Crucible.class);
        MineTweakerAPI.registerClass(StokedCauldron.class);
        MineTweakerAPI.registerClass(StokedCrucible.class);
        MineTweakerAPI.registerClass(Mill.class);
//        MineTweakerAPI.registerClass(Buoyancy.class);
//        MineTweakerAPI.registerClass(HopperFilter.class);
//        MineTweakerAPI.registerClass(SteelAnvil.class);
    }

}
