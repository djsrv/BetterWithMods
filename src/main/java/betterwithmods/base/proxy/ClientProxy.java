package betterwithmods.base.proxy;

import betterwithmods.base.blocks.tile.TileEntityCauldron;
import betterwithmods.base.blocks.tile.TileEntityCrucible;
import betterwithmods.base.blocks.tile.TileEntityFilteredHopper;
import betterwithmods.base.blocks.tile.TileEntityTurntable;
import betterwithmods.base.blocks.tile.gen.TileEntityWaterwheel;
import betterwithmods.base.blocks.tile.gen.TileEntityWindmillHorizontal;
import betterwithmods.base.blocks.tile.gen.TileEntityWindmillVertical;
import betterwithmods.base.client.BWStateMapper;
import betterwithmods.base.client.ColorHandlers;
import betterwithmods.base.client.model.TESRCauldron;
import betterwithmods.base.client.model.TESRCrucible;
import betterwithmods.base.client.model.TESRFilteredHopper;
import betterwithmods.base.client.model.TESRTurntable;
import betterwithmods.base.client.model.TESRVerticalWindmill;
import betterwithmods.base.client.model.TESRWaterwheel;
import betterwithmods.base.client.model.TESRWindmill;
import betterwithmods.base.client.model.render.RenderUtils;
import betterwithmods.base.client.render.RenderBroadheadArrow;
import betterwithmods.base.client.render.RenderCowHarness;
import betterwithmods.base.client.render.RenderExtendingRope;
import betterwithmods.base.client.render.RenderMiningCharge;
import betterwithmods.base.client.render.RenderPigHarness;
import betterwithmods.base.client.render.RenderShearedCreeper;
import betterwithmods.base.client.render.RenderSheepHarness;
import betterwithmods.base.entity.EntityBroadheadArrow;
import betterwithmods.base.entity.EntityDynamite;
import betterwithmods.base.entity.EntityExtendingRope;
import betterwithmods.base.entity.EntityMiningCharge;
import betterwithmods.base.entity.EntityShearedCreeper;
import betterwithmods.base.modules.ModuleLoader;
import betterwithmods.base.registry.BWMBlocks;
import betterwithmods.base.registry.BWMItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@SuppressWarnings("unused")
public class ClientProxy extends ServerProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModuleLoader.preInitClient(e);
        registerRenderInformation();
        initRenderers();

    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ModuleLoader.initClient(e);
        registerColors();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        ModuleLoader.postInitClient(e);
    }

    private void registerRenderInformation() {
        BWMBlocks.linkBlockModels();
        BWMItems.linkItemModels();
        RenderUtils.registerFilters();
        ModelLoader.setCustomStateMapper(BWMBlocks.STOKED_FLAME, new BWStateMapper(BWMBlocks.STOKED_FLAME.getRegistryName().toString()));
        ModelLoader.setCustomStateMapper(BWMBlocks.WINDMILL_BLOCK, new BWStateMapper(BWMBlocks.WINDMILL_BLOCK.getRegistryName().toString()));
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillHorizontal.class, new TESRWindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillVertical.class, new TESRVerticalWindmill());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterwheel.class, new TESRWaterwheel());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilteredHopper.class, new TESRFilteredHopper());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurntable.class, new TESRTurntable());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCrucible.class, new TESRCrucible());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCauldron.class, new TESRCauldron());
    }

    private void registerColors() {
        final BlockColors col = Minecraft.getMinecraft().getBlockColors();
        col.registerBlockColorHandler(ColorHandlers.BlockPlanterColor, BWMBlocks.PLANTER);
        col.registerBlockColorHandler(ColorHandlers.BlockFoliageColor, BWMBlocks.VINE_TRAP);
        final ItemColors itCol = Minecraft.getMinecraft().getItemColors();
        itCol.registerItemColorHandler(ColorHandlers.ItemPlanterColor, BWMBlocks.PLANTER);
        itCol.registerItemColorHandler(ColorHandlers.ItemFoliageColor, BWMBlocks.VINE_TRAP);
    }

    private void initRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, manager -> new RenderSnowball<>(manager, BWMItems.DYNAMITE, Minecraft.getMinecraft().getRenderItem()));
        RenderingRegistry.registerEntityRenderingHandler(EntityMiningCharge.class, RenderMiningCharge::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityExtendingRope.class, RenderExtendingRope::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShearedCreeper.class, RenderShearedCreeper::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCow.class, RenderCowHarness::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPig.class, RenderPigHarness::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySheep.class, RenderSheepHarness::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBroadheadArrow.class, RenderBroadheadArrow::new);
    }
}
