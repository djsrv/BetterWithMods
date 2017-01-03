package betterwithmods.modules.integration;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.NetherSpawnWhitelist;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@SuppressWarnings("unused")
public class Quark extends Feature {

    public static final String MODID = "quark";
    public String[] wood = {"spruce", "birch", "jungle", "acacia", "dark_oak"};

    @Override
    public void init(FMLInitializationEvent event) {
        NetherSpawnWhitelist.addBlock(Block.REGISTRY.getObject(new ResourceLocation(MODID, "basalt")), 0);
        //TODO
//        for (int i = 0; i < 5; i++)
//            GameRegistry.addShapedRecipe(new ItemStack(Block.REGISTRY.getObject(new ResourceLocation(MODID, "custom_chest")), 1, i), "SSS", "S S", "SSS", 'S', new ItemStack(BWMBlocks.WOOD_SIDING, 1, i + 1));
    }

}
