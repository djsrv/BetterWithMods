package betterwithmods.modules.core.features;

import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockHemp;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Hemp extends Feature {
    public static Block HEMP;
    public static Item HEMP_LEAF;

    public boolean dropSeeds;
    @Override
    public void setupConfig() {
        dropSeeds = loadPropBool("Drop Hemp Seeds","Allow Hemp Seeds to drop when breaking Tall Grass",true);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
         HEMP = new BlockHemp().setRegistryName("hemp_seed");
        HEMP_LEAF = new Item().setRegistryName("hemp");
        registerBlock(HEMP);
        registerItem(HEMP_LEAF);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        if(dropSeeds) {
            MinecraftForge.addGrassSeed(new ItemStack(HEMP, 1, 0), 5);
        }
        HCBouy.registerBuoyancy(HEMP, 1.0F);
    }
}
