package org.dawnoftime.armoroftheages.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.ChestAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.FeetAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.HeadAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.anubis_armor.LegsAnubisArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.ChestJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.FeetJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.HeadJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.LegsJapaneseLightArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.ChestCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.FeetCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.HeadCenturionArmorModel;
import org.dawnoftime.armoroftheages.client.models.centurion_armor.LegsCenturionArmorModel;

import static org.dawnoftime.armoroftheages.Constants.*;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, ArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.HEAD, HeadAnubisArmorModel::new, HeadAnubisArmorModel::createLayerDefinition, HeadAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.CHEST, ChestAnubisArmorModel::new, ChestAnubisArmorModel::createLayerDefinition, ChestAnubisArmorModel::createSlimLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.LEGS, LegsAnubisArmorModel::new, LegsAnubisArmorModel::createLayerDefinition);
        register(ANUBIS_ARMOR_NAME, EquipmentSlot.FEET, FeetAnubisArmorModel::new, FeetAnubisArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.HEAD, HeadCenturionArmorModel::new, HeadCenturionArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.CHEST, ChestCenturionArmorModel::new, ChestCenturionArmorModel::createLayerDefinition, ChestCenturionArmorModel::createSlimLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.LEGS, LegsCenturionArmorModel::new, LegsCenturionArmorModel::createLayerDefinition);
        register(CENTURION_ARMOR_NAME, EquipmentSlot.FEET, FeetCenturionArmorModel::new, FeetCenturionArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, HeadJapaneseLightArmorModel::new, HeadJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST, ChestJapaneseLightArmorModel::new, ChestJapaneseLightArmorModel::createLayerDefinition, ChestJapaneseLightArmorModel::createSlimLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS, LegsJapaneseLightArmorModel::new, LegsJapaneseLightArmorModel::createLayerDefinition);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET, FeetJapaneseLightArmorModel::new, FeetJapaneseLightArmorModel::createLayerDefinition);
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