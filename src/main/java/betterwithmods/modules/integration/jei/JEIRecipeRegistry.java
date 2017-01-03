package betterwithmods.modules.integration.jei;

import betterwithmods.api.crafting.HopperInteractions;
import betterwithmods.api.crafting.blockmeta.KilnInteraction;
import betterwithmods.api.crafting.blockmeta.SawInteraction;
import betterwithmods.api.crafting.blockmeta.TurntableInteraction;
import betterwithmods.api.crafting.bulk.BulkRecipe;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldron;
import betterwithmods.api.crafting.bulk.CraftingManagerCauldronStoked;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucible;
import betterwithmods.api.crafting.bulk.CraftingManagerCrucibleStoked;
import betterwithmods.api.crafting.bulk.CraftingManagerMill;
import betterwithmods.api.crafting.steelanvil.CraftingManagerSteelAnvil;
import betterwithmods.api.crafting.steelanvil.ShapedSteelAnvilRecipe;
import betterwithmods.modules.integration.jei.wrapper.CauldronRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.CrucibleRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.HopperRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.KilnWrapper;
import betterwithmods.modules.integration.jei.wrapper.MillRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.SawWrapper;
import betterwithmods.modules.integration.jei.wrapper.SoulUrnWrapper;
import betterwithmods.modules.integration.jei.wrapper.SteelAnvilShapedRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.SteelAnvilShapelessRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.StokedCauldronRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.StokedCrucibleRecipeWrapper;
import betterwithmods.modules.integration.jei.wrapper.TurntableRecipeWrapper;
import mezz.jei.api.IJeiHelpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JEIRecipeRegistry {
    public static List<HopperRecipeWrapper> getHopperRecipes() {
        return HopperInteractions.recipes.stream().map(recipe -> recipe instanceof HopperInteractions.SoulUrn ? new SoulUrnWrapper((HopperInteractions.SoulUrn) recipe) : new HopperRecipeWrapper(recipe)).collect(Collectors.toList());
    }

    public static List<TurntableRecipeWrapper> getTurntableRecipes() {
        return TurntableInteraction.INSTANCE.getRecipes().stream().map(recipe -> new TurntableRecipeWrapper((TurntableInteraction.TurntableRecipe) recipe)).collect(Collectors.toList());
    }

    public static List<KilnWrapper> getKilnRecipes() {
        return KilnInteraction.INSTANCE.getRecipes().stream().map(KilnWrapper::new).collect(Collectors.toList());
    }

    public static List<SawWrapper> getSawRecipes() {
        return SawInteraction.INSTANCE.getRecipes().stream().map(SawWrapper::new).collect(Collectors.toList());
    }

    public static List<CauldronRecipeWrapper> getCauldronRecipes(IJeiHelpers helper) {
        return getCauldronRecipes(CraftingManagerCauldron.getInstance(), helper);
    }

    public static List<StokedCauldronRecipeWrapper> getStokedCauldronRecipes(IJeiHelpers helper) {
        return getStokedCauldronRecipes(CraftingManagerCauldronStoked.getInstance(), helper);
    }

    public static List<CrucibleRecipeWrapper> getCrucibleRecipes(IJeiHelpers helper) {
        return getCrucibleRecipes(CraftingManagerCrucible.getInstance(), helper);
    }

    public static List<StokedCrucibleRecipeWrapper> getStokedCrucibleRecipes(IJeiHelpers helper) {
        return getStokedCrucibleRecipes(CraftingManagerCrucibleStoked.getInstance(), helper);
    }

    public static List<MillRecipeWrapper> getMillRecipes(IJeiHelpers helper) {
        return getMillRecipes(CraftingManagerMill.getInstance(), helper);
    }

    public static List<SteelAnvilShapelessRecipeWrapper> getSteelAnvilShapelessRecipes(IJeiHelpers helper) {
        return getSteelAnvilShapelessRecipes(CraftingManagerSteelAnvil.INSTANCE, helper);
    }

    public static List<SteelAnvilShapedRecipeWrapper> getSteelAnvilShapedRecipes(IJeiHelpers helper) {
        return getSteelAnvilShapedRecipes(CraftingManagerSteelAnvil.INSTANCE, helper);
    }

    private static List<CrucibleRecipeWrapper> getCrucibleRecipes(CraftingManagerCrucible bulk, IJeiHelpers helper) {
        List<CrucibleRecipeWrapper> recipes = new ArrayList<>();
        for (BulkRecipe recipe : bulk.getRecipes())
            recipes.add(new CrucibleRecipeWrapper(helper, recipe));
        return recipes;
    }

    private static List<StokedCrucibleRecipeWrapper> getStokedCrucibleRecipes(CraftingManagerCrucibleStoked bulk, IJeiHelpers helper) {
        List<StokedCrucibleRecipeWrapper> recipes = new ArrayList<>();
        for (BulkRecipe recipe : bulk.getRecipes())
            recipes.add(new StokedCrucibleRecipeWrapper(helper, recipe));
        return recipes;
    }

    private static List<CauldronRecipeWrapper> getCauldronRecipes(CraftingManagerCauldron bulk, IJeiHelpers helper) {
        List<CauldronRecipeWrapper> recipes = new ArrayList<>();
        for (BulkRecipe recipe : bulk.getRecipes())
            recipes.add(new CauldronRecipeWrapper(helper, recipe));
        return recipes;
    }

    private static List<StokedCauldronRecipeWrapper> getStokedCauldronRecipes(CraftingManagerCauldronStoked bulk, IJeiHelpers helper) {
        List<StokedCauldronRecipeWrapper> recipes = new ArrayList<>();
        for (BulkRecipe recipe : bulk.getRecipes())
            recipes.add(new StokedCauldronRecipeWrapper(helper, recipe));
        return recipes;
    }

    private static List<MillRecipeWrapper> getMillRecipes(CraftingManagerMill bulk, IJeiHelpers helper) {
        List<MillRecipeWrapper> recipes = new ArrayList<>();
        for (BulkRecipe recipe : bulk.getRecipes())
            recipes.add(new MillRecipeWrapper(helper, recipe));
        return recipes;
    }

    private static List<SteelAnvilShapelessRecipeWrapper> getSteelAnvilShapelessRecipes(CraftingManagerSteelAnvil manager, IJeiHelpers helper) {
        List<SteelAnvilShapelessRecipeWrapper> recipes = new ArrayList<>();
        for (IRecipe recipe : manager.getRecipes()) {
            if (recipe instanceof ShapelessOreRecipe)
                recipes.add(new SteelAnvilShapelessRecipeWrapper(helper, (ShapelessOreRecipe) recipe));
        }
        return recipes;
    }

    private static List<SteelAnvilShapedRecipeWrapper> getSteelAnvilShapedRecipes(CraftingManagerSteelAnvil manager, IJeiHelpers helper) {
        List<SteelAnvilShapedRecipeWrapper> recipes = new ArrayList<>();
        for (IRecipe recipe : manager.getRecipes()) {
            if (recipe instanceof ShapedSteelAnvilRecipe)
                recipes.add(new SteelAnvilShapedRecipeWrapper(helper, (ShapedSteelAnvilRecipe) recipe));
        }
        return recipes;
    }
}
