package betterwithmods.base.util;

import betterwithmods.base.BWMod;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldron;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldronStoked;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucible;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucibleStoked;
import betterwithmods.api.crafting.bulk.CraftingManagerMill;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class RecipeUtils {
    private RecipeUtils() {
    }

    public static void removeFurnaceRecipe(ItemStack input) {
        Iterator<Map.Entry<ItemStack, ItemStack>> iter = FurnaceRecipes.instance().getSmeltingList().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<ItemStack, ItemStack> next = iter.next();
            //for some reason mojang put fucking wildcard for their ore meta
            if (next.getKey().isItemEqual(input) || (next.getKey().getItem() == input.getItem() && next.getKey().getMetadata() == OreDictionary.WILDCARD_VALUE)) {
                iter.remove();
            }
        }
    }

    public static IBlockState getStateFromStack(ItemStack stack) {
        if (stack != null && stack.getItem() instanceof ItemBlock) {
            return ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
        }
        return Blocks.AIR.getDefaultState();
    }

    /**
     * Remove all recipes.
     *
     * @param item Item to remove recipes of.
     * @param meta Metavalue.
     *             If {@link OreDictionary#WILDCARD_VALUE} all recipes of the item will be removed.
     */
    public static void removeRecipes(Item item, int meta) {
        removeRecipes(new ItemStack(item, 1, meta));
    }

    /**
     * Remove all recipes.
     *
     * @param block Block to remove recipes of.
     */
    public static void removeRecipes(Block block) {
        removeRecipes(new ItemStack(block));
    }

    /**
     * Remove all recipes.
     *
     * @param stack ItemStack to remove recipes of.
     */
    public static void removeRecipes(ItemStack stack) {
        List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
        final ListIterator<IRecipe> li = recipeList.listIterator();
        boolean found = false;
        while (li.hasNext()) {
            ItemStack output = li.next().getRecipeOutput();
            if (OreDictionary.itemMatches(stack, output, false)) {
                li.remove();
                found = true;
            }
        }
        if (!found)
            BWMod.logger.error("No matching recipe found.");

    }



    public static void refreshRecipes() {
        CraftingManagerCauldron.getInstance().refreshRecipes();
        CraftingManagerCauldronStoked.getInstance().refreshRecipes();
        CraftingManagerCrucible.getInstance().refreshRecipes();
        CraftingManagerCrucibleStoked.getInstance().refreshRecipes();
        CraftingManagerMill.getInstance().refreshRecipes();
    }
}
