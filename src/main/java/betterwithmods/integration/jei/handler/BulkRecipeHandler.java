package betterwithmods.integration.jei.handler;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.integration.jei.BWMJEIPlugin;
import betterwithmods.integration.jei.wrapper.*;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class BulkRecipeHandler implements IRecipeHandler<IBulkRecipe> {

    @Nonnull
    @Override
    public Class<IBulkRecipe> getRecipeClass() {
        return IBulkRecipe.class;
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull IBulkRecipe recipe) {
        IJeiHelpers helper = BWMJEIPlugin.helper;
        switch(recipe.getType()) {
            case "mill": return new MillRecipeWrapper(helper, recipe);
            case "cauldron": return new CauldronRecipeWrapper(helper, recipe);
            case "cauldronStoked": return new StokedCauldronRecipeWrapper(helper, recipe);
            case "crucible": return new CrucibleRecipeWrapper(helper, recipe);
            default: return new StokedCrucibleRecipeWrapper(helper, recipe);
        }
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull IBulkRecipe recipe) {
        String type = recipe.getType();
        if (type.contains("Stoked")) {
            type = type.substring(0, type.lastIndexOf("S")) + ".stoked";
        }
        return "bwm." + type;
    }

    @Override
    public boolean isRecipeValid(@Nonnull IBulkRecipe recipe) {
        if (recipe.getOutput() == null || recipe.getOutput() == ItemStack.EMPTY)
            return false;
        int inputCount = 0;
        for (Object input : recipe.getJEIInput()) {
            if (input instanceof List) {
                if (((List<?>) input).isEmpty())
                    return false;
            }
            inputCount++;
        }
        return inputCount > 0;
    }
}
