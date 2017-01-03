package betterwithmods.modules.integration.minetweaker;

import betterwithmods.api.crafting.bulk.BulkRecipe;
import betterwithmods.api.crafting.bulk.CraftingManagerMill;
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
@ZenClass(Mill.clazz)
public class Mill {

    public static final String clazz = "mods.betterwithmods.Mill";

    @ZenMethod
    public static void addRecipe(IItemStack output, @Optional IItemStack secondaryOutput,@NotNull IIngredient[] inputs) {
        BulkRecipe r = new BulkRecipe("mill", InputHelper.toStack(output),InputHelper.toStack(secondaryOutput),InputHelper.toObjects(inputs));
        MineTweakerAPI.apply(new BulkAdd("mill", CraftingManagerMill.getInstance(),r));
    }

    @ZenMethod
    public static void removeRecipe(IItemStack output) {
        MineTweakerAPI.apply(new BulkRemove("mill",CraftingManagerMill.getInstance(),InputHelper.toStack(output)));
    }


}
