package org.armoroftheages.model.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.armoroftheages.model.HumanoidArmorPartModel;

import java.util.Set;

public class JapaneseLightChestModel<T extends LivingEntity> extends HumanoidArmorPartModel<T> {

	public JapaneseLightChestModel(ModelPart root) {
		super(root);
	}
	/*
				if(isSteve){
					this.rightArm = new ModelRenderer(this, 24, 0);
					this.rightArm.setPos(-5.0F, 2.0F, 0.0F);
					this.rightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F);
					armRightArmor = new ModelRenderer(this, 12, 16);
					armRightArmor.mirror = true;
					armRightArmor.setPos(0.0F, 0.0F, 0.0F);
					armRightArmor.addBox(-3.5F, 3.0F, -2.5F, 2, 5, 5, 0.2F);

					this.leftArm = new ModelRenderer(this, 24, 0);
					this.leftArm.mirror = true;
					this.leftArm.setPos(5.0F, 2.0F, 0.0F);
					this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.3F);
					armLeftArmor = new ModelRenderer(this, 12, 16);
					armLeftArmor.setPos(0.0F, 0.0F, 0.0F);
					armLeftArmor.addBox(1.5F, 3.0F, -2.5F, 2, 5, 5, 0.2F);
				}else{
					ModelRenderer bodyBreast = new ModelRenderer(this, 0, 26);
					bodyBreast.setPos(0.0F, 1.3F, -2.0F);
					bodyBreast.addBox(-3.0F, 0.0F, -3.65F, 6, 2, 3, 0.1F);
					setRotationAngle(bodyBreast, 0.9948376736367678F, 0.0F, 0.0F);
					this.body.addChild(bodyBreast);

					this.rightArm = new ModelRenderer(this, 24, 0);
					this.rightArm.setPos(-5.0F, 2.5F, 0.0F);
					this.rightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, 0.3F);
					armRightArmor = new ModelRenderer(this, 12, 16);
					armRightArmor.mirror = true;
					armRightArmor.setPos(0.0F, 0.0F, 0.0F);
					armRightArmor.addBox(-2.5F, 3.0F, -2.5F, 2, 5, 5, 0.1F);

					this.leftArm = new ModelRenderer(this, 24, 0);
					this.leftArm.mirror = true;
					this.leftArm.setPos(5.0F, 2.5F, 0.0F);
					this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, 0.3F);
					armLeftArmor = new ModelRenderer(this, 12, 16);
					armLeftArmor.setPos(0.0F, 0.0F, 0.0F);
					armLeftArmor.addBox(0.5F, 3.0F, -2.5F, 2, 5, 5, 0.1F);
				}

				this.leftArm.addChild(armLeftArmor);
				this.rightArm.addChild(armRightArmor);
	*/

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild(
				"head",
				CubeListBuilder.create()
						.texOffs(26, 16).addBox(-4.0F, -6.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.4F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		head.addOrReplaceChild(
				"knotBase",
				CubeListBuilder.create()
						.texOffs(56, 9).addBox(2.9F, -4.9F, 3.7F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.785F));
		head.addOrReplaceChild(
				"ribbonA",
				CubeListBuilder.create()
						.texOffs(56, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.35F, 0.0F, 0.0F));
		head.addOrReplaceChild(
				"ribbonB",
				CubeListBuilder.create()
						.texOffs(60, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.0F, 4.2F, 0.175F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	protected void setupArmorPartAnim(T entityIn, float ageInTicks) {}

	@Override
	protected Set<ModelPart> getRenderedParts() {
		return null;
	}
}