package org.dawnoftime.armoroftheages.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.ChestJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.FeetJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.HeadJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.LegsJapaneseLightArmorModel;

import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, ArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, HeadJapaneseLightArmorModel::new, HeadJapaneseLightArmorModel.class, HeadJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST, ChestJapaneseLightArmorModel::new, ChestJapaneseLightArmorModel.class, ChestJapaneseLightArmorModel::createLayerDefinition, ChestJapaneseLightArmorModel::createSlimLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS, LegsJapaneseLightArmorModel::new, LegsJapaneseLightArmorModel.class, LegsJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET, FeetJapaneseLightArmorModel::new, FeetJapaneseLightArmorModel.class, FeetJapaneseLightArmorModel::createLayerDefinition);
    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, modelClass, layerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinition, Supplier<LayerDefinition> slimLayerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, modelClass, layerDefinition, slimLayerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }
}