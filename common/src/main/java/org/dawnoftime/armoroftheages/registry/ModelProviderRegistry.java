package org.dawnoftime.armoroftheages.registry;

import java.util.HashMap;
import java.util.function.Supplier;

import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.client.ArmorModelSupplier;
import org.dawnoftime.armoroftheages.client.models.japanese_light_armor.HeadJapaneseLightArmorModel;

import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;

// Client side
public class ModelProviderRegistry {

    public static final HashMap<String, ArmorModelProvider> REGISTRY = new HashMap<>();
    static {
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, HeadJapaneseLightArmorModel::createLayerDefinition, HeadJapaneseLightArmorModel::new);
    }

    private static void register(String armorName, EquipmentSlot slot, Supplier<LayerDefinition> layerDefinition, ArmorModelSupplier dogArmorModelSupplier){
        ArmorModelProvider provider = new ArmorModelProvider(armorName, slot, layerDefinition, dogArmorModelSupplier);
        REGISTRY.put(armorName, provider);
    }
}