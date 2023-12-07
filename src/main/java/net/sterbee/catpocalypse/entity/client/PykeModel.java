package net.sterbee.catpocalypse.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.sterbee.catpocalypse.entity.animations.ModAnimations;
import net.sterbee.catpocalypse.entity.custom.PykeEntity;

public class PykeModel<T extends PykeEntity> extends SinglePartEntityModel<T> {
    private final ModelPart pyke;
    private final ModelPart head;

    public PykeModel(ModelPart root) {
        this.pyke = root.getChild("pyke");
        this.head = pyke.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData pyke = modelPartData.addChild("pyke", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 24.0F, 0.0F));

        ModelPartData head = pyke.addChild("head", ModelPartBuilder.create().uv(0, 15).cuboid(-3.0F, -14.0F, -1.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, -7.8F, 0.0436F, 0.0F, 0.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(3, 4).cuboid(-1.5F, -12.25F, -1.25F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftear = head.addChild("leftear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftear_r1 = leftear.addChild("leftear_r1", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -12.8F, 4.0F, 1.0F, 2.0F, 0.4F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -2.0F, 0.0F, 0.1745F, -0.5236F, -0.0436F));

        ModelPartData rightear = head.addChild("rightear", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightear_r1 = rightear.addChild("rightear_r1", ModelPartBuilder.create().uv(0, 2).cuboid(-1.0F, -12.8F, 4.0F, 1.0F, 2.0F, 0.4F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -2.0F, 0.0F, 0.1745F, 0.5236F, 0.0436F));

        ModelPartData eyes = head.addChild("eyes", ModelPartBuilder.create().uv(28, 17).cuboid(-0.5F, -13.0F, -1.1F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(28, 17).cuboid(-2.5F, -13.0F, -1.1F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData whiskers = head.addChild("whiskers", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -5.0F, 8.0F));

        ModelPartData leftwhiskers = whiskers.addChild("leftwhiskers", ModelPartBuilder.create().uv(28, 23).cuboid(1.0F, -7.0F, -8.9F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(28, 26).cuboid(1.0F, -7.0F, -9.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightwhiskers = whiskers.addChild("rightwhiskers", ModelPartBuilder.create().uv(29, 18).cuboid(-4.0F, -7.0F, -9.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(29, 18).cuboid(-3.5F, -6.5F, -8.9F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData body = pyke.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.75F, -7.25F, -6.0F, 3.5F, 4.0F, 11.0F, new Dilation(0.0F))
                .uv(19, 0).cuboid(-2.9F, -7.5F, 4.0F, 3.8F, 4.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData legs = pyke.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData topright = legs.addChild("topright", ModelPartBuilder.create().uv(20, 21).cuboid(-3.0F, -6.5F, -5.0F, 1.0F, 6.5F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData topleft = legs.addChild("topleft", ModelPartBuilder.create().uv(14, 21).cuboid(0.0F, -6.75F, -5.0F, 1.0F, 6.75F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bottomleft = legs.addChild("bottomleft", ModelPartBuilder.create().uv(0, 5).cuboid(-0.25F, -4.0F, 4.5F, 1.0F, 4.0F, 1.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bottomright = bottomleft.addChild("bottomright", ModelPartBuilder.create().uv(0, 23).cuboid(-2.75F, -4.0F, 4.5F, 1.0F, 4.0F, 1.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = pyke.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData fronttail = tail.addChild("fronttail", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -6.0F, 5.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData backtail = tail.addChild("backtail", ModelPartBuilder.create().uv(16, 15).cuboid(-1.6F, -6.1F, 9.0F, 1.2F, 1.2F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    /**
     * Resets the animations so they dont combine.
     */
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        pyke.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return pyke;
    }

}