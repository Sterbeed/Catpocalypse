package net.sterbee.catpocalypse.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sterbee.catpocalypse.Catpocalypse;
import net.sterbee.catpocalypse.entity.custom.PykeEntity;

public class PykeRender extends MobEntityRenderer<PykeEntity, PykeModel<PykeEntity>> {

    //The texture Pyke's model uses
    private static final Identifier TEXTURE = new Identifier(Catpocalypse.MOD_ID, "textures/entity/pykey.png");

    public PykeRender(EntityRendererFactory.Context context) {
        super(context, new PykeModel<>(context.getPart(ModModelLayers.PYKE)), 0.6f);
    }

    //Override the default get texture and instead return the texture pyker.png
    @Override
    public Identifier getTexture(PykeEntity entity) {
        return TEXTURE;
    }

    //This is pyke's shadow when he is baby pyke and adult pyke
    @Override
    public void render(PykeEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
