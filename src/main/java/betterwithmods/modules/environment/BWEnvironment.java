package betterwithmods.modules.environment;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.environment.feature.BlastingOil;
import betterwithmods.modules.environment.feature.Dung;
import betterwithmods.modules.environment.feature.FleeAttack;
import betterwithmods.modules.environment.feature.HempSeeds;
import betterwithmods.modules.environment.feature.NetherSpawn;
import betterwithmods.modules.environment.feature.RawEgg;
import betterwithmods.modules.environment.feature.ShearCreeper;
import betterwithmods.modules.environment.feature.SlimeSpawn;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */

public class BWEnvironment extends Module{
    @Override
    public void addFeatures() {
        registerFeature(new BlastingOil(),"blasting_oil_explodes_on_impact");
        registerFeature(new Dung());
        registerFeature(new FleeAttack());
        registerFeature(new HempSeeds());
        registerFeature(new NetherSpawn());
        registerFeature(new RawEgg());
        registerFeature(new ShearCreeper());
        registerFeature(new SlimeSpawn());
    }
}
