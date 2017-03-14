package betterwithmods.integration.jei.handler;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.integration.jei.wrapper.CauldronRecipeWrapper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;
import java.util.List;

public class CauldronRecipeHandler implements IRecipeHandler<CauldronRecipeWrapper> {
    @Nonnull
    @Override
    public Class<CauldronRecipeWrapper> getRecipeClass() {
        return CauldronRecipeWrapper.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull CauldronRecipeWrapper recipe) {
        return "bwm.cauldron";
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull CauldronRecipeWrapper recipe) {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull CauldronRecipeWrapper wrapper) {
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
