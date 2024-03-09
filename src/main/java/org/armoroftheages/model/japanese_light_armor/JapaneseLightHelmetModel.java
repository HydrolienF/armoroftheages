package org.armoroftheages.model.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.armoroftheages.model.HumanoidArmorPartModel;

import java.util.Set;

public class JapaneseLightHelmetModel<T extends LivingEntity> extends HumanoidArmorPartModel<T> {

	private final ModelPart ribbonA;
	private final ModelPart ribbonB;

	public JapaneseLightHelmetModel(ModelPart root) {
		super(root);
		this.ribbonA = root.getChild("ribbonA");
		this.ribbonB = root.getChild("ribbonB");
	}

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(26, 16).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.4F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild("knotBase", CubeListBuilder.create()
				.texOffs(56, 9).addBox(2.9F, -4.9F, 3.7F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.785F));
		head.addOrReplaceChild("ribbonA", CubeListBuilder.create()
				.texOffs(56, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.35F, 0.0F, 0.0F));
		head.addOrReplaceChild("ribbonB", CubeListBuilder.create()
				.texOffs(60, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.175F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	protected void setupArmorPartAnim(T entityIn, float ageInTicks) {
		float f = 0.3F * sinPI(ageInTicks / 60.0F + 1.0F) + Math.abs(this.rightLeg.xRot);
		this.ribbonA.xRot = Math.max(0.35F + f * 0.15F - this.head.xRot, 0.2F);
		this.ribbonA.zRot = -0.1F + f * 0.2F;
		this.ribbonB.xRot = Math.max(0.175F + f * 0.1F - this.head.xRot, 0.075F);
		this.ribbonB.zRot = -f * 0.2F;
	}

	@Override
	protected Set<ModelPart> getRenderedParts() {
		return null;
	}
}