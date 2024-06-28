package org.dawnoftime.armoroftheages;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.item.HatItem;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static org.dawnoftime.armoroftheages.AotAArmorMaterialRegistry.*;
import static org.dawnoftime.armoroftheages.Constants.*;

public class AotAItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MOD_ID);
    public static final DeferredItem<Item> TAB_ICON = ITEMS.register(MOD_ID, () -> new Item(new Item.Properties()));

    // Item registry
    static{
        ITEMS.register(BAMBOO_HAT_NAME, HatItem::new);
        register(ANUBIS_ARMOR_NAME, ANUBIS, HELMET);
        register(ANUBIS_ARMOR_NAME, ANUBIS, CHESTPLATE);
        register(ANUBIS_ARMOR_NAME, ANUBIS, LEGGINGS);
        register(ANUBIS_ARMOR_NAME, ANUBIS, BOOTS);
        register(CENTURION_ARMOR_NAME, CENTURION, HELMET);
        register(CENTURION_ARMOR_NAME, CENTURION, CHESTPLATE);
        register(CENTURION_ARMOR_NAME, CENTURION, LEGGINGS);
        register(CENTURION_ARMOR_NAME, CENTURION, BOOTS);
        register(HOLY_ARMOR_NAME, HOLY, HELMET);
        register(HOLY_ARMOR_NAME, HOLY, CHESTPLATE);
        register(HOLY_ARMOR_NAME, HOLY, LEGGINGS);
        register(HOLY_ARMOR_NAME, HOLY, BOOTS);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, HELMET);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, CHESTPLATE);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, LEGGINGS);
        register(IRON_PLATE_ARMOR_NAME, IRON_PLATE, BOOTS);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, HELMET);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, CHESTPLATE);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, LEGGINGS);
        register(JAPANESE_LIGHT_ARMOR_NAME, JAPANESE_LIGHT, BOOTS);
        register(O_YOROI_ARMOR_NAME, O_YOROI, HELMET);
        register(O_YOROI_ARMOR_NAME, O_YOROI, CHESTPLATE);
        register(O_YOROI_ARMOR_NAME, O_YOROI, LEGGINGS);
        register(O_YOROI_ARMOR_NAME, O_YOROI, BOOTS);
        register(PHARAOH_ARMOR_NAME, PHARAOH, HELMET);
        register(PHARAOH_ARMOR_NAME, PHARAOH, CHESTPLATE);
        register(PHARAOH_ARMOR_NAME, PHARAOH, LEGGINGS);
        register(PHARAOH_ARMOR_NAME, PHARAOH, BOOTS);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, HELMET);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, CHESTPLATE);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, LEGGINGS);
        register(QUETZALCOATL_ARMOR_NAME, QUETZALCOATL, BOOTS);
        register(RAIJIN_ARMOR_NAME, RAIJIN, HELMET);
        register(RAIJIN_ARMOR_NAME, RAIJIN, CHESTPLATE);
        register(RAIJIN_ARMOR_NAME, RAIJIN, LEGGINGS);
        register(RAIJIN_ARMOR_NAME, RAIJIN, BOOTS);
    }

    private static void register(String armorSetName, Holder<ArmorMaterial> material, ArmorItem.Type slot){
        ITEMS.register(armorSetName + "_" + slot.getSlot().getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, slot));
    }
}
