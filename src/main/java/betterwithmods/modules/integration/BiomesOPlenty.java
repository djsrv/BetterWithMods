package betterwithmods.modules.integration;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.NetherSpawnWhitelist;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@SuppressWarnings("unused")
public class BiomesOPlenty extends Feature {
    public static final String MODID = "biomesoplenty";

    @Override
    public void init(FMLInitializationEvent event) {
        NetherSpawnWhitelist.addBlock(Block.REGISTRY.getObject(new ResourceLocation(MODID, "grass")), 1);
        NetherSpawnWhitelist.addBlock(Block.REGISTRY.getObject(new ResourceLocation(MODID, "grass")), 6);
        NetherSpawnWhitelist.addBlock(Block.REGISTRY.getObject(new ResourceLocation(MODID, "flesh")));
        NetherSpawnWhitelist.addBlock(Block.REGISTRY.getObject(new ResourceLocation(MODID, "ash_block")));
    }
}
