package betterwithmods.modules.automation.features;

import betterwithmods.base.BWMod;
import betterwithmods.base.modules.Feature;
import betterwithmods.base.registry.BWMBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Purpose:
 *
 * @author Tyler Marshall
 * @version 1/1/17
 */
public class StokedFireOverlay extends Feature {

    @SubscribeEvent
    public void onRenderFireOverlay(RenderBlockOverlayEvent e) {
        if (e.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE) {
            if (e.getPlayer().getEntityWorld().getBlockState(e.getBlockPos()).getBlock() == BWMBlocks.STOKED_FLAME) {
                renderFireInFirstPerson();
                e.setCanceled(true);
            }
        }
    }

    private void renderFireInFirstPerson() {
        Minecraft mc = Minecraft.getMinecraft();
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.9F);
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE,
                GlStateManager.DestFactor.ZERO);

        for (int i = 0; i < 2; ++i) {
            GlStateManager.pushMatrix();
            TextureAtlasSprite textureatlassprite = mc.getTextureMapBlocks()
                    .getTextureExtry(BWMod.MODID + ":blocks/stoked_fire_layer_0");
            if (textureatlassprite == null)
                textureatlassprite = mc.getTextureMapBlocks().getMissingSprite();
            mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float f1 = textureatlassprite.getMinU();
            float f2 = textureatlassprite.getMaxU();
            float f3 = textureatlassprite.getMinV();
            float f4 = textureatlassprite.getMaxV();
            GlStateManager.translate((float) (-(i * 2 - 1)) * 0.24F, -0.3F, 0.0F);
            GlStateManager.rotate((float) (i * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
            vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            vertexbuffer.pos(-0.5D, -0.5D, -0.5D).tex((double) f2, (double) f4).endVertex();
            vertexbuffer.pos(0.5D, -0.5D, -0.5D).tex((double) f1, (double) f4).endVertex();
            vertexbuffer.pos(0.5D, 0.5D, -0.5D).tex((double) f1, (double) f3).endVertex();
            vertexbuffer.pos(-0.5D, 0.5D, -0.5D).tex((double) f2, (double) f3).endVertex();
            tessellator.draw();
            GlStateManager.popMatrix();
        }

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
    }
    @Override
    public boolean hasSubscriptions() {
        return isClient();
    }
}
