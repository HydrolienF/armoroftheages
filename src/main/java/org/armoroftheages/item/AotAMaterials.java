package org.armoroftheages.item;


import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.armoroftheages.AotAConfig;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public class AotAMaterials {

	private static final TagKey<Item> IRON_BLOCK_TAG = ItemTags.create(new ResourceLocation("forge:storage_blocks/iron"));
	private static final TagKey<Item> GOLD_BLOCK_TAG = ItemTags.create(new ResourceLocation("forge:storage_blocks/gold"));
	private static final TagKey<Item> LAPIS_BLOCK_TAG = ItemTags.create(new ResourceLocation("forge:storage_blocks/lapis"));
	private static final TagKey<Item> REDSTONE_BLOCK_TAG = ItemTags.create(new ResourceLocation("forge:storage_blocks/redstone"));
	private static final TagKey<Item> LEATHER_TAG = ItemTags.create(new ResourceLocation("forge:leather"));
	private static final TagKey<Item> FEATHERS_TAG = ItemTags.create(new ResourceLocation("forge:feathers"));

	public enum AotAArmorMaterial implements ArmorMaterial {
		IRON_PLATE("iron_plate", AotAConfig.IRON_PLATE_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_IRON, IRON_BLOCK_TAG),
		HOLY("holy", AotAConfig.HOLY_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_DIAMOND, GOLD_BLOCK_TAG),
		JAPANESE_LIGHT("japanese_light", AotAConfig.JAPANESE_LIGHT_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_LEATHER, LEATHER_TAG),
		O_YOROI("o_yoroi", AotAConfig.O_YOROI_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_IRON, REDSTONE_BLOCK_TAG),
		RAIJIN("raijin", AotAConfig.RAIJIN_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_LEATHER, GOLD_BLOCK_TAG),
		PHARAOH("pharaoh", AotAConfig.PHARAOH_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_GOLD, GOLD_BLOCK_TAG),
		ANUBIS("anubis", AotAConfig.ANUBIS_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_GOLD, LAPIS_BLOCK_TAG),
		CENTURION("centurion", AotAConfig.CENTURION_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_CHAIN, GOLD_BLOCK_TAG),
		QUETZALCOATL("quetzalcoatl", AotAConfig.QUETZALCOATL_ARMOR_CONFIG, SoundEvents.ARMOR_EQUIP_TURTLE, FEATHERS_TAG);
		private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (mapDurability) -> {
			mapDurability.put(ArmorItem.Type.BOOTS, 13);
			mapDurability.put(ArmorItem.Type.LEGGINGS, 15);
			mapDurability.put(ArmorItem.Type.CHESTPLATE, 16);
			mapDurability.put(ArmorItem.Type.HELMET, 11);
		});
		private final String name;
		private final AotAConfig.ArmorConfig armorConfig;
		private final SoundEvent soundEvent;
		private final Supplier<Ingredient> repairMaterial;

		/**
		 * @param nameIn                   Material name.
		 * @param config			       Armor config that contains all the parameters of the armor
		 *                                    (durability, armor, enchantability, toughness)
		 * @param equipSoundIn             Sound when equipped.
		 * @param repairTag   Ingredient used to repair the armor.
		 */
		AotAArmorMaterial(final String nameIn, AotAConfig.ArmorConfig config, final SoundEvent equipSoundIn, final TagKey<Item> repairTag) {
			this.name = nameIn;
			this.armorConfig = config;
			this.soundEvent = equipSoundIn;
			this.repairMaterial = () -> Ingredient.of(repairTag);
		}

		@Override
		public int getDefenseForType(ArmorItem.Type type) {
            return switch (type) {
                case BOOTS -> this.armorConfig.feetDefSupplier().get();
                case LEGGINGS -> this.armorConfig.legsDefSupplier().get();
                case CHESTPLATE -> this.armorConfig.chestDefSupplier().get();
                case HELMET -> this.armorConfig.helmetDefSupplier().get();
            };
		}

		@Override
		public int getDurabilityForType(ArmorItem.@NotNull Type type) {
			return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.armorConfig.durabilitySupplier().get();
		}

		@Override
		public int getEnchantmentValue() {
			return this.armorConfig.enchantabilitySupplier().get();
		}

		@Override
		public @NotNull SoundEvent getEquipSound() {
			return this.soundEvent;
		}

		@Override
		public @NotNull Ingredient getRepairIngredient() {
			return this.repairMaterial.get();
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public @NotNull String getName() {
			return this.name;
		}

		@Override
		public float getToughness() {
			return this.armorConfig.toughnessSupplier().get();
		}

		@Override
		public float getKnockbackResistance() {
			return 0;
		}
	}

	/*
	 * I keep this here in case we want to add some tools public enum ItemMaterial
	 * implements IItemTier { WOOD(0, 59, 2.0F, 0.0F, 15, () -> { return
	 * Ingredient.fromTag(ItemTags.PLANKS); }), STONE(1, 131, 4.0F, 1.0F, 5, () -> {
	 * return Ingredient.of(Blocks.COBBLESTONE); }), IRON(2, 250, 6.0F, 2.0F, 14, ()
	 * -> { return Ingredient.of(Items.IRON_INGOT); }), DIAMOND(3, 1561, 8.0F, 3.0F,
	 * 10, () -> { return Ingredient.of(Items.DIAMOND); }), GOLD(0, 32, 12.0F, 0.0F,
	 * 22, () -> { return Ingredient.of(Items.GOLD_INGOT); });
	 *
	 * private final int harvestLevel; private final int maxUses; private final
	 * float efficiency; private final float attackDamage; private final int
	 * enchantability; private final LazyLoadBase<Ingredient> repairMaterial;
	 *
	 * ItemMaterial(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float
	 * attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
	 * { this.harvestLevel = harvestLevelIn; this.maxUses = maxUsesIn;
	 * this.efficiency = efficiencyIn; this.attackDamage = attackDamageIn;
	 * this.enchantability = enchantabilityIn; this.repairMaterial = new
	 * LazyLoadBase<>(repairMaterialIn); }
	 *
	 * public int getMaxUses() { return this.maxUses; }
	 *
	 * public float getEfficiency() { return this.efficiency; }
	 *
	 * public float getAttackDamage() { return this.attackDamage; }
	 *
	 * public int getHarvestLevel() { return this.harvestLevel; }
	 *
	 * public int getEnchantability() { return this.enchantability; }
	 *
	 * public Ingredient getRepairMaterial() { return
	 * this.repairMaterial.getValue(); } }
	 *
	 */
}