package betterwithmods.integration.minetweaker;

import betterwithmods.api.crafting.bulk.BulkRecipe;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldron;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.NotNull;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 12/31/16
 */
@ZenClass(StokedCauldron.clazz)
public class StokedCauldron {

    public static final String clazz = "mods.betterwithmods.StokedCauldron";

    @ZenMethod
    public static void addRecipe(IItemStack output, @Optional IItemStack secondaryOutput,@NotNull IIngredient[] inputs) {
        BulkRecipe r = new BulkRecipe("cauldronStoked",MineTweaker.toStack(output),MineTweaker.toStack(secondaryOutput),MineTweaker.toObjects(inputs));
        MineTweakerAPI.apply(new Add(r));
    }

    private static class Add extends BaseListAdd<BulkRecipe> {

        public Add(BulkRecipe recipe) {
            super(clazz, recipe, CraftingManagerCauldron.getInstance().getRecipes());
        }

        @Override
        public String describe() {
            return String.format("Adding %s Recipe for %s", name, recipe.getOutput().getDisplayName());
        }

        @Override
        public String describeUndo() {
            return String.format("Removing %s Recipe for %s", name, recipe.getOutput().getDisplayName());
        }
    }

    private static class Remove extends BaseListRemove<BulkRecipe> {

        public Remove(ItemStack input) {
            super(clazz, input, CraftingManagerCauldron.getInstance().getRecipes(), CraftingManagerCauldron.getInstance()::removeRecipes);
        }

        @Override
        public String describe() {
            return String.format("Removing %s Recipe for %s", name, input.getDisplayName());
        }

        @Override
        public String describeUndo() {
            return String.format("Adding %s Recipe for %s", name, input.getDisplayName());
        }
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        MineTweakerAPI.apply(new Remove(MineTweaker.toStack(output)));
    }


}
