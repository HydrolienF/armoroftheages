package org.dawnoftime.armoroftheages.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.client.renderer.entity.LivingEntityRenderer.isEntityUpsideDown;

@Mixin(HumanoidArmorLayer.class)
public abstract class MixinHumanoidArmorLayer<T extends LivingEntity, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {

    @Unique
    private final Map<EquipmentSlot, ArmorModel<T>> armoroftheages$modelsMap = new HashMap<>();

    public MixinHumanoidArmorLayer(RenderLayerParent<T, M> parentLayer) {
        super(parentLayer);
    }

    /**
     * MC Armors are not animated, share the same model and visible parts.
     * Since my armors need these features, I will use a custom rendering method if the item in the slot in a {@link HumanoidArmorItem}.
     * If the model is correctly rendered, I will cancel the execution of the rest of the function.
     */
    @Inject(method = "renderArmorPiece", at = @At("HEAD"), cancellable = true)
    private void onRenderArmorPiece(PoseStack stack, MultiBufferSource buffer, T entity, EquipmentSlot slot, int partialTick, A defaultModel, CallbackInfo ci) {
        ItemStack itemStack = entity.getItemBySlot(slot);
        if (itemStack.getItem() instanceof HumanoidArmorItem armorItem) {
            if (armorItem.getEquipmentSlot() == slot) {
                ArmorModel<T> model = this.armoroftheages$modelsMap.get(slot);
                // If the entity has a different model stored, we change the model.
                if(model == null || model.getClass() != armorItem.getModelProvider().getModelClass()){
                    model = armorItem.getModelProvider().createModel(entity);
                    this.armoroftheages$modelsMap.put(slot, model);
                }
                // Now we will animate the models !
                // Ensure the model is compatible with HumanoidModel<T>
                this.getParentModel().copyPropertiesTo(model);
                model.setPartVisibility(slot);

                float $$6 = Mth.rotLerp(partialTick, entity.yBodyRotO, entity.yBodyRot);
                float $$7 = Mth.rotLerp(partialTick, entity.yHeadRotO, entity.yHeadRot);
                float netHeadYaw = $$7 - $$6;
                if (entity.isPassenger() && entity.getVehicle() instanceof LivingEntity entityVehicle) {
                    $$6 = Mth.rotLerp(partialTick, entityVehicle.yBodyRotO, entityVehicle.yBodyRot);
                    netHeadYaw = $$7 - $$6;
                    float $$10 = Mth.wrapDegrees(netHeadYaw);
                    if ($$10 < -85.0F) {
                        $$10 = -85.0F;
                    }
                    if ($$10 >= 85.0F) {
                        $$10 = 85.0F;
                    }
                    $$6 = $$7 - $$10;
                    if ($$10 * $$10 > 2500.0F) {
                        $$6 += $$10 * 0.2F;
                    }
                    netHeadYaw = $$7 - $$6;
                }
                float headPitch = Mth.lerp(partialTick, entity.xRotO, entity.getXRot());
                if (isEntityUpsideDown(entity)) {
                    headPitch *= -1.0F;
                    netHeadYaw *= -1.0F;
                }
                float ageInTicks = (float)entity.tickCount + partialTick;
                float limbSwingAmount = 0.0F;
                float limbSwing = 0.0F;
                if (!entity.isPassenger() && entity.isAlive()) {
                    limbSwingAmount = entity.walkAnimation.speed(partialTick);
                    limbSwing = entity.walkAnimation.position(partialTick);
                    if (entity.isBaby()) {
                        limbSwing *= 3.0F;
                    }
                    if (limbSwingAmount > 1.0F) {
                        limbSwingAmount = 1.0F;
                    }
                }
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(armorItem.getModelProvider().getTexture(entity)));
                model.renderToBuffer(stack, vertexconsumer, partialTick, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

                if (itemStack.hasFoil()) {
                    model.renderToBuffer(stack, buffer.getBuffer(RenderType.armorEntityGlint()), partialTick, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
                }
                ci.cancel();
            }else{
                // The item in the slot is not in the slot it is supposed to be in.
                this.armoroftheages$modelsMap.remove(slot);
            }
        }else{
            // The item in the given slot is not an armor from this mode. We remove the key and value in the map if needed.
            this.armoroftheages$modelsMap.remove(slot);
        }
    }
}