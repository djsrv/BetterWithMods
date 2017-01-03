package betterwithmods.modules.aesthetic.features;

import betterwithmods.base.blocks.ItemBlockMeta;
import betterwithmods.base.modules.Feature;
import betterwithmods.modules.aesthetic.blocks.BlockAesthetic;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/2/17
 */
public class BuildingBlocks extends Feature {
    public static Block AESTHETIC;

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        //TODO
        AESTHETIC = new BlockAesthetic().setRegistryName("aesthetic");

        registerBlock(AESTHETIC, new ItemBlockMeta(AESTHETIC));
    }
}
