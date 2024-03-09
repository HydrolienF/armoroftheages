package org.armoroftheages.model.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.armoroftheages.model.HumanoidArmorPartModel;

import java.util.Set;

public class JapaneseLightFeetModel<T extends LivingEntity> extends HumanoidArmorPartModel<T> {
	public JapaneseLightFeetModel(ModelPart root) {
		super(root);
	}
	/*
		this.rightLeg = new ModelRenderer(this, 40, 0);
		this.rightLeg.setPos(-1.9F, 12.0F, 0.0F);
		this.rightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);

		this.leftLeg = new ModelRenderer(this, 40, 0);
		this.leftLeg.mirror = true;
		this.leftLeg.setPos(1.9F, 12.0F, 0.0F);
		this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.3F);
	*/

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(40, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create()
				.texOffs(40, 0).addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, new CubeDeformation(0.3F)), PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	protected void setupArmorPartAnim(T entityIn, float ageInTicks) {}

	@Override
	protected Set<ModelPart> getRenderedParts() {
		return null;
	}
}