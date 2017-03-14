package betterwithmods.integration.minetweaker;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.common.registry.bulk.CraftingManagerBulk;
import com.blamejared.mtlib.utils.BaseListAddition;
import com.google.common.collect.Lists;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BulkAdd extends BaseListAddition<IBulkRecipe> {

    public BulkAdd(String name, CraftingManagerBulk recipes, IBulkRecipe recipe) {
        super(name, recipes.getRecipes(), Lists.newArrayList(recipe));
    }

    @Override
    protected String getRecipeInfo(IBulkRecipe recipe) {
        return recipe.getOutput().getDisplayName();
    }
}