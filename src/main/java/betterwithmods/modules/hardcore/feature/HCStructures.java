package betterwithmods.modules.hardcore.feature;

import betterwithmods.base.modules.Feature;
import betterwithmods.base.util.RecipeUtils;
import betterwithmods.modules.hardcore.world.BWComponentScatteredFeaturePieces;
import betterwithmods.modules.hardcore.world.BWMapGenScatteredFeature;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class HCStructures extends Feature {
    @Override
    public void init(FMLInitializationEvent event) {
        MapGenStructureIO.registerStructure(BWMapGenScatteredFeature.Start.class, "BWTemple");
        MapGenStructureIO.registerStructureComponent(BWComponentScatteredFeaturePieces.DesertPyramid.class, "BWTeDP");
        MapGenStructureIO.registerStructureComponent(BWComponentScatteredFeaturePieces.JunglePyramid.class, "BWTeJP");
        MapGenStructureIO.registerStructureComponent(BWComponentScatteredFeaturePieces.SwampHut.class, "BWTeSH");
        MapGenStructureIO.registerStructureComponent(BWComponentScatteredFeaturePieces.Igloo.class, "BWIglu");
        RecipeUtils.removeRecipes(Blocks.ENCHANTING_TABLE);
        RecipeUtils.removeRecipes(Items.BREWING_STAND, 0);
    }

    @Override
    public boolean hasSubscriptions() {
        return true;
    }

    @SubscribeEvent
    public void overrideScatteredFeature(InitMapGenEvent event) {
        if (event.getType().equals(InitMapGenEvent.EventType.SCATTERED_FEATURE))
            event.setNewGen(new BWMapGenScatteredFeature());
    }
}

