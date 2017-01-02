package betterwithmods.integration.minetweaker;

import minetweaker.IUndoableAction;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.function.Function;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 12/31/16
 */
public abstract class BaseListRemove<T> implements IUndoableAction {
    protected List<T> removedRecipes;
    protected final ItemStack input;
    protected final List<T> recipes;
    protected final Function<ItemStack, List<T>> remove;
    protected final String name;
    public BaseListRemove(String name,ItemStack input, List<T> recipes, Function<ItemStack, List<T>> remove) {
        this.name = name;
        this.input = input;
        this.remove = remove;
        this.recipes = recipes;
    }

    @Override
    public void apply() {
        removedRecipes = remove.apply(input);
    }

    @Override
    public void undo() {
        if (removedRecipes != null)
            for (T recipe : removedRecipes)
                if (recipe != null)
                    recipes.add(recipe);
    }

    @Override
    public Object getOverrideKey() {
        return null;
    }

    @Override
    public boolean canUndo() {
        return true;
    }
}