package betterwithmods.modules.utilities.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.utilities.blocks.BlockBUD;
import betterwithmods.modules.utilities.blocks.BlockChime;
import betterwithmods.modules.utilities.blocks.BlockDetector;
import betterwithmods.modules.utilities.blocks.BlockInvisibleLight;
import betterwithmods.modules.utilities.blocks.BlockLens;
import betterwithmods.modules.utilities.blocks.BlockLight;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class Redstone extends Feature {
    public static Block BUDDY_BLOCK;
    public static Block DETECTOR;
    public static Block LENS;
    public static Block LENS_SOURCE;
    public static Block LIGHT;
    public static Block BAMBOO_CHIME;
    public static Block METAL_CHIME;

    public static int lensRange;

    @Override
    public void setupConfig() {
        lensRange = loadPropInt("Lens Range", "Range the lens light will shine",256,0,512);
    }

    @Override
    public void preInitClient(FMLPreInitializationEvent event) {
        BUDDY_BLOCK = new BlockBUD().setRegistryName("buddy_block");
        DETECTOR = new BlockDetector().setRegistryName("detector");
        LENS = new BlockLens().setRegistryName("lens");
        LENS_SOURCE = new BlockInvisibleLight().setRegistryName("invisible_light");
        LIGHT = new BlockLight().setRegistryName("light");
        BAMBOO_CHIME = new BlockChime(Material.WOOD).setRegistryName("bamboo_chime");
        METAL_CHIME = new BlockChime(Material.IRON).setRegistryName("metal_chime");

        registerBlock(BAMBOO_CHIME, new ItemBlockMeta(BAMBOO_CHIME));
        registerBlock(METAL_CHIME, new ItemBlockMeta(METAL_CHIME));
        registerBlock(BUDDY_BLOCK);
        registerBlock(LIGHT);
        registerBlock(DETECTOR);
        registerBlock(LENS);
        registerBlock(LENS_SOURCE, null);
    }
}
