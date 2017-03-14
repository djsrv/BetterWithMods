package betterwithmods.integration.jei.handler;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.integration.jei.wrapper.StokedCauldronRecipeWrapper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import javax.annotation.Nonnull;
import java.util.List;

public class StokedCauldronRecipeHandler implements IRecipeHandler<StokedCauldronRecipeWrapper> {

    @Nonnull
    @Override
    public Class<StokedCauldronRecipeWrapper> getRecipeClass() {
        return StokedCauldronRecipeWrapper.class;
    }

    @Nonnull
    @Override
    public String getRecipeCategoryUid(@Nonnull StokedCauldronRecipeWrapper recipe) {
        return "bwm.cauldron.stoked";
    }

    @Nonnull
    @Override
    public IRecipeWrapper getRecipeWrapper(@Nonnull StokedCauldronRecipeWrapper recipe) {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(@Nonnull StokedCauldronRecipeWrapper wrapper) {
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
