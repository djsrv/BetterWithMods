package betterwithmods.modules.integration.jei.wrapper;

import betterwithmods.api.crafting.bulk.BulkRecipe;
import mezz.jei.api.recipe.BlankRecipeWrapper;

import javax.annotation.Nonnull;

public abstract class BWMRecipeWrapper extends BlankRecipeWrapper {
    @Nonnull
    protected final BulkRecipe recipe;

    public BWMRecipeWrapper(@Nonnull BulkRecipe recipe) {
        this.recipe = recipe;
    }

    @Nonnull
    public BulkRecipe getRecipe() {
        return recipe;
    }
}
