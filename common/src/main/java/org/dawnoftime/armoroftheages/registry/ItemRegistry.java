package org.dawnoftime.armoroftheages.registry;

import net.minecraft.world.item.Item;
import org.dawnoftime.armoroftheages.item.AotAMaterials.DoTArmorMaterial;
import org.dawnoftime.armoroftheages.item.HatItem;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static net.minecraft.world.item.ArmorItem.Type.BOOTS;
import static org.dawnoftime.armoroftheages.Constants.ANUBIS_ARMOR_NAME;
import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;

public final class ItemRegistry {
    public static final Item TAB_ICON = new Item(new Item.Properties());
    public static final Item BAMBOO_HAT = new HatItem();
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_HEAD = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, HELMET);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_CHEST = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, CHESTPLATE);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_LEGS = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, LEGGINGS);
    public static final HumanoidArmorItem JAPANESE_LIGHT_ARMOR_FEET = new HumanoidArmorItem(JAPANESE_LIGHT_ARMOR_NAME, DoTArmorMaterial.JAPANESE_LIGHT, BOOTS);
    public static final HumanoidArmorItem ANUBIS_ARMOR_HEAD = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, HELMET);
    public static final HumanoidArmorItem ANUBIS_ARMOR_CHEST = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, CHESTPLATE);
    public static final HumanoidArmorItem ANUBIS_ARMOR_LEGS = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, LEGGINGS);
    public static final HumanoidArmorItem ANUBIS_ARMOR_FEET = new HumanoidArmorItem(ANUBIS_ARMOR_NAME, DoTArmorMaterial.ANUBIS, BOOTS);
}
