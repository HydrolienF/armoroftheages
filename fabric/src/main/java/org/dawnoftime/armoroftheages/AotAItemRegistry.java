package org.dawnoftime.armoroftheages;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.ArrayList;
import java.util.List;

import static org.dawnoftime.armoroftheages.Constants.*;
import static org.dawnoftime.armoroftheages.Constants.RAIJIN_ARMOR_NAME;

public class AotAItemRegistry {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static void init(){
        registerItem(MOD_ID, ItemRegistry.TAB_ICON);

        registerItem(BAMBOO_HAT_NAME, ItemRegistry.BAMBOO_HAT);

        registerItem(ANUBIS_ARMOR_NAME,         EquipmentSlot.HEAD,     ItemRegistry.ANUBIS_ARMOR_HEAD);
        registerItem(ANUBIS_ARMOR_NAME,         EquipmentSlot.CHEST,    ItemRegistry.ANUBIS_ARMOR_CHEST);
        registerItem(ANUBIS_ARMOR_NAME,         EquipmentSlot.LEGS,     ItemRegistry.ANUBIS_ARMOR_LEGS);
        registerItem(ANUBIS_ARMOR_NAME,         EquipmentSlot.FEET,     ItemRegistry.ANUBIS_ARMOR_FEET);
        registerItem(CENTURION_ARMOR_NAME,      EquipmentSlot.HEAD,     ItemRegistry.CENTURION_ARMOR_HEAD);
        registerItem(CENTURION_ARMOR_NAME,      EquipmentSlot.CHEST,    ItemRegistry.CENTURION_ARMOR_CHEST);
        registerItem(CENTURION_ARMOR_NAME,      EquipmentSlot.LEGS,     ItemRegistry.CENTURION_ARMOR_LEGS);
        registerItem(CENTURION_ARMOR_NAME,      EquipmentSlot.FEET,     ItemRegistry.CENTURION_ARMOR_FEET);
        registerItem(HOLY_ARMOR_NAME,           EquipmentSlot.HEAD,     ItemRegistry.HOLY_ARMOR_HEAD);
        registerItem(HOLY_ARMOR_NAME,           EquipmentSlot.CHEST,    ItemRegistry.HOLY_ARMOR_CHEST);
        registerItem(HOLY_ARMOR_NAME,           EquipmentSlot.LEGS,     ItemRegistry.HOLY_ARMOR_LEGS);
        registerItem(HOLY_ARMOR_NAME,           EquipmentSlot.FEET,     ItemRegistry.HOLY_ARMOR_FEET);
        registerItem(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.HEAD,     ItemRegistry.IRON_PLATE_ARMOR_HEAD);
        registerItem(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.CHEST,    ItemRegistry.IRON_PLATE_ARMOR_CHEST);
        registerItem(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.LEGS,     ItemRegistry.IRON_PLATE_ARMOR_LEGS);
        registerItem(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.FEET,     ItemRegistry.IRON_PLATE_ARMOR_FEET);
        registerItem(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD,     ItemRegistry.JAPANESE_LIGHT_ARMOR_HEAD);
        registerItem(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST,    ItemRegistry.JAPANESE_LIGHT_ARMOR_CHEST);
        registerItem(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS,     ItemRegistry.JAPANESE_LIGHT_ARMOR_LEGS);
        registerItem(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET,     ItemRegistry.JAPANESE_LIGHT_ARMOR_FEET);
        registerItem(O_YOROI_ARMOR_NAME,        EquipmentSlot.HEAD,     ItemRegistry.O_YOROI_ARMOR_HEAD);
        registerItem(O_YOROI_ARMOR_NAME,        EquipmentSlot.CHEST,    ItemRegistry.O_YOROI_ARMOR_CHEST);
        registerItem(O_YOROI_ARMOR_NAME,        EquipmentSlot.LEGS,     ItemRegistry.O_YOROI_ARMOR_LEGS);
        registerItem(O_YOROI_ARMOR_NAME,        EquipmentSlot.FEET,     ItemRegistry.O_YOROI_ARMOR_FEET);
        registerItem(PHARAOH_ARMOR_NAME,        EquipmentSlot.HEAD,     ItemRegistry.PHARAOH_ARMOR_HEAD);
        registerItem(PHARAOH_ARMOR_NAME,        EquipmentSlot.CHEST,    ItemRegistry.PHARAOH_ARMOR_CHEST);
        registerItem(PHARAOH_ARMOR_NAME,        EquipmentSlot.LEGS,     ItemRegistry.PHARAOH_ARMOR_LEGS);
        registerItem(PHARAOH_ARMOR_NAME,        EquipmentSlot.FEET,     ItemRegistry.PHARAOH_ARMOR_FEET);
        registerItem(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.HEAD,     ItemRegistry.QUETZALCOATL_ARMOR_HEAD);
        registerItem(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.CHEST,    ItemRegistry.QUETZALCOATL_ARMOR_CHEST);
        registerItem(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.LEGS,     ItemRegistry.QUETZALCOATL_ARMOR_LEGS);
        registerItem(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.FEET,     ItemRegistry.QUETZALCOATL_ARMOR_FEET);
        registerItem(RAIJIN_ARMOR_NAME,         EquipmentSlot.HEAD,     ItemRegistry.RAIJIN_ARMOR_HEAD);
        registerItem(RAIJIN_ARMOR_NAME,         EquipmentSlot.CHEST,    ItemRegistry.RAIJIN_ARMOR_CHEST);
        registerItem(RAIJIN_ARMOR_NAME,         EquipmentSlot.LEGS,     ItemRegistry.RAIJIN_ARMOR_LEGS);
        registerItem(RAIJIN_ARMOR_NAME,         EquipmentSlot.FEET,     ItemRegistry.RAIJIN_ARMOR_FEET);
    }

    public static void registerItem(String name, Item item){
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, name), item);
        ITEMS.add(item);
    }

    public static void registerItem(String armorSetName, EquipmentSlot slot, Item item){
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(MOD_ID, armorSetName + "_" + slot.getName()), item);
        ITEMS.add(item);
    }
}
