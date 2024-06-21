package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;

public interface ArmorModelSupplier {
    <E extends LivingEntity> ArmorModel<E> create(ModelPart root, boolean isSlim);
}