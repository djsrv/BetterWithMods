package betterwithmods.integration.jei.wrapper;

import betterwithmods.api.craft.IBulkRecipe;
import mezz.jei.api.IJeiHelpers;

import javax.annotation.Nonnull;

public class StokedCauldronRecipeWrapper extends BulkRecipeWrapper {
    public StokedCauldronRecipeWrapper(IJeiHelpers helper, @Nonnull IBulkRecipe recipe) {
        super(helper, recipe);
    }
}
