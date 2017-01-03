package betterwithmods.modules.integration.minetweaker;

import betterwithmods.api.crafting.bulk.BulkRecipe;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucibleStoked;
import com.blamejared.mtlib.helpers.InputHelper;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
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
@ZenClass(StokedCrucible.clazz)
public class StokedCrucible {

    public static final String clazz = "mods.betterwithmods.StokedCrucible";

    @ZenMethod
    public static void addRecipe(IItemStack output, @Optional IItemStack secondaryOutput, @NotNull IIngredient[] inputs) {
        BulkRecipe r = new BulkRecipe("crucibleStoked", InputHelper.toStack(output), InputHelper.toStack(secondaryOutput), InputHelper.toObjects(inputs));
        MineTweakerAPI.apply(new BulkAdd("crucibleStoked", CraftingManagerCrucibleStoked.getInstance(), r));
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        MineTweakerAPI.apply(new BulkRemove("crucibleStoked", CraftingManagerCrucibleStoked.getInstance(), InputHelper.toStack(output)));
    }


}
