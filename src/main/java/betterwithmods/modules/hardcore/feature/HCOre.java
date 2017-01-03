package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.InvUtils;
import betterwithmods.base.util.RecipeUtils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.List;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCOre extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        RecipeUtils.removeRecipes(Items.COMPASS, 0);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.COMPASS), " N ", "NRN", " N ", 'N', "nuggetIron", 'R', "dustRedstone"));
        RecipeUtils.removeRecipes(Items.CLOCK, 0);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.CLOCK), " N ", "NQN", " N ", 'N', "nuggetGold", 'Q', "gemQuartz"));
        RecipeUtils.removeRecipes(Items.BUCKET, 0);
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BUCKET), "N N", " N ", 'N', "nuggetIron"));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        for (ItemStack ore : InvUtils.oreNames) {
            ItemStack nugget = InvUtils.getMatchingSuffixStack(ore, "ore", "nugget");
            if (nugget != null) {
                RecipeUtils.removeFurnaceRecipe(ore);
                FurnaceRecipes.instance().getSmeltingList().put(ore, nugget);
                List<ItemStack> dusts = InvUtils.getMatchingSuffix(ore, "ore", "dust");
                if (dusts.size() > 0) {
                    dusts.forEach(RecipeUtils::removeFurnaceRecipe);
                    dusts.forEach(dust -> FurnaceRecipes.instance().getSmeltingList().put(dust, nugget));
                }
            }
        }
    }
}
