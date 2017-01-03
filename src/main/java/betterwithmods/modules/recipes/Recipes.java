package betterwithmods.modules.recipes;

import betterwithmods.base.modules.Module;
import betterwithmods.modules.recipes.features.AnvilRecipes;
import betterwithmods.modules.recipes.features.CauldronRecipes;
import betterwithmods.modules.recipes.features.CrucibleRecipes;
import betterwithmods.modules.recipes.features.EffeciencyRecipes;
import betterwithmods.modules.recipes.features.SmeltingRecipes;
import betterwithmods.modules.recipes.features.KilnRecipes;
import betterwithmods.modules.recipes.features.MillRecipes;
import betterwithmods.modules.recipes.features.RecylingRecipes;
import betterwithmods.modules.recipes.features.SawRecipes;
import betterwithmods.modules.recipes.features.SteelRecipe;
import betterwithmods.modules.recipes.features.TurnableRecipes;
import betterwithmods.modules.recipes.features.CraftingRecipes;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class Recipes extends Module {
    @Override
    public void addFeatures() {
        registerFeature(new AnvilRecipes());
        registerFeature(new CauldronRecipes());
        registerFeature(new CrucibleRecipes());
        registerFeature(new EffeciencyRecipes());
        registerFeature(new SmeltingRecipes());
        registerFeature(new KilnRecipes());
        registerFeature(new MillRecipes());
        registerFeature(new RecylingRecipes());
        registerFeature(new SawRecipes());
        registerFeature(new SteelRecipe());
        registerFeature(new TurnableRecipes());
        registerFeature(new CraftingRecipes());
    }

    @Override
    public boolean canBeDisabled() {
        return false;
    }
}
