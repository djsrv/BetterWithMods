package betterwithmods.base.client;

import betterwithmods.api.IMultiLocations;
import betterwithmods.api.block.IMultiVariants;
import betterwithmods.base.BWMod;
import betterwithmods.base.blocks.mini.BlockMini;
import betterwithmods.base.blocks.mini.ItemBlockMini;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Objects;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class ModelHandler {

    @SideOnly(Side.CLIENT)
    private static void setModelLocation(Item item, int meta, String variantSettings) {
        setModelLocation(item, meta, item.getRegistryName().toString(), variantSettings);
    }

    @SideOnly(Side.CLIENT)
    private static void setModelLocation(Item item, int meta, String location, String variantSettings) {
        if (meta == OreDictionary.WILDCARD_VALUE) {
            ModelLoader.setCustomMeshDefinition(item,
                    stack -> new ModelResourceLocation(location, variantSettings));
        } else {
            ModelLoader.setCustomModelResourceLocation(item, meta,
                    new ModelResourceLocation(location, variantSettings));
        }
    }


    @SideOnly(Side.CLIENT)
    public static void setInventoryModel(Block block) {
        setInventoryModel(Item.getItemFromBlock(block));
    }

    @SideOnly(Side.CLIENT)
    public static void setInventoryModel(ItemBlock item) {
        Block block = item.getBlock();
        if (item instanceof ItemBlockMini) {
            registerMiniBlockNBT((ItemBlockMini) item);
            ModelLoader.setCustomStateMapper(block, new BWStateMapper(block.getRegistryName().toString()));
        } else if (block instanceof IMultiVariants) {
            ModelLoader.setCustomStateMapper(block, new BWStateMapper(block.getRegistryName().toString()));
            String[] variants = ((IMultiVariants) block).getVariants();
            for (int meta = 0; meta < variants.length; meta++) {
                if (!Objects.equals(variants[meta], "")) setModelLocation(item, meta, variants[meta]);
            }
        } else if (block instanceof IMultiLocations) {
            String[] locations = ((IMultiLocations) block).getLocations();
            for (int meta = 0; meta < locations.length; meta++) {
                String location = locations[meta];
                setModelLocation(item, meta, BWMod.MODID + ":" + location, "inventory");
            }
        } else {
            setModelLocation(item, OreDictionary.WILDCARD_VALUE, "inventory");
        }
    }

    @SideOnly(Side.CLIENT)
    public static void setInventoryModel(Item item) {
        if (item.isDamageable()) {
            setModelLocation(item, OreDictionary.WILDCARD_VALUE, "inventory");
        } else if (item instanceof IMultiLocations) {
            IMultiLocations bwmItem = (IMultiLocations) item;
            String[] locations = bwmItem.getLocations();
            for (int meta = 0; meta < locations.length; meta++) {
                String location = locations[meta];
                setModelLocation(item, meta, BWMod.MODID + ":" + location, "inventory");
            }
        } else if (item instanceof ItemBlock) {
            ItemBlock itemBlock = (ItemBlock) item;
            setInventoryModel(itemBlock);
        } else {
            setModelLocation(item, OreDictionary.WILDCARD_VALUE, "inventory");
        }
    }

    @SideOnly(Side.CLIENT)
    private static void registerMiniBlockNBT(ItemBlockMini item) {
        if (Block.getBlockFromItem(item).getRegistryName().getResourcePath().startsWith("wood")) {
            //TODO use more of the BlockPlanks.EnumType instead of metadata
            ModelLoader.setCustomMeshDefinition(item,
                    stack -> (stack.hasTagCompound() && stack.getTagCompound().hasKey("type")) ? new ModelResourceLocation(
                            item.getRegistryName() + "_"
                                    + BlockPlanks.EnumType.byMetadata(stack.getTagCompound().getInteger("type")).getName(),
                            "inventory")
                            : stack.getItemDamage() < 6
                            ? new ModelResourceLocation(
                            item.getRegistryName() + "_"
                                    + BlockPlanks.EnumType.byMetadata(stack.getItemDamage()).getName(),
                            "inventory")
                            : new ModelResourceLocation(item.getRegistryName() + "_oak", "inventory"));
            ModelResourceLocation[] resourceLocations = new ModelResourceLocation[6];
            for (int i = 0; i < 6; i++)
                resourceLocations[i] = new ModelResourceLocation(item.getRegistryName() + "_" + BlockPlanks.EnumType.byMetadata(i),
                        "inventory");
            ModelBakery.registerItemVariants(item, (ResourceLocation[]) resourceLocations);
        } else {
            ModelLoader.setCustomMeshDefinition(item,
                    stack -> (stack.hasTagCompound() && stack.getTagCompound().hasKey("type")) ? new ModelResourceLocation(
                            item.getRegistryName() + "_"
                                    + BlockMini.EnumType.byMetadata(stack.getTagCompound().getInteger("type")).getName(),
                            "inventory")
                            : stack.getItemDamage() < 6
                            ? new ModelResourceLocation(
                            item.getRegistryName() + "_"
                                    + BlockMini.EnumType.byMetadata(stack.getItemDamage()).getName(),
                            "inventory")
                            : new ModelResourceLocation(item.getRegistryName() + "_stone", "inventory"));
            ModelResourceLocation[] resourceLocations = new ModelResourceLocation[6];
            for (int i = 0; i < 6; i++)
                resourceLocations[i] = new ModelResourceLocation(item.getRegistryName() + "_" + BlockMini.EnumType.byMetadata(i).getName(),
                        "inventory");
            ModelBakery.registerItemVariants(item, (ResourceLocation[]) resourceLocations);
        }
    }
    ///CLIENT END
}
