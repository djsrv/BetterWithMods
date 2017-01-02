package betterwithmods.integration.minetweaker;

import betterwithmods.api.crafting.blockmeta.BlockMetaRecipe;
import betterwithmods.api.crafting.blockmeta.KilnInteraction;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IItemStack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.Pair;
import stanhebben.zenscript.annotations.NotNull;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 12/31/16
 */
@ZenClass(Kiln.clazz)
public class Kiln {

    public static final String clazz = "mods.betterwithmods.Kiln";

    @ZenMethod
    public static void addRecipe(IItemStack[] output, @NotNull IItemStack input) {
        Pair<Block, Integer> blockMeta = MineTweaker.toBlockMeta(input);
        List<ItemStack> outputs = MineTweaker.toStacks(output);
        if (output == null) {
            MineTweakerAPI.getLogger().logError("Could not add " + clazz + " recipe for " + input.getDisplayName() + ", outputs were null");
        }
        BlockMetaRecipe r = new BlockMetaRecipe(blockMeta.getLeft(), blockMeta.getRight(), null);
        MineTweakerAPI.apply(new Add(r));
    }

    private static class Add extends BaseListAdd<BlockMetaRecipe> {

        public Add(BlockMetaRecipe recipe) {
            super(clazz, recipe, KilnInteraction.INSTANCE.getRecipes());
        }

        @Override
        public String describe() {
            return String.format("Adding %s Recipe for %s", name, recipe.getInput().getDisplayName());
        }

        @Override
        public String describeUndo() {
            return String.format("Removing %s Recipe for %s", name, recipe.getInput().getDisplayName());
        }
    }

    private static class Remove extends BaseListRemove<BlockMetaRecipe> {

        public Remove(ItemStack input) {
            super(clazz, input, KilnInteraction.INSTANCE.getRecipes(), KilnInteraction.INSTANCE::removeRecipes);
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
