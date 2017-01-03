package betterwithmods.modules.core.features;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.core.blocks.BlockHemp;
import betterwithmods.modules.core.blocks.BlockRope;
import betterwithmods.modules.utilities.client.render.RenderExtendingRope;
import betterwithmods.modules.core.entities.EntityExtendingRope;
import betterwithmods.modules.hardcore.feature.HCBouy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
    public static Block ROPE;
    public boolean dropSeeds;

    @Override
    public void setupConfig() {
        dropSeeds = loadPropBool("Drop Hemp Seeds", "Allow Hemp Seeds to drop when breaking Tall Grass", true);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        HEMP = new BlockHemp().setRegistryName("hemp_seed");
        HEMP_LEAF = new Item().setRegistryName("hemp");
        ROPE = new BlockRope().setRegistryName("rope");

        registerBlock(HEMP);
        registerItem(HEMP_LEAF);
        registerBlock(ROPE);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {

        ModelHandler.setInventoryModel(HEMP);
        ModelHandler.setInventoryModel(HEMP_LEAF);
        ModelHandler.setInventoryModel(ROPE);
        RenderingRegistry.registerEntityRenderingHandler(EntityExtendingRope.class, RenderExtendingRope::new);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if (dropSeeds) {
            MinecraftForge.addGrassSeed(new ItemStack(HEMP, 1, 0), 5);
        }
        HCBouy.registerBuoyancy(HEMP, 1.0F);
    }
}
