package betterwithmods.modules.mechpower;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.mechpower.features.Generators;
import betterwithmods.modules.mechpower.features.HandCrank;
import betterwithmods.modules.mechpower.features.Transfer;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class MechPower extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new Generators());
        registerFeature(new HandCrank());
        registerFeature(new Transfer());

    }
}
