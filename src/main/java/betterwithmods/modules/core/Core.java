package betterwithmods.modules.core;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.core.features.Carpentry;
import betterwithmods.modules.core.features.CookingPots;
import betterwithmods.modules.core.features.DispenserBlock;
import betterwithmods.modules.core.features.Hemp;
import betterwithmods.modules.core.features.HopperFilters;
import betterwithmods.modules.core.features.InfernalEnchanter;
import betterwithmods.modules.core.features.Leather;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.core.features.Pottery;
import betterwithmods.modules.core.features.SoulSteel;
import betterwithmods.modules.core.features.Stoking;
import betterwithmods.modules.core.features.events.DropArmor;
import betterwithmods.modules.core.features.events.DropSkull;
import betterwithmods.modules.core.features.events.FoodOffGround;
import betterwithmods.modules.core.features.events.MobSpawnerMoss;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class Core extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new Hemp());

        registerFeature(new Carpentry());

        registerFeature(new Machines());

        registerFeature(new CookingPots());

        registerFeature(new Stoking());

        registerFeature(new Pottery());

        registerFeature(new SoulSteel());

        registerFeature(new HopperFilters());
        registerFeature(new InfernalEnchanter(),false);
        registerFeature(new Leather());

        registerFeature(new DropArmor());
        registerFeature(new DropSkull());
        registerFeature(new FoodOffGround());
        registerFeature(new MobSpawnerMoss());
        registerFeature(new DispenserBlock());
    }
}
