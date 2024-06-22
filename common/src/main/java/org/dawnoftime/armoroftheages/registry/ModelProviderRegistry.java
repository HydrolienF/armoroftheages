package org.dawnoftime.armoroftheages.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.ChestAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.FeetAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.HeadAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.LegsAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.ChestJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.FeetJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.HeadJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.LegsJapaneseLightArmorModel;

import static org.dawnoftime.armoroftheages.Constants.ANUBIS_ARMOR_NAME;
import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, ArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, HeadJapaneseLightArmorModel::new, HeadJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST, ChestJapaneseLightArmorModel::new, ChestJapaneseLightArmorModel::createLayerDefinition, ChestJapaneseLightArmorModel::createSlimLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS, LegsJapaneseLightArmorModel::new, LegsJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET, FeetJapaneseLightArmorModel::new, FeetJapaneseLightArmorModel::createLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.HEAD, HeadAnubisArmorModel::new, HeadAnubisArmorModel::createLayerDefinition, HeadAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.CHEST, ChestAnubisArmorModel::new, ChestAnubisArmorModel::createLayerDefinition, ChestAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.LEGS, LegsAnubisArmorModel::new, LegsAnubisArmorModel::createLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.FEET, FeetAnubisArmorModel::new, FeetAnubisArmorModel::createLayerDefinition);
    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Supplier<LayerDefinition> layerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, layerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }

    private static void register(String armorName, EquipmentSlot slot, ArmorModelSupplier armorModelSupplier, Supplier<LayerDefinition> layerDefinition, Supplier<LayerDefinition> slimLayerDefinition){
        ArmorModelProvider provider = ArmorModelProvider.create(armorName, slot, armorModelSupplier, layerDefinition, slimLayerDefinition);
        REGISTRY.put(armorName + "_" + slot.name().toLowerCase(), provider);
    }
}