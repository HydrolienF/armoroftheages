package org.dawnoftime.armoroftheages;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(Constants.MOD_ID, () -> ItemRegistry.TAB_ICON);
    static{
        ITEMS.register(Constants.BAMBOO_HAT_NAME, () -> ItemRegistry.BAMBOO_HAT);
        register(ANUBIS_ARMOR_NAME,         EquipmentSlot.HEAD,     () -> ItemRegistry.ANUBIS_ARMOR_HEAD);
        register(ANUBIS_ARMOR_NAME,         EquipmentSlot.CHEST,    () -> ItemRegistry.ANUBIS_ARMOR_CHEST);
        register(ANUBIS_ARMOR_NAME,         EquipmentSlot.LEGS,     () -> ItemRegistry.ANUBIS_ARMOR_LEGS);
        register(ANUBIS_ARMOR_NAME,         EquipmentSlot.FEET,     () -> ItemRegistry.ANUBIS_ARMOR_FEET);
        register(CENTURION_ARMOR_NAME,      EquipmentSlot.HEAD,     () -> ItemRegistry.CENTURION_ARMOR_HEAD);
        register(CENTURION_ARMOR_NAME,      EquipmentSlot.CHEST,    () -> ItemRegistry.CENTURION_ARMOR_CHEST);
        register(CENTURION_ARMOR_NAME,      EquipmentSlot.LEGS,     () -> ItemRegistry.CENTURION_ARMOR_LEGS);
        register(CENTURION_ARMOR_NAME,      EquipmentSlot.FEET,     () -> ItemRegistry.CENTURION_ARMOR_FEET);
        register(HOLY_ARMOR_NAME,           EquipmentSlot.HEAD,     () -> ItemRegistry.HOLY_ARMOR_HEAD);
        register(HOLY_ARMOR_NAME,           EquipmentSlot.CHEST,    () -> ItemRegistry.HOLY_ARMOR_CHEST);
        register(HOLY_ARMOR_NAME,           EquipmentSlot.LEGS,     () -> ItemRegistry.HOLY_ARMOR_LEGS);
        register(HOLY_ARMOR_NAME,           EquipmentSlot.FEET,     () -> ItemRegistry.HOLY_ARMOR_FEET);
        register(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.HEAD,     () -> ItemRegistry.IRON_PLATE_ARMOR_HEAD);
        register(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.CHEST,    () -> ItemRegistry.IRON_PLATE_ARMOR_CHEST);
        register(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.LEGS,     () -> ItemRegistry.IRON_PLATE_ARMOR_LEGS);
        register(IRON_PLATE_ARMOR_NAME,     EquipmentSlot.FEET,     () -> ItemRegistry.IRON_PLATE_ARMOR_FEET);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD,     () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_HEAD);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST,    () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_CHEST);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS,     () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_LEGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET,     () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_FEET);
        register(O_YOROI_ARMOR_NAME,        EquipmentSlot.HEAD,     () -> ItemRegistry.O_YOROI_ARMOR_HEAD);
        register(O_YOROI_ARMOR_NAME,        EquipmentSlot.CHEST,    () -> ItemRegistry.O_YOROI_ARMOR_CHEST);
        register(O_YOROI_ARMOR_NAME,        EquipmentSlot.LEGS,     () -> ItemRegistry.O_YOROI_ARMOR_LEGS);
        register(O_YOROI_ARMOR_NAME,        EquipmentSlot.FEET,     () -> ItemRegistry.O_YOROI_ARMOR_FEET);
        register(PHARAOH_ARMOR_NAME,        EquipmentSlot.HEAD,     () -> ItemRegistry.PHARAOH_ARMOR_HEAD);
        register(PHARAOH_ARMOR_NAME,        EquipmentSlot.CHEST,    () -> ItemRegistry.PHARAOH_ARMOR_CHEST);
        register(PHARAOH_ARMOR_NAME,        EquipmentSlot.LEGS,     () -> ItemRegistry.PHARAOH_ARMOR_LEGS);
        register(PHARAOH_ARMOR_NAME,        EquipmentSlot.FEET,     () -> ItemRegistry.PHARAOH_ARMOR_FEET);
        register(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.HEAD,     () -> ItemRegistry.QUETZALCOATL_ARMOR_HEAD);
        register(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.CHEST,    () -> ItemRegistry.QUETZALCOATL_ARMOR_CHEST);
        register(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.LEGS,     () -> ItemRegistry.QUETZALCOATL_ARMOR_LEGS);
        register(QUETZALCOATL_ARMOR_NAME,   EquipmentSlot.FEET,     () -> ItemRegistry.QUETZALCOATL_ARMOR_FEET);
        register(RAIJIN_ARMOR_NAME,         EquipmentSlot.HEAD,     () -> ItemRegistry.RAIJIN_ARMOR_HEAD);
        register(RAIJIN_ARMOR_NAME,         EquipmentSlot.CHEST,    () -> ItemRegistry.RAIJIN_ARMOR_CHEST);
        register(RAIJIN_ARMOR_NAME,         EquipmentSlot.LEGS,     () -> ItemRegistry.RAIJIN_ARMOR_LEGS);
        register(RAIJIN_ARMOR_NAME,         EquipmentSlot.FEET,     () -> ItemRegistry.RAIJIN_ARMOR_FEET);
    }

    private static void register(String armorSetName, EquipmentSlot slot, Supplier<HumanoidArmorItem> itemSupplier){
        ITEMS.register(armorSetName + "_" + slot.getName(), itemSupplier);
    }
}
