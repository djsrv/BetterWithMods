package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.client.ModelHandler;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.RecipeUtils;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCDiamond extends Feature {
    public static Item DIAMOND_INGOT;
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        DIAMOND_INGOT = new Item().setRegistryName("diamond_ingot");
        registerItem(DIAMOND_INGOT);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        ModelHandler.setInventoryModel(DIAMOND_INGOT);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        RecipeUtils.removeRecipes(Items.DIAMOND_AXE, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_HOE, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_PICKAXE, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_SHOVEL, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_SWORD, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_HELMET, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_CHESTPLATE, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_LEGGINGS, 0);
        RecipeUtils.removeRecipes(Items.DIAMOND_BOOTS, 0);
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_AXE, "DD", "DS", " S", 'D', DIAMOND_INGOT, 'S', "stickWood").setMirrored(true));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_HOE, "DD", " S", " S", 'D', DIAMOND_INGOT, 'S', "stickWood").setMirrored(true));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_PICKAXE, "DDD", " S ", " S ", 'D', DIAMOND_INGOT, 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_SHOVEL, "D", "S", "S", 'D', DIAMOND_INGOT, 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_SWORD, "D", "D", "S", 'D', DIAMOND_INGOT, 'S', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_HELMET, "DDD", "D D", 'D', DIAMOND_INGOT));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_CHESTPLATE, "D D", "DDD", "DDD", 'D', DIAMOND_INGOT));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_LEGGINGS, "DDD", "D D", "D D", 'D', DIAMOND_INGOT));
        GameRegistry.addRecipe(new ShapedOreRecipe(Items.DIAMOND_BOOTS, "D D", "D D", 'D', DIAMOND_INGOT));
    }
}
