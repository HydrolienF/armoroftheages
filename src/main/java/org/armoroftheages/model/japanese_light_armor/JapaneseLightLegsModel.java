package org.armoroftheages.model.japanese_light_armor;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import org.armoroftheages.model.HumanoidArmorPartModel;

import java.util.Set;

public class JapaneseLightLegsModel<T extends LivingEntity> extends HumanoidArmorPartModel<T> {

	public JapaneseLightLegsModel(ModelPart root) {
		super(root);
	}

	public static LayerDefinition createMesh() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 2, 5, 4, new CubeDeformation(0.6F)), PartPose.offset(0.0F, 0.0F, 0.2F));
		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 2, 5, 4, new CubeDeformation(0.6F)).mirror(false), PartPose.offset(0.0F, 0.0F, -0.2F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	protected void setupArmorPartAnim(T entityIn, float ageInTicks) {}

	@Override
	protected Set<ModelPart> getRenderedParts() {
		return null;
	}
}