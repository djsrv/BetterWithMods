package betterwithmods.modules.aesthetic;

import betterwithmods.base.blocks.mini.TileEntityMultiType;
import betterwithmods.base.modules.Module;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.modules.aesthetic.features.BuildingBlocks;
import betterwithmods.modules.aesthetic.features.ChoppingBlock;
import betterwithmods.modules.aesthetic.features.Debarking;
import betterwithmods.modules.aesthetic.features.Furniture;
import betterwithmods.modules.aesthetic.features.Panes;
import betterwithmods.modules.aesthetic.features.StoneMiniBlocks;
import betterwithmods.modules.aesthetic.features.WoodMiniBlocks;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
        registerFeature(new StoneMiniBlocks());
        registerFeature(new WoodMiniBlocks());
        registerFeature(new BuildingBlocks());
        registerFeature(new Panes());
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        if(ModuleLoader.isFeatureEnabled(WoodMiniBlocks.class) || ModuleLoader.isFeatureEnabled(StoneMiniBlocks.class) )
            GameRegistry.registerTileEntity(TileEntityMultiType.class, "bwm.multiType");
    }
}
