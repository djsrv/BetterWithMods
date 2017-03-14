package betterwithmods.integration.jei.wrapper;

import betterwithmods.api.craft.IBulkRecipe;
import mezz.jei.api.recipe.BlankRecipeWrapper;

import javax.annotation.Nonnull;

public abstract class BWMRecipeWrapper extends BlankRecipeWrapper {
    @Nonnull
    protected final IBulkRecipe recipe;

    public BWMRecipeWrapper(@Nonnull IBulkRecipe recipe) {
        this.recipe = recipe;
    }

    @Nonnull
    public IBulkRecipe getRecipe() {
        return recipe;
    }
}
