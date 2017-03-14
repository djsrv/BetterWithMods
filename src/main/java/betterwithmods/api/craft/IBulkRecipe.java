package betterwithmods.api.craft;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;

public interface IBulkRecipe {
    ItemStack getOutput();

    ItemStack getSecondary();

    ItemStack getActualOutput(ItemStackHandler inv);

    ItemStack getActualSecondary(ItemStackHandler inv);

    ArrayList<Object> getInput();

    ArrayList<List<ItemStack>> getJEIInput();

    boolean matches(ItemStackHandler inv);

    boolean matches(IBulkRecipe recipe);

    boolean consumeInvIngredients(ItemStackHandler inv);

    String getType();
}
