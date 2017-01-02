package betterwithmods.modules.automation;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.automation.features.BlockDispenserPlacing;
import betterwithmods.modules.automation.features.BreedingHardness;
import betterwithmods.modules.automation.features.DropArmor;
import betterwithmods.modules.automation.features.DropSkull;
import betterwithmods.modules.automation.features.FoodOffGround;
import betterwithmods.modules.automation.features.HopperFilters;
import betterwithmods.modules.automation.features.MobSpawnerMoss;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class BWAutomation extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new BreedingHardness());
        registerFeature(new MobSpawnerMoss());
        registerFeature(new BlockDispenserPlacing());
        registerFeature(new DropArmor());
        registerFeature(new DropSkull());
        registerFeature(new FoodOffGround());
        registerFeature(new HopperFilters());
    }
}
