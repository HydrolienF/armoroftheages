package org.dawnoftime.armoroftheages.registry;

import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.AotAMaterials.DoTArmorMaterial;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static net.minecraft.world.item.ArmorItem.Type.BOOTS;
import static org.dawnoftime.armoroftheages.Constants.*;

public final class ItemRegistry {
    public static final Item TAB_ICON = new Item(new Item.Properties());
    public static final Item BAMBOO_HAT = new HatItem();
    public static final HumanoidArmorItem ANUBIS_ARMOR_HEAD = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, HELMET);
    public static final HumanoidArmorItem ANUBIS_ARMOR_CHEST = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, CHESTPLATE);
    public static final HumanoidArmorItem ANUBIS_ARMOR_LEGS = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, LEGGINGS);
    public static final HumanoidArmorItem ANUBIS_ARMOR_FEET = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, BOOTS);
    public static final HumanoidArmorItem CENTURION_ARMOR_HEAD = new HumanoidArmorItem(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, HELMET);
    public static final HumanoidArmorItem CENTURION_ARMOR_CHEST = new HumanoidArmorItem(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, CHESTPLATE);
    public static final HumanoidArmorItem CENTURION_ARMOR_LEGS = new HumanoidArmorItem(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, LEGGINGS);
    public static final HumanoidArmorItem CENTURION_ARMOR_FEET = new HumanoidArmorItem(CENTURION_ARMOR_NAME, DoTArmorMaterial.CENTURION, BOOTS);
    public static final HumanoidArmorItem HOLY_ARMOR_HEAD = new HumanoidArmorItem(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, HELMET);
    public static final HumanoidArmorItem HOLY_ARMOR_CHEST = new HumanoidArmorItem(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, CHESTPLATE);
    public static final HumanoidArmorItem HOLY_ARMOR_LEGS = new HumanoidArmorItem(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, LEGGINGS);
    public static final HumanoidArmorItem HOLY_ARMOR_FEET = new HumanoidArmorItem(HOLY_ARMOR_NAME, DoTArmorMaterial.HOLY, BOOTS);
    public static final HumanoidArmorItem IRON_PLATE_ARMOR_HEAD = new HumanoidArmorItem(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, HELMET);
    public static final HumanoidArmorItem IRON_PLATE_ARMOR_CHEST = new HumanoidArmorItem(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, CHESTPLATE);
    public static final HumanoidArmorItem IRON_PLATE_ARMOR_LEGS = new HumanoidArmorItem(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, LEGGINGS);
    public static final HumanoidArmorItem IRON_PLATE_ARMOR_FEET = new HumanoidArmorItem(IRON_PLATE_ARMOR_NAME, DoTArmorMaterial.IRON_PLATE, BOOTS);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_HEAD = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, HELMET);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_CHEST = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, CHESTPLATE);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_LEGS = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, LEGGINGS);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_FEET = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, BOOTS);
    public static final HumanoidArmorItem O_YOROI_ARMOR_HEAD = new HumanoidArmorItem(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, HELMET);
    public static final HumanoidArmorItem O_YOROI_ARMOR_CHEST = new HumanoidArmorItem(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, CHESTPLATE);
    public static final HumanoidArmorItem O_YOROI_ARMOR_LEGS = new HumanoidArmorItem(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, LEGGINGS);
    public static final HumanoidArmorItem O_YOROI_ARMOR_FEET = new HumanoidArmorItem(O_YOROI_ARMOR_NAME, DoTArmorMaterial.O_YOROI, BOOTS);
    public static final HumanoidArmorItem PHARAOH_ARMOR_HEAD = new HumanoidArmorItem(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, HELMET);
    public static final HumanoidArmorItem PHARAOH_ARMOR_CHEST = new HumanoidArmorItem(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, CHESTPLATE);
    public static final HumanoidArmorItem PHARAOH_ARMOR_LEGS = new HumanoidArmorItem(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, LEGGINGS);
    public static final HumanoidArmorItem PHARAOH_ARMOR_FEET = new HumanoidArmorItem(PHARAOH_ARMOR_NAME, DoTArmorMaterial.PHARAOH, BOOTS);
    public static final HumanoidArmorItem QUETZALCOATL_ARMOR_HEAD = new HumanoidArmorItem(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, HELMET);
    public static final HumanoidArmorItem QUETZALCOATL_ARMOR_CHEST = new HumanoidArmorItem(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, CHESTPLATE);
    public static final HumanoidArmorItem QUETZALCOATL_ARMOR_LEGS = new HumanoidArmorItem(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, LEGGINGS);
    public static final HumanoidArmorItem QUETZALCOATL_ARMOR_FEET = new HumanoidArmorItem(QUETZALCOATL_ARMOR_NAME, DoTArmorMaterial.QUETZALCOATL, BOOTS);
    public static final HumanoidArmorItem RAIJIN_ARMOR_HEAD = new HumanoidArmorItem(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, HELMET);
    public static final HumanoidArmorItem RAIJIN_ARMOR_CHEST = new HumanoidArmorItem(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, CHESTPLATE);
    public static final HumanoidArmorItem RAIJIN_ARMOR_LEGS = new HumanoidArmorItem(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, LEGGINGS);
    public static final HumanoidArmorItem RAIJIN_ARMOR_FEET = new HumanoidArmorItem(RAIJIN_ARMOR_NAME, DoTArmorMaterial.RAIJIN, BOOTS);
}
