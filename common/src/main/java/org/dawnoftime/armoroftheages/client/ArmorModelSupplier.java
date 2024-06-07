package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public interface ArmorModelSupplier {
    ArmorModel<LivingEntity> create(ModelPart root);
}