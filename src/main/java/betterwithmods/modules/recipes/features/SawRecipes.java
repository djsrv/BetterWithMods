package betterwithmods.modules.recipes.features;

import betterwithmods.api.crafting.blockmeta.SawInteraction;
import betterwithmods.base.modules.Feature;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class SawRecipes extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        //TODO
//        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
//            addSawRecipe(BWMBlocks.WOOD_CORNER, type.getMetadata(), ItemMaterial.getMaterial("gear", 2));
//            addSawRecipe(BWMBlocks.WOOD_MOULDING, type.getMetadata(), new ItemStack(BWMBlocks.WOOD_CORNER, 2, type.getMetadata()));
//            addSawRecipe(BWMBlocks.WOOD_SIDING, type.getMetadata(), new ItemStack(BWMBlocks.WOOD_MOULDING, 2, type.getMetadata()));
//        }
//        addSawRecipe(Blocks.VINE, 0, new ItemStack(Blocks.VINE));
//        addSawRecipe(Blocks.PUMPKIN, 0, new ItemStack(Blocks.PUMPKIN));
//        SawInteraction.INSTANCE.addRecipe(new BlockMetaRecipe(Blocks.MELON_BLOCK, 0, null) {
//            @Override
//            public List<ItemStack> getOutputs() {
//                Random random = new Random();
//                return Lists.newArrayList(new ItemStack(Items.MELON, 3 + random.nextInt(5)));
//            }
//        });
    }

    public static void addSawRecipe(Block block, int meta, ItemStack output) {
        addSawRecipe(block, meta, new ItemStack[]{output});
    }

    public static void addSawRecipe(Block block, int meta, ItemStack... outputs) {
        SawInteraction.INSTANCE.addRecipe(block, meta, outputs);
    }


}
