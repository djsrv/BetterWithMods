package betterwithmods.modules.integration.jei;

import betterwithmods.modules.core.features.CookingPots;
import betterwithmods.modules.core.features.Machines;
import betterwithmods.modules.integration.jei.category.CauldronRecipeCategory;
import betterwithmods.modules.integration.jei.category.CrucibleRecipeCategory;
import betterwithmods.modules.integration.jei.category.HopperRecipeCategory;
import betterwithmods.modules.integration.jei.category.KilnRecipeCategory;
import betterwithmods.modules.integration.jei.category.MillRecipeCategory;
import betterwithmods.modules.integration.jei.category.SawRecipeCategory;
import betterwithmods.modules.integration.jei.category.SoulUrnCategory;
import betterwithmods.modules.integration.jei.category.SteelAnvilRecipeCategory;
import betterwithmods.modules.integration.jei.category.StokedCauldronRecipeCategory;
import betterwithmods.modules.integration.jei.category.StokedCrucibleRecipeCategory;
import betterwithmods.modules.integration.jei.category.TurntableRecipeCategory;
import betterwithmods.modules.integration.jei.handler.CauldronRecipeHandler;
import betterwithmods.modules.integration.jei.handler.CrucibleRecipeHandler;
import betterwithmods.modules.integration.jei.handler.HopperRecipeHandler;
import betterwithmods.modules.integration.jei.handler.KilnRecipeHandler;
import betterwithmods.modules.integration.jei.handler.MillRecipeHandler;
import betterwithmods.modules.integration.jei.handler.SawRecipeHandler;
import betterwithmods.modules.integration.jei.handler.SteelAnvilShapedRecipeHandler;
import betterwithmods.modules.integration.jei.handler.SteelAnvilShapelessRecipeHandler;
import betterwithmods.modules.integration.jei.handler.StokedCauldronRecipeHandler;
import betterwithmods.modules.integration.jei.handler.StokedCrucibleRecipeHandler;
import betterwithmods.modules.integration.jei.handler.TurntableHandler;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

@mezz.jei.api.JEIPlugin
public class BWMJEIPlugin extends BlankModPlugin {
    @Override
    public void register(@Nonnull IModRegistry reg) {
        IJeiHelpers helper = reg.getJeiHelpers();
        IGuiHelper guiHelper = helper.getGuiHelper();

        reg.addRecipeCategories(new CauldronRecipeCategory(guiHelper), new StokedCauldronRecipeCategory(guiHelper), new CrucibleRecipeCategory(guiHelper),
                new StokedCrucibleRecipeCategory(guiHelper), new MillRecipeCategory(guiHelper), new SawRecipeCategory(guiHelper), new KilnRecipeCategory(guiHelper),
                new TurntableRecipeCategory(guiHelper), new HopperRecipeCategory(guiHelper), new SoulUrnCategory(guiHelper), new SteelAnvilRecipeCategory(guiHelper));

        reg.addRecipeHandlers(new CauldronRecipeHandler(), new StokedCauldronRecipeHandler(), new CrucibleRecipeHandler(),
                new StokedCrucibleRecipeHandler(), new MillRecipeHandler(), new SawRecipeHandler(), new KilnRecipeHandler(),
                new TurntableHandler(), new HopperRecipeHandler(), new SteelAnvilShapelessRecipeHandler(), new SteelAnvilShapedRecipeHandler());

        reg.addRecipes(JEIRecipeRegistry.getCauldronRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getStokedCauldronRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getCrucibleRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getStokedCrucibleRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getMillRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getSawRecipes());
        reg.addRecipes(JEIRecipeRegistry.getKilnRecipes());
        reg.addRecipes(JEIRecipeRegistry.getTurntableRecipes());
        reg.addRecipes(JEIRecipeRegistry.getHopperRecipes());
        reg.addRecipes(JEIRecipeRegistry.getSteelAnvilShapelessRecipes(helper));
        reg.addRecipes(JEIRecipeRegistry.getSteelAnvilShapedRecipes(helper));

        reg.addRecipeCategoryCraftingItem(new ItemStack(Machines.MILL), "bwm.mill");
        reg.addRecipeCategoryCraftingItem(new ItemStack(CookingPots.COOKING_POTS,1, 1), "bwm.crucible", "bwm.crucible.stoked");
        reg.addRecipeCategoryCraftingItem(new ItemStack(CookingPots.COOKING_POTS), "bwm.cauldron", "bwm.cauldron.stoked");
        reg.addRecipeCategoryCraftingItem(new ItemStack(Machines.FILTERED_HOPPER), "bwm.hopper", "bwm.hopper.soul_urn");
        reg.addRecipeCategoryCraftingItem(new ItemStack(Machines.TURNTABLE), "bwm.turntable");
        //TODO
//        reg.addRecipeCategoryCraftingItem(new ItemStack(BWMBlocks.SAW), "bwm.saw");
        reg.addRecipeCategoryCraftingItem(new ItemStack(Blocks.BRICK_BLOCK), "bwm.kiln");
//        reg.addRecipeCategoryCraftingItem(new ItemStack(BWMBlocks.STEEL_ANVIL), "bwm.steel_anvil");
        //TODO
//        reg.addRecipeClickArea(GuiCauldron.class, 81, 19, 14, 14, "bwm.cauldron", "bwm.cauldron.stoked");
//        reg.addRecipeClickArea(GuiCrucible.class, 81, 19, 14, 14, "bwm.crucible", "bwm.crucible.stoked");
//        reg.addRecipeClickArea(GuiMill.class, 81, 19, 14, 14, "bwm.mill");
//        reg.addRecipeClickArea(GuiSteelAnvil.class, 88, 41, 28, 23, "bwm.steel_anvil");
    }
}
