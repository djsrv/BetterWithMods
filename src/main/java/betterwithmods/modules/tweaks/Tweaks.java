package betterwithmods.modules.tweaks;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.tweaks.feature.Dung;
import betterwithmods.modules.tweaks.feature.FleeAttack;
import betterwithmods.modules.tweaks.feature.NetherSpawn;
import betterwithmods.modules.tweaks.feature.ShearCreeper;
import betterwithmods.modules.tweaks.feature.SlimeSpawn;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */

public class Tweaks extends Module{
    @Override
    public void addFeatures() {
        registerFeature(new Dung());
        registerFeature(new FleeAttack());
        registerFeature(new NetherSpawn());
        registerFeature(new ShearCreeper());
        registerFeature(new SlimeSpawn());
    }
}
