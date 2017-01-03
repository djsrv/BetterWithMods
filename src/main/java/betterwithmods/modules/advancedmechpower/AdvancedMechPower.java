package betterwithmods.modules.advancedmechpower;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.advancedmechpower.features.AdvancedTransfer;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class AdvancedMechPower extends Module {

    @Override
    public void addFeatures() {
        registerFeature(new AdvancedTransfer());
    }
}
