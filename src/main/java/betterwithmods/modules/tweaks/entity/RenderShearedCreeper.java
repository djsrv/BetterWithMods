package betterwithmods.modules.tweaks.entity;

import betterwithmods.base.BWMod;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;


public class RenderShearedCreeper extends RenderLiving<EntityShearedCreeper> {

    public RenderShearedCreeper(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCreeper(), 0.5f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShearedCreeper entity) {
        return new ResourceLocation(BWMod.MODID, "textures/entities/sheared_creeper.png");
    }
}