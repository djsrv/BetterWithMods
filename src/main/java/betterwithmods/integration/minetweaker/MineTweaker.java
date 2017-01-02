package betterwithmods.integration.minetweaker;

import betterwithmods.integration.ICompatModule;
import minetweaker.MineTweakerAPI;
import minetweaker.api.item.IIngredient;
import minetweaker.api.item.IItemStack;
import minetweaker.api.item.IngredientStack;
import minetweaker.api.liquid.ILiquidStack;
import minetweaker.api.oredict.IOreDictEntry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tyler on 9/4/16.
 */
@SuppressWarnings("unused")
public class MineTweaker implements ICompatModule {
    public static final String MODID = "MineTweaker3";

    @Override
    public void preInit() {

    }

    @Override
    public void init() {
        MineTweakerAPI.registerClass(Saw.class);
        MineTweakerAPI.registerClass(Kiln.class);
        MineTweakerAPI.registerClass(Cauldron.class);
        MineTweakerAPI.registerClass(Crucible.class);
        MineTweakerAPI.registerClass(StokedCauldron.class);
        MineTweakerAPI.registerClass(StokedCrucible.class);
        MineTweakerAPI.registerClass(Mill.class);

//        MineTweakerAPI.registerClass(Buoyancy.class);
//        MineTweakerAPI.registerClass(HopperFilter.class);
//        MineTweakerAPI.registerClass(SteelAnvil.class);
    }

    @Override
    public void postInit() {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void preInitClient() {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void initClient() {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void postInitClient() {

    }

    /**
     * Helper Methods
     */
    public static Pair<Block, Integer> toBlockMeta(IItemStack iStack) {
        ItemStack stack = toStack(iStack);
        if (stack.getItem() instanceof ItemBlock)
            return Pair.of(((ItemBlock) stack.getItem()).getBlock(), stack.getMetadata());
        return null;
    }

    public static List<ItemStack> toStacks(IItemStack[] iStacks) {
        return Arrays.stream(iStacks).map(MineTweaker::toStack).collect(Collectors.toList());
    }

    public static ItemStack toStack(IItemStack iStack) {
        if (iStack == null)
            return null;
        return (ItemStack) iStack.getInternal();
    }

    public static Object toObject(IIngredient iStack) {
        if (iStack == null)
            return null;
        else {
            if (iStack instanceof IOreDictEntry)
                return ((IOreDictEntry) iStack).getName();
            else if (iStack instanceof IItemStack)
                return toStack((IItemStack) iStack);
            else if (iStack instanceof IngredientStack) {
                IIngredient ingr = ReflectionHelper.getPrivateValue(IngredientStack.class, (IngredientStack) iStack, "ingredient");
                return toObject(ingr);
            } else
                return null;
        }
    }

    public static Object[] toObjects(IIngredient[] iStacks) {
        Object[] oA = new Object[iStacks.length];
        for (int i = 0; i < iStacks.length; i++)
            oA[i] = toObject(iStacks[i]);
        return oA;
    }

    public static FluidStack toFluidStack(ILiquidStack iStack) {
        if (iStack == null) {
            return null;
        }
        return (FluidStack) iStack.getInternal();
    }
}
