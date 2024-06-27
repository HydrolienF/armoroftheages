package org.dawnoftime.armoroftheages.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.function.Supplier;

public class ArmorMaterialRegistry {

    public static final Holder<ArmorMaterial> IRON_PLATE = createArmorMaterial(3, 9, 7, 3, 9,  6, 0.0F, 0.05F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.IRON_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> HOLY = createArmorMaterial(4,10, 8, 4,8,  4, 0.0F, 0.0F, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> JAPANESE_LIGHT = createArmorMaterial(2, 7, 6, 2, 7, 10, 0.0F, -0.03F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.LEATHER));
    public static final Holder<ArmorMaterial> O_YOROI = createArmorMaterial(3, 8, 6, 3, 6, 16, 2.0F, 0.0F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.REDSTONE_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> RAIJIN = createArmorMaterial(3, 9, 7, 3, 7, 26, 2.0F, 0.0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> PHARAOH = createArmorMaterial(3, 8, 6, 3, 6, 37, 2.0F, 0.0F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Items.GOLD_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> ANUBIS = createArmorMaterial(3, 8, 6, 3, 6, 52, 3.0F, 0.2F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Blocks.LAPIS_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> CENTURION = createArmorMaterial(3, 7, 5, 3, 5, 10, 3.0F, 0.025F, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));
    public static final Holder<ArmorMaterial> QUETZALCOATL = createArmorMaterial(3, 8, 6, 3, 6, 20, 5.0F, 0.04F, SoundEvents.ARMOR_EQUIP_TURTLE, () -> Ingredient.of(Items.FEATHER));

    private static Holder<ArmorMaterial> createArmorMaterial(int helmetDef, int chestDef, int legsDef, int feetDef, int globalDef, int enchantability, float toughness, float knockbackRes, Holder<SoundEvent> sound, Supplier<Ingredient> repairSupplier){
        return () -> new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, feetDef);
                    map.put(ArmorItem.Type.LEGGINGS, legsDef);
                    map.put(ArmorItem.Type.CHESTPLATE, chestDef);
                    map.put(ArmorItem.Type.HELMET, helmetDef);
                    map.put(ArmorItem.Type.BODY, globalDef);
                }),
                enchantability,
                sound,
                repairSupplier,
                new ArrayList<>(),
                toughness,
                knockbackRes);
    }
}
