package betterwithmods.modules.aesthetic;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.aesthetic.features.BuildingBlocks;
import betterwithmods.modules.aesthetic.features.ChoppingBlock;
import betterwithmods.modules.aesthetic.features.Debarking;
import betterwithmods.modules.aesthetic.features.Furniture;
import betterwithmods.modules.aesthetic.features.MiniBlocks;
import betterwithmods.modules.aesthetic.features.Panes;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Aesthetics extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new BuildingBlocks());
        registerFeature(new ChoppingBlock());
        registerFeature(new Debarking());
        registerFeature(new Furniture());
        registerFeature(new MiniBlocks());
        registerFeature(new BuildingBlocks());
        registerFeature(new Panes());


    }
}
