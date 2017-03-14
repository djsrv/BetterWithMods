package betterwithmods.common.registry.bulk;

import betterwithmods.api.craft.IBulkRecipe;
import betterwithmods.config.BWConfig;
import betterwithmods.util.InvUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReclaimRecipe implements IBulkRecipe {
    protected ItemStack inputStack;
    protected ItemStack ingotStack;
    protected ItemStack nuggetStack;
    protected int maxNuggets;
    private String type;

    public ReclaimRecipe(String type, Item inputItem, String oreSuffix, int maxNuggets) {
        this.type = type;
        this.inputStack = new ItemStack(inputItem, 1, OreDictionary.WILDCARD_VALUE);
        this.maxNuggets = maxNuggets;

        if (!OreDictionary.getOres("ingot" + oreSuffix).isEmpty())
            this.ingotStack = OreDictionary.getOres("ingot" + oreSuffix).get(0);
        if (!OreDictionary.getOres("nugget" + oreSuffix).isEmpty())
            this.nuggetStack = OreDictionary.getOres("nugget" + oreSuffix).get(0);
    }

    @Override
    public ItemStack getOutput() {
        return this.getOutputForItem(null);
    }

    @Override
    public ItemStack getSecondary() {
        return this.getSecondaryForItem(null);
    }

    @Override
    public ItemStack getActualOutput(ItemStackHandler inv) {
        int slot = InvUtils.getFirstOccupiedStackOfItem(inv, inputStack.getItem());
        if (slot > -1) {
            return this.getOutputForItem(inv.getStackInSlot(slot));
        }
        return null;
    }

    @Override
    public ItemStack getActualSecondary(ItemStackHandler inv) {
        int slot = InvUtils.getFirstOccupiedStackOfItem(inv, inputStack.getItem());
        if (slot > -1) {
            return this.getSecondaryForItem(inv.getStackInSlot(slot));
        }
        return null;
    }

    @Override
    public ArrayList<Object> getInput() {
        return new ArrayList<>(Arrays.asList(this.inputStack));
    }

    @Override
    public ArrayList<List<ItemStack>> getJEIInput() {
        List<ItemStack> inputList = Arrays.asList(this.inputStack);
        return new ArrayList<>(Arrays.asList(inputList));
    }

    @Override
    public boolean matches(ItemStackHandler inv) {
        return InvUtils.getFirstOccupiedStackOfItem(inv, inputStack.getItem()) > -1;
    }

    @Override
    public boolean matches(IBulkRecipe recipe) {
        return false;
    }

    @Override
    public boolean consumeInvIngredients(ItemStackHandler inv) {
        return InvUtils.consumeItemsInInventory(inv, inputStack, 1);
    }

    @Override
    public String getType() {
        return this.type;
    }

    private int getTotalNuggetsForItem(ItemStack stack) {
        if (BWConfig.hardcoreReclaiming && stack != null && stack.getMaxDamage() > 0) {
            return this.maxNuggets * (stack.getMaxDamage() - stack.getItemDamage()) / stack.getMaxDamage();
        }
        return this.maxNuggets;
    }

    private ItemStack getOutputForItem(ItemStack stack) {
        int totalNuggetCount = getTotalNuggetsForItem(stack);
        int ingotCount = totalNuggetCount / 9;
        if (this.ingotStack != null && ingotCount > 0) {
            return new ItemStack(this.ingotStack.getItem(), ingotCount, this.ingotStack.getMetadata());
        } else if (this.nuggetStack != null && totalNuggetCount > 0) {
            return new ItemStack(this.nuggetStack.getItem(), totalNuggetCount, this.nuggetStack.getMetadata());
        }
        return null;
    }

    private ItemStack getSecondaryForItem(ItemStack stack) {
        int totalNuggetCount = getTotalNuggetsForItem(stack);
        int ingotCount = totalNuggetCount / 9;
        if (this.ingotStack != null && ingotCount > 0) {
            int nuggetCount = totalNuggetCount % 9;
            if (this.nuggetStack != null && nuggetCount > 0) {
                return new ItemStack(this.nuggetStack.getItem(), nuggetCount, this.nuggetStack.getMetadata());
            }
        }
        return null;
    }
}
