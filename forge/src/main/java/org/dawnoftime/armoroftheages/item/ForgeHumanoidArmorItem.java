package org.dawnoftime.armoroftheages.item;

import javax.annotation.Nullable;

import net.minecraft.world.item.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.jetbrains.annotations.NotNull;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Consumer;

public class ForgeHumanoidArmorItem extends HumanoidArmorItem {

	public ForgeHumanoidArmorItem(String armorSetName, ArmorMaterial material, Type slot) {
		super(armorSetName, material, slot);
	}

	@Override
	public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return this.getTexture(entity).toString();
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			private ArmorModelProvider armorModelProvider;
			private HumanoidModel<?> model;
			public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
				if(this.armorModelProvider != ForgeHumanoidArmorItem.this.getModelProvider()){
					this.armorModelProvider = ForgeHumanoidArmorItem.this.getModelProvider();
					this.model = this.armorModelProvider.createModel();
				}
				if(this.model == null){
					return defaultModel;
				}else{
					this.model.young = living.isBaby();
					this.model.crouching = living.isShiftKeyDown();
					this.model.riding = defaultModel.riding;
					return this.model;
				}
			}
		});
	}
}
