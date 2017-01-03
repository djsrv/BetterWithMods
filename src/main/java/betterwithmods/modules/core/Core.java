package betterwithmods.modules.core;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.core.features.Carpentry;
import betterwithmods.modules.core.features.CookingPots;
import betterwithmods.modules.core.features.DispenserBlock;
import betterwithmods.modules.core.features.HopperFilters;
import betterwithmods.modules.core.features.InfernalEnchanter;
import betterwithmods.modules.core.features.Leather;
import betterwithmods.modules.core.features.MechanicalBlocks;
import betterwithmods.modules.core.features.Pottery;
import betterwithmods.modules.core.features.SteelAnvil;
import betterwithmods.modules.core.features.Stoking;
import betterwithmods.modules.core.features.events.DropArmor;
import betterwithmods.modules.core.features.events.DropSkull;
import betterwithmods.modules.core.features.events.FoodOffGround;
import betterwithmods.modules.core.features.events.MobSpawnerMoss;
import betterwithmods.modules.core.features.Hellfire;
import betterwithmods.modules.core.features.Hemp;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class Core extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new Carpentry());
        registerFeature(new CookingPots());
        registerFeature(new HopperFilters());
        registerFeature(new InfernalEnchanter(),false);
        registerFeature(new Leather());
        registerFeature(new MechanicalBlocks());
        registerFeature(new Pottery());
        registerFeature(new SteelAnvil());
        registerFeature(new Stoking());
        registerFeature(new DropArmor());
        registerFeature(new DropSkull());
        registerFeature(new FoodOffGround());
        registerFeature(new MobSpawnerMoss());
        registerFeature(new Hellfire());
        registerFeature(new Hemp());
        registerFeature(new DispenserBlock());
    }
}
