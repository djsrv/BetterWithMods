package betterwithmods.common.registry.bulk;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.common.registry.OreStack;
import betterwithmods.util.InvUtils;
import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class CraftingManagerBulk {
    private final String craftType;
    private List<IBulkRecipe> recipes;

    public CraftingManagerBulk(String craftType) {
        this.craftType = craftType;
        this.recipes = new ArrayList<>();
    }

    public void addOreRecipe(ItemStack output, Object[] inputs) {
        addOreRecipe(output, null, inputs);
    }

    public void addOreRecipe(ItemStack output, ItemStack secondary, Object input) {
        Object[] inputs = new Object[1];
        inputs[0] = input;
        addOreRecipe(output, secondary, inputs);
    }

    public void addOreRecipe(ItemStack output, Object input) {
        addOreRecipe(output, null, input);
    }

    public void addOreRecipe(ItemStack output, ItemStack secondary, Object[] inputs) {
        BulkRecipe recipe = createRecipe(output, secondary, inputs);
        this.recipes.add(recipe);
    }

    public void addRecipe(ItemStack output, ItemStack[] inputs) {
        addRecipe(output, null, inputs);
    }

    public void addRecipe(ItemStack output, ItemStack secondary, ItemStack input) {
        ItemStack[] inputs = new ItemStack[1];
        inputs[0] = input.copy();
        addRecipe(output, secondary, inputs);
    }

    public void addRecipe(ItemStack output, ItemStack input) {
        addRecipe(output, null, input);
    }

    public void addRecipe(ItemStack output, ItemStack secondary, ItemStack[] inputs) {
        BulkRecipe recipe = createRecipe(output, secondary, inputs);
        this.recipes.add(recipe);
    }

    public List<IBulkRecipe> removeRecipes(ItemStack output) {
        List<IBulkRecipe> removed = Lists.newArrayList();
        Iterator<IBulkRecipe> it = recipes.iterator();
        while(it.hasNext())
        {
            IBulkRecipe ir = it.next();
            if(ir.getOutput().isItemEqual(output))
            {
                removed.add(ir);
            }
        }
        return removed;
    }

    public boolean removeRecipe(ItemStack output, Object[] inputs) {
        return removeRecipe(output, null, inputs);
    }

    public boolean removeRecipe(ItemStack output, ItemStack secondary, Object input) {
        Object[] inputs = new Object[1];
        inputs[0] = input;
        return removeRecipe(output, secondary, inputs);
    }

    public boolean removeRecipe(ItemStack output, Object input) {
        return removeRecipe(output, null, input);
    }

    public boolean removeRecipe(ItemStack output, ItemStack secondary, Object[] inputs) {
        BulkRecipe recipe = createRecipe(output, secondary, inputs);
        int matchingIndex = getMatchingRecipeIndex(recipe);

        if (matchingIndex >= 0) {
            this.recipes.remove(matchingIndex);
            return true;
        }
        return false;
    }

    public ItemStack[] getCraftingResult(ItemStackHandler inv) {
        IBulkRecipe recipe = getMostValidRecipe(inv);
        if (recipe != null) {
            if (recipe.matches(inv)) {
                ItemStack[] ret = new ItemStack[1];
                if (recipe.getActualSecondary(inv) != null) {
                    ret = new ItemStack[2];
                    ret[1] = recipe.getActualSecondary(inv);
                }
                ret[0] = recipe.getActualOutput(inv);
                return ret;
            }
        }
        return null;
    }

    private IBulkRecipe getMostValidRecipe(ItemStackHandler inv) {
        HashMap<Integer, IBulkRecipe> recipes = getValidRecipes(inv);
        if (!recipes.isEmpty()) {
            for (int i = 0; i < recipes.size(); i++) {
                IBulkRecipe recipe = recipes.get(i);
                if (recipe.matches(inv))
                    return recipe;
            }
        }
        return null;
    }

    private HashMap<Integer, IBulkRecipe> getValidRecipes(ItemStackHandler inv) {
        HashMap<Integer, IBulkRecipe> recipe = new HashMap<>();
        int order = 0;
        for (int i = 0; i < inv.getSlots(); i++) {
            IBulkRecipe single = null;
            if (inv.getStackInSlot(i) != ItemStack.EMPTY) {
                ItemStack stack = inv.getStackInSlot(i).copy();
                for (IBulkRecipe r : this.recipes) {
                    if (containsIngredient(r.getInput(), stack)) {
                        if (r.getInput().size() > 1) {
                            recipe.put(order, r);
                            order++;
                        } else
                            single = r;
                    }
                }
            }
            //We're throwing this in the back of the possible valid recipes just in case there's another recipe with the same item alongside another.
            if (single != null) {
                recipe.put(order, single);
                order++;
            }
        }
        return recipe;
    }

    private boolean containsIngredient(List<Object> list, ItemStack stack) {
        for (Object obj : list) {
            if (obj instanceof ItemStack) {
                if (ItemStack.areItemsEqual((ItemStack) obj, stack) || (((ItemStack) obj).getItemDamage() == OreDictionary.WILDCARD_VALUE && stack.getItem() == ((ItemStack) obj).getItem())) {
                    return !((ItemStack) obj).hasTagCompound() || ItemStack.areItemStackTagsEqual(stack, (ItemStack) obj);
                }
            } else if (obj instanceof OreStack) {
                if (InvUtils.listContains(stack, ((OreStack) obj).getOres()))
                    return true;
            }
        }
        return false;
    }

    public List<Object> getValidCraftingIngredients(ItemStackHandler inv) {
        IBulkRecipe recipe = getMostValidRecipe(inv);
        if (recipe != null)
            return recipe.getInput();
        return null;
    }

    public ItemStack[] craftItem(ItemStackHandler inv) {
        IBulkRecipe recipe = getMostValidRecipe(inv);
        if (recipe != null) {
            ItemStack[] ret = new ItemStack[1];
            if (recipe.getSecondary() != null) {
                ret = new ItemStack[2];
                ret[1] = recipe.getSecondary();
            }
            if (recipe.getOutput() == null) {
                return null;
            }
            ret[0] = recipe.getOutput();
            recipe.consumeInvIngredients(inv);
            return ret;
        }
        return null;
    }

    private BulkRecipe createRecipe(ItemStack output, ItemStack secondary, Object[] inputs) {
        return new BulkRecipe(craftType, output, secondary, inputs);
    }

    private int getMatchingRecipeIndex(BulkRecipe recipe) {
        for (int i = 0; i < this.recipes.size(); i++) {
            IBulkRecipe tempRecipe = this.recipes.get(i);
            if (tempRecipe.matches(recipe))
                return i;
        }
        return -1;
    }

    public List<IBulkRecipe> getRecipes() {
        return this.recipes;
    }

    //Lazy way of ensuring the ore dictionary entries were properly implemented.
    public void refreshRecipes() {
        List<IBulkRecipe> recipes = getRecipes();
        if (!recipes.isEmpty()) {
            this.recipes = new ArrayList<>();
            for (IBulkRecipe r : recipes) {
                this.recipes.add(createRecipe(r.getOutput(), r.getSecondary(), r.getInput().toArray()));
            }
        }
    }
}
