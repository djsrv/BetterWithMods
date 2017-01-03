package betterwithmods.modules.utilities.client.render;

import betterwithmods.base.BWMod;
import betterwithmods.modules.utilities.entity.EntityBroadheadArrow;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 11/18/16
 */
public class RenderBroadheadArrow extends RenderArrow<EntityBroadheadArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(BWMod.MODID, "textures/entities/broadhead_arrow.png");

    public RenderBroadheadArrow(RenderManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBroadheadArrow entity) {
        return TEXTURE;
    }
}
