package betterwithmods.integration.minetweaker;

import minetweaker.IUndoableAction;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 12/31/16
 */
public abstract class BaseListAdd<T> implements IUndoableAction {
    protected final T recipe;
    protected final List<T> recipeList;
    protected final String name;
    public BaseListAdd(String name,T recipe, List<T> recipeList) {
        this.name = name;
        this.recipe = recipe;
        this.recipeList = recipeList;
    }

    @Override
    public void apply() {
        recipeList.add(recipe);
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    @Override
    public void undo() {
        recipeList.remove(recipe);
    }

    @Override
    public Object getOverrideKey() {
        return null;
    }
}