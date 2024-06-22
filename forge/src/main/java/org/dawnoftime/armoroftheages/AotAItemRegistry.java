package org.dawnoftime.armoroftheages;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;
import org.dawnoftime.armoroftheages.registry.ItemRegistry;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.ANUBIS_ARMOR_NAME;
import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;

public class AotAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(Constants.MOD_ID, () -> ItemRegistry.TAB_ICON);
    public static final RegistryObject<Item> BAMBOO_HAT = ITEMS.register(Constants.BAMBOO_HAT_NAME, () -> ItemRegistry.BAMBOO_HAT);
    public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_HEAD = register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.HEAD, () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_HEAD);
    public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_CHEST = register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.CHEST, () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_CHEST);
    public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_LEGS = register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.LEGS, () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_LEGS);
    public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_FEET = register(JAPANESE_LIGHT_ARMOR_NAME, EquipmentSlot.FEET, () -> ItemRegistry.JAPANESE_LIGHT_ARMOR_FEET);
    public static final RegistryObject<Item> ANUBIS_ARMOR_HEAD = register(ANUBIS_ARMOR_NAME, EquipmentSlot.HEAD, () -> ItemRegistry.ANUBIS_ARMOR_HEAD);
    public static final RegistryObject<Item> ANUBIS_ARMOR_CHEST = register(ANUBIS_ARMOR_NAME, EquipmentSlot.CHEST, () -> ItemRegistry.ANUBIS_ARMOR_CHEST);
    public static final RegistryObject<Item> ANUBIS_ARMOR_LEGS = register(ANUBIS_ARMOR_NAME, EquipmentSlot.LEGS, () -> ItemRegistry.ANUBIS_ARMOR_LEGS);
    public static final RegistryObject<Item> ANUBIS_ARMOR_FEET = register(ANUBIS_ARMOR_NAME, EquipmentSlot.FEET, () -> ItemRegistry.ANUBIS_ARMOR_FEET);

    private static RegistryObject<Item> register(String armorSetName, EquipmentSlot slot, Supplier<HumanoidArmorItem> itemSupplier){
        return ITEMS.register(armorSetName + "_" + slot.getName(), itemSupplier);
    }
}
