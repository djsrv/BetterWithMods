package betterwithmods.integration.minetweaker;


import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.common.registry.bulk.CraftingManagerBulk;
import com.blamejared.mtlib.utils.BaseListRemoval;
import net.minecraft.item.ItemStack;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BulkRemove extends BaseListRemoval<IBulkRecipe> {
    protected BulkRemove(String name, CraftingManagerBulk recipes, ItemStack output) {
        super(name, recipes.getRecipes(), recipes.removeRecipes(output));
    }
    @Override
    protected String getRecipeInfo(IBulkRecipe recipe) {
        return recipe.getOutput().getDisplayName();
    }
}