package org.dawnoftime.armoroftheages;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.dawnoftime.armoroftheages.item.ForgeHumanoidArmorItem;
import org.dawnoftime.armoroftheages.item.HatItem;

import java.util.function.Supplier;

import static net.minecraft.world.item.ArmorItem.Type.*;
import static org.dawnoftime.armoroftheages.Constants.JAPANESE_LIGHT_ARMOR_NAME;
import static org.dawnoftime.armoroftheages.item.AotAMaterials.DoTArmorMaterial;

public class AotAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final RegistryObject<Item> TAB_ICON = ITEMS.register(Constants.MOD_ID, () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_HAT = ITEMS.register(Constants.BAMBOO_HAT_NAME, HatItem::new);
    public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_HEAD = register(JAPANESE_LIGHT_ARMOR_NAME, HELMET, DoTArmorMaterial.JAPANESE_LIGHT);
    //public static final RegistryObject<Item> HOLY_DOG_ARMOR = ITEMS.register(HOLY_DOG_ARMOR_NAME, () -> ItemRegistry.HOLY_DOG_ARMOR);
    //public static final RegistryObject<Item> QUETZAL_DOG_ARMOR = ITEMS.register(QUETZAL_DOG_ARMOR_NAME, () -> ItemRegistry.QUETZAL_DOG_ARMOR);

    private static RegistryObject<Item> register(String armorSetName, ArmorItem.Type type, ArmorMaterial material){
        return ITEMS.register(armorSetName + "_" + type.getSlot().getName(), () -> new ForgeHumanoidArmorItem(armorSetName, material, type));
    }
}
