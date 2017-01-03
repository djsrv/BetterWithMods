package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.modules.Feature;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by blueyu2 on 11/28/16.
 */
public class HCRedstone extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        addRecipes();
    }

    public void addRecipes() {
        //TODO
//        RecipeUtils.removeRecipes(Blocks.DISPENSER);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.DISPENSER, "CCC", "CBC", "CRC", 'C', "cobblestone", 'B', Items.BOW, 'R', ItemMaterial.getMaterial("redstone_latch")));
//        RecipeUtils.removeRecipes(Blocks.DROPPER);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.DROPPER, "CCC", "C C", "CRC", 'C', "cobblestone", 'R', ItemMaterial.getMaterial("redstone_latch")));
//        //Reduce Iron Door & Iron Trapdoor Output?
//        RecipeUtils.removeRecipes(Items.IRON_DOOR, 0);
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.IRON_DOOR, 3), "RII", " II", "RII", 'I', "ingotIron", 'R', ItemMaterial.getMaterial("redstone_latch")));
//        RecipeUtils.removeRecipes(Blocks.IRON_TRAPDOOR);
//        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.IRON_TRAPDOOR, 2), "RII", "RII", 'I', "ingotIron", 'R', ItemMaterial.getMaterial("redstone_latch")));
//        RecipeUtils.removeRecipes(Blocks.LEVER);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.LEVER, "S", "C", "R", 'S', "stickWood", 'C', "cobblestone", 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.PISTON);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.PISTON, "WIW", "CSC", "CRC", 'W', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 'I', "ingotIron", 'C', "cobblestone", 'S', new ItemStack(BWMBlocks.URN, 1, BlockUrn.EnumUrnType.FULL.getMeta()), 'R', ItemMaterial.getMaterial("redstone_latch")));
//        RecipeUtils.removeRecipes(Blocks.STONE_BUTTON);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.STONE_BUTTON, "C", "R", 'C', new ItemStack(BWMBlocks.STONE_CORNER, 1, BlockMini.EnumType.STONE.getMetadata()), 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.STONE_PRESSURE_PLATE);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.STONE_PRESSURE_PLATE, "S", "R", 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata()), 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.TRIPWIRE_HOOK);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.TRIPWIRE_HOOK, "I", "M", "R", 'I', "nuggetIron", 'M', new ItemStack(BWMBlocks.WOOD_MOULDING, 1, 32767), 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.WOODEN_BUTTON);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.WOODEN_BUTTON, "C", "R", 'C', new ItemStack(BWMBlocks.WOOD_CORNER, 1, 32767), 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.WOODEN_PRESSURE_PLATE);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.WOODEN_PRESSURE_PLATE, "S", "R", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, 32767), 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Items.REPEATER, 0);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Items.REPEATER, "RCR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'C', Items.CLOCK, 'S', "stone"));
//        GameRegistry.addRecipe(new ShapedOreRecipe(Items.REPEATER, "RCR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'C', Items.CLOCK, 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata())));
//
//        RecipeUtils.removeRecipes(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, "II", "RR", 'I', "ingotIron", 'R', "dustRedstone"));
//        RecipeUtils.removeRecipes(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, "GG", "RR", 'G', "ingotGold", 'R', "dustRedstone"));
//        //Have hopper use Soulforged Steel?
//        RecipeUtils.removeRecipes(Blocks.HOPPER);
//        GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.HOPPER, "ICI", "IRI", " I ", 'I', "ingotIron", 'C', "chestWood", 'R', ItemMaterial.getMaterial("redstone_latch")));
//        GameRegistry.addRecipe(new ShapedOreRecipe(Items.COMPARATOR, " R ", "RQR", "SSS", 'R', Blocks.REDSTONE_TORCH, 'Q', "gemQuartz", 'S', new ItemStack(BWMBlocks.STONE_SIDING, 1, BlockMini.EnumType.STONE.getMetadata())));
    }
    @SubscribeEvent
    public void disableRedstone(BlockEvent.NeighborNotifyEvent event) {
        event.setCanceled(true);
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        for (EnumFacing facing : event.getNotifiedSides()) {
            IBlockState state = world.getBlockState(pos.offset(facing));
            Block block = state.getBlock();
            if (block instanceof BlockDoor || block instanceof BlockFenceGate || block instanceof BlockTrapDoor) {
                if (!state.getMaterial().equals(Material.IRON))
                    continue;
            }
            world.notifyBlockOfStateChange(pos.offset(facing), event.getState().getBlock());
        }
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }
}
