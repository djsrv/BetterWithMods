package betterwithmods.integration.jei.wrapper.bm;

import betterwithmods.craft.BlockMetaRecipe;
import com.google.common.collect.Lists;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/11/16
 */
public class BlockMetaWrapper extends BlankRecipeWrapper {
    public final List<ItemStack> outputs = Lists.newArrayList();
    public final ItemStack input;

    public BlockMetaWrapper(BlockMetaRecipe recipe) {
        this.input = recipe.getInput();
        outputs.addAll(recipe.getOutputs());
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, input);
        ingredients.setOutputs(ItemStack.class, outputs);
    }
}
