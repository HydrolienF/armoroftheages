package org.dawnoftime.armoroftheages.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ForgeHumanoidArmorItem extends HumanoidArmorItem{
    /**
    This class only purpose is to match forge standard armor behavior, expected from other mods.
    Some mods call the ForgeHooksClient#getArmorModel() method, to get and use the custom models.
    All the function in this class are never called or used to render our armors by default.
    */
    public ForgeHumanoidArmorItem(@NotNull String armorSetName, Holder<ArmorMaterial> material, Type type, int durabilityFactor) {
        super(armorSetName, material, type, durabilityFactor);
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(@NotNull LivingEntity living, @NotNull ItemStack stack, @NotNull EquipmentSlot slot, @NotNull HumanoidModel<?> defaultModel) {
                final ArmorModelProvider provider = ForgeHumanoidArmorItem.this.getModelProvider();
                if(provider != null){
                    HumanoidModel<?> model = provider.getArmorModel(living);
                    model.crouching = living.isShiftKeyDown();
                    model.riding = defaultModel.riding;
                    return model;
                }else{
                    return defaultModel;
                }
            }
        });
    }

    @Override
    public @Nullable ResourceLocation getArmorTexture(@NotNull ItemStack stack, @NotNull Entity entity, @NotNull EquipmentSlot slot, ArmorMaterial.@NotNull Layer layer, boolean innerModel) {
        ArmorModelProvider provider = this.getModelProvider();
        return provider != null ? provider.getTexture(entity) : null;
    }
}
