package betterwithmods.integration.immersiveengineering;

import betterwithmods.BWMBlocks;
import betterwithmods.config.BWConfig;
import betterwithmods.items.ItemMaterial;
import betterwithmods.modules.integration.CompatFeature;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by tyler on 9/10/16.
 */
@SuppressWarnings("unused")
public class ImmersiveEngineering extends CompatFeature {
    public static final Block TREATED_AXLE = new betterwithmods.integration.immersiveengineering.BlockImmersiveAxle().setRegistryName("immersive_axle");

    public static final String MODID = "immersiveengineering";

    public static boolean overrideIndustrialHempDrops;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        BWMBlocks.registerBlock(TREATED_AXLE);
        GameRegistry.registerTileEntity(betterwithmods.integration.immersiveengineering.TileEntityImmersiveAxle.class, "bwm.immersive_axle");
        BWConfig.config.load();
        overrideIndustrialHempDrops = BWConfig.config.getBoolean("Override Hemp Drop", BWConfig.MOD_COMPAT, true, "Replaces drop from IE Industrial Hemp with BWM Hemp");
        BWConfig.config.save();
        if (overrideIndustrialHempDrops) {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        BWMBlocks.setInventoryModel(TREATED_AXLE);
    }



    @Override
    public void init(FMLInitializationEvent event) {
        ItemStack conveyorStack = ConveyorHandler.getConveyorStack("immersiveengineering:conveyor");
        addOredictRecipe(Utils.copyStackWithAmount(conveyorStack, 8), "LLL", "IRI", Character.valueOf('I'), "ingotIron", Character.valueOf('R'), "dustRedstone", Character.valueOf('L'), ItemMaterial.getMaterial("leather_cut"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(TREATED_AXLE), "W", "R", "W", 'W', "plankTreatedWood", 'R', BWMBlocks.ROPE));
        Fluid seedOil = FluidRegistry.getFluid("plantoil");
        SqueezerRecipe.addRecipe(new FluidStack(seedOil, 120), null, new ItemStack(BWMBlocks.HEMP, 1, 0), 6400);
    }



    @SubscribeEvent
    public void overrideHempDrops(BlockEvent.HarvestDropsEvent e) {
        IBlockState state = e.getState();
        if (state.getBlock() instanceof BlockIECrop) {
            e.getDrops().clear();
            int meta = state.getBlock().getMetaFromState(state);
            if (meta >= 4) {
                e.getDrops().add(new ItemStack(IEContent.itemSeeds));
                e.getDrops().add(ItemMaterial.getMaterial("hemp"));
            }
        }
    }

    @Override
    public String getRequiredMod() {
        return MODID;
    }
}
