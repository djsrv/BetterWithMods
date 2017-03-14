package betterwithmods.integration.jei.handler;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.integration.jei.wrapper.MillRecipeWrapper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;
import java.util.List;

public class MillRecipeHandler implements IRecipeHandler<MillRecipeWrapper> {
     @Nonnull
    @Override
    public Class<MillRecipeWrapper> getRecipeClass() {
        return MillRecipeWrapper.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull MillRecipeWrapper recipe) {
        return "bwm.mill";
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull MillRecipeWrapper recipe) {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull MillRecipeWrapper wrapper) {
        IBulkRecipe recipe = wrapper.getRecipe();
        if (recipe.getOutput() == null)
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
