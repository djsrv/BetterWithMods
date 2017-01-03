package betterwithmods.modules.utilities;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.utilities.features.BreedingHardness;
import betterwithmods.modules.utilities.features.EnderSpectacles;
import betterwithmods.modules.utilities.features.Explosives;
import betterwithmods.modules.utilities.features.Fertilizer;
import betterwithmods.modules.utilities.features.Food;
import betterwithmods.modules.utilities.features.GearBooster;
import betterwithmods.modules.utilities.features.Redstone;
import betterwithmods.modules.utilities.features.ScrewPump;
import betterwithmods.modules.utilities.features.Tools;
import betterwithmods.modules.utilities.features.VineTrap;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Utilities extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new BreedingHardness());
        registerFeature(new EnderSpectacles());
        registerFeature(new Explosives());
        registerFeature(new Fertilizer());
        registerFeature(new Food());
        registerFeature(new GearBooster());
        registerFeature(new Redstone());
        registerFeature(new ScrewPump());
        registerFeature(new Tools());
        registerFeature(new VineTrap());
    }
}
