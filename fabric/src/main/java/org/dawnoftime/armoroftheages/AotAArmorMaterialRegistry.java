package org.dawnoftime.armoroftheages;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class AotAArmorMaterialRegistry {
	public static final Holder<ArmorMaterial> IRON_PLATE = register(
			"iron_plate",
			3,
			9,
			7,
			3,
			9,
			6,
			0.0F,
			0.05F,
			SoundEvents.ARMOR_EQUIP_IRON,
			() -> Ingredient.of(Items.IRON_BLOCK.asItem()));
	public static final Holder<ArmorMaterial> HOLY = register(
			"holy",
			4,
			10,
			8,
			4,
			8,
			4,
			0.0F,
			0.0F,
			SoundEvents.ARMOR_EQUIP_DIAMOND,
			() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));
	public static final Holder<ArmorMaterial> JAPANESE_LIGHT = register(
			"japanese_light",
			2,
			7,
			6,
			2,
			7,
			10,
			0.0F,
			-0.03F,
			SoundEvents.ARMOR_EQUIP_LEATHER,
			() -> Ingredient.of(Items.LEATHER));

	public static final Holder<ArmorMaterial> O_YOROI = register(
			"o_yoroi",
			3,
			8,
			6,
			3,
			6,
			16,
			2.0F,
			0.0F,
			SoundEvents.ARMOR_EQUIP_IRON,
			() -> Ingredient.of(Items.REDSTONE_BLOCK.asItem()));

	public static final Holder<ArmorMaterial> RAIJIN = register(
			"raijin",
			3,
			9,
			7,
			3,
			7,
			26,
			2.0F,
			0.0F,
			SoundEvents.ARMOR_EQUIP_LEATHER,
			() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));

	public static final Holder<ArmorMaterial> PHARAOH = register(
			"pharaoh",
			3,
			8,
			6,
			3,
			6,
			37,
			2.0F,
			0.0F,
			SoundEvents.ARMOR_EQUIP_GOLD,
			() -> Ingredient.of(Items.GOLD_BLOCK.asItem()));

	public static final Holder<ArmorMaterial> ANUBIS = register(
			"anubis",
			3,
			8,
			6,
			3,
			6,
			52,
			3.0F,
			0.2F,
			SoundEvents.ARMOR_EQUIP_GOLD,
			() -> Ingredient.of(Blocks.LAPIS_BLOCK.asItem()));

	public static final Holder<ArmorMaterial> CENTURION = register(
			"centurion",
			3,
			7,
			5,
			3,
			5,
			10,
			3.0F,
			0.025F,
			SoundEvents.ARMOR_EQUIP_CHAIN,
			() -> Ingredient.of(Blocks.GOLD_BLOCK.asItem()));

	public static final Holder<ArmorMaterial> QUETZALCOATL = register(
			"quetzalcoatl",
			3,
			8,
			6,
			3,
			6,
			20,
			5.0F,
			0.04F,
			SoundEvents.ARMOR_EQUIP_TURTLE,
			() -> Ingredient.of(Items.FEATHER));

	/**
	 *
	 * Creates a new armor material with the specified properties.
	 * @param name The name of the armor material. This is used for identifying the material.
	 * @param helmetDef The defense value of the helmet piece of the armor.
	 * @param chestDef The defense value of the chestplate piece of the armor.
	 * @param legsDef The defense value of the leggings piece of the armor.
	 * @param feetDef The defense value of the boots piece of the armor.
	 * @param globalDef The defense value applied to any armor piece that doesn't fit the standard armor (i.e. horse or dog armor).
	 * @param enchantability The enchantability of the armor material, determining the quality of enchantments applied to this armor. Higher values indicate better enchantments.
	 * @param toughness The toughness provides additional protection against stronger attacks. Typically, only diamond and netherite have non-zero values.
	 * @param knockbackRes This determines the degree to which the player is immune to knockback while wearing the armor. Only netherite armor has values greater than 0.
	 * If the TOTAL value of each of the armor parts is 1 or greater, the player is immune to knockback.
	 * @param sound The sound event that is played when equipping the armor. This should be a Holder of a SoundEvent that represents the equipping sound.
	 * @param repairSupplier A supplier that provides the ingredient used to repair this armor material.
	 * @return A Holder containing the created ArmorMaterial.
	 */
	private static Holder<ArmorMaterial> register(String name, int helmetDef, int chestDef, int legsDef, int feetDef, int globalDef, int enchantability, float toughness, float knockbackRes, Holder<SoundEvent> sound, Supplier<Ingredient> repairSupplier){
		return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.fromNamespaceAndPath(MOD_ID, name), new ArmorMaterial(
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
				knockbackRes));
	}
}