package betterwithmods.integration.jei.wrapper;

import betterwithmods.api.crafting.bulk.BulkRecipe;
import mezz.jei.api.IJeiHelpers;

import javax.annotation.Nonnull;

public class CrucibleRecipeWrapper extends BulkRecipeWrapper {
    public CrucibleRecipeWrapper(IJeiHelpers helper, @Nonnull BulkRecipe recipe) {
        super(helper, recipe);
    }
}
