package org.dawnoftime.armoroftheages.client.models.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.jetbrains.annotations.NotNull;

public class FeetJapaneseLightArmorModel<T extends LivingEntity> extends ArmorModel<T> {

    public FeetJapaneseLightArmorModel(ModelPart root, boolean isSlim) {
        super(root, isSlim);
    }

    @Override
    public <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim) {
        return new FeetJapaneseLightArmorModel<>(root, isSlim);
    }

    public static LayerDefinition createLayerDefinition() {
        // TODO handle the scale !
        MeshDefinition meshdefinition = templateLayerDefinition(1.0F);
        PartDefinition root = meshdefinition.getRoot();
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 16).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.4F)), PartPose.ZERO);
        head.addOrReplaceChild("knotBase", CubeListBuilder.create().texOffs(56, 9).addBox(2.9F, -4.9F, 3.7F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.785F));
        head.addOrReplaceChild("ribbonA", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.01F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.35F, 0.0F, 0.0F));
        head.addOrReplaceChild("ribbonB", CubeListBuilder.create().texOffs(60, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 9.0F, 0.01F, CubeDeformation.NONE), PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.175F, 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    protected void setupArmorPartAnim(@NotNull LivingEntity entity, float ageInTicks) {}
}
