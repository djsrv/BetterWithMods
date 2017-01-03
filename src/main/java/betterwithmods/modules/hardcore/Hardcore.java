package betterwithmods.modules.hardcore;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.hardcore.feature.HCBeds;
import betterwithmods.modules.hardcore.feature.HCBouy;
import betterwithmods.modules.hardcore.feature.HCBuckets;
import betterwithmods.modules.hardcore.feature.HCDiamond;
import betterwithmods.modules.hardcore.feature.HCEndermen;
import betterwithmods.modules.hardcore.feature.HCGunpowder;
import betterwithmods.modules.hardcore.feature.HCHardness;
import betterwithmods.modules.hardcore.feature.HCHunger;
import betterwithmods.modules.hardcore.feature.HCLumber;
import betterwithmods.modules.hardcore.feature.HCMelon;
import betterwithmods.modules.hardcore.feature.HCOre;
import betterwithmods.modules.hardcore.feature.HCRedstone;
import betterwithmods.modules.hardcore.feature.HCSpawn;
import betterwithmods.modules.hardcore.feature.HCStructures;
import betterwithmods.modules.hardcore.feature.HCStumping;
import betterwithmods.modules.hardcore.feature.HCTools;
import betterwithmods.base.util.item.ToolsManager;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class Hardcore extends Module {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        // Cache the registry used for iterations
        ToolsManager.itemRegistry = GameRegistry.findRegistry(Item.class);
        super.preInit(event);
    }

    @Override
    public void addFeatures() {
        registerFeature(new HCBeds());
        registerFeature(new HCBouy());
        registerFeature(new HCBuckets());
        registerFeature(new HCDiamond());
        registerFeature(new HCEndermen());
        registerFeature(new HCGunpowder());
        registerFeature(new HCHardness());
        registerFeature(new HCHunger());
        registerFeature(new HCLumber());
        registerFeature(new HCMelon());
        registerFeature(new HCOre());
        registerFeature(new HCRedstone());
        registerFeature(new HCSpawn());
        registerFeature(new HCStructures());
        registerFeature(new HCStumping());
        registerFeature(new HCTools());
    }
}
