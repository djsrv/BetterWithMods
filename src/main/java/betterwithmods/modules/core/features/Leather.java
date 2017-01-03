package betterwithmods.modules.core.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Leather extends Feature {
    public static Item SCOURED_LEATHER, TANNED_LEATHER;
    public static Item LEATHER_CUT,SCOURED_LEATHER_CUT,TANNED_LEATHER_CUT;
    public static Item LEATHER_BELT, LEATHER_STRAP;
    public static Item GLUE,TALLOW;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        //TODO create leather stuff
    }

    @Override
    public void init(FMLInitializationEvent event) {

        HCBouy.registerBuoyancy(SCOURED_LEATHER, 1.0F);
        HCBouy.registerBuoyancy(TANNED_LEATHER, 1.0F);

        HCBouy.registerBuoyancy(LEATHER_BELT, 1.0F);
        HCBouy.registerBuoyancy(LEATHER_STRAP, 1.0F);

        HCBouy.registerBuoyancy(LEATHER_CUT, 1.0F);
        HCBouy.registerBuoyancy(TANNED_LEATHER_CUT, 1.0F);
        HCBouy.registerBuoyancy(SCOURED_LEATHER_CUT, 1.0F);

        HCBouy.registerBuoyancy(GLUE, 0.0F);
        HCBouy.registerBuoyancy(TALLOW, 1.0F);
    }
}
