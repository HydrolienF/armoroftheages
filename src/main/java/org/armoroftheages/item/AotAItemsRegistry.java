package org.armoroftheages.item;

import java.util.function.Supplier;

import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.armoroftheages.AotAConfig;

import static org.armoroftheages.ArmorOfTheAges.MOD_ID;
import static org.armoroftheages.item.AotAMaterials.AotAArmorMaterial.JAPANESE_LIGHT;

public class AotAItemsRegistry {

	// Armor Set Names
	public static final String JAPANESE_LIGHT_NAME = "japanese_light_armor";
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
	public static final RegistryObject<Item> BAMBOO_HAT = AotAItemsRegistry.reg("bamboo_hat", HatItem::new);
	public static final RegistryObject<Item> JAPANESE_LIGHT_ARMOR_HEAD = AotAItemsRegistry.regArmor(JAPANESE_LIGHT_NAME, JAPANESE_LIGHT, Type.HELMET, () -> );
	//public static final ArmorSetRegistryObject ANUBIS_ARMOR_SET = new ArmorSetRegistryObject("anubis_armor", RAIJIN, () -> AnubisModel::new);
	//public static final ArmorSetRegistryObject CENTURION_ARMOR_SET = new ArmorSetRegistryObject("centurion_armor", CENTURION, () -> CenturionArmorModel::new);
	//public static final ArmorSetRegistryObject IRON_PLATE_ARMOR_SET = new ArmorSetRegistryObject("iron_plate_armor", IRON_PLATE, () -> IronPlateArmorModel::new);
	//public static final ArmorSetRegistryObject HOLY_ARMOR_SET = new ArmorSetRegistryObject("holy_armor", HOLY, () -> HolyArmorModel::new);
	//public static final ArmorSetRegistryObject PHARAOH_ARMOR_SET = new ArmorSetRegistryObject("pharaoh_armor", PHARAOH, () -> PharaohArmorModel::new);
	//public static final ArmorSetRegistryObject JAPANESE_LIGHT_ARMOR_SET = new ArmorSetRegistryObject(JAPANESE_LIGHT_NAME, JAPANESE_LIGHT, () -> JapaneseLightArmorModel::new);
	//public static final ArmorSetRegistryObject O_YOROI_ARMOR_SET = new ArmorSetRegistryObject("o_yoroi_armor", O_YOROI, () -> OYoroiArmorModel::new);
	//public static final ArmorSetRegistryObject QUETZALCOATL_ARMOR_SET = new ArmorSetRegistryObject("quetzalcoatl_armor", RAIJIN, () -> QuetzalcoatlModel::new);
	//public static final ArmorSetRegistryObject RAIJIN_ARMOR_SET = new ArmorSetRegistryObject("raijin_armor", RAIJIN, () -> RaijinArmorModel::new);

	private static <T extends Item>RegistryObject<HumanoidArmorItem> regArmor(final String setName, final ArmorMaterial material, final Type type, Supplier<HumanoidArmorItem.ArmorModelFactory> armorModelFactory) {
		// Create the HumanoidArmorItem
		HumanoidArmorItem humanoidArmorItem = new HumanoidArmorItem(setName, material, type) {
			/**
			 * Returns the armor model's factory. It needs to be associated
			 * with @OnlyIn(Dist.CLIENT) since BipedModel is Client Side only !
			 */
			@OnlyIn(Dist.CLIENT)
			@Override
			public ArmorModelFactory getModelFactory() {
				return armorModelFactory.get();
			}
		};
		// Add the item to the list of armors to sync
		AotAConfig.ARMORS_TO_SYNC.add(humanoidArmorItem);
		// Register and return a RegistryObject for the created item
		return AotAItemsRegistry.reg(setName + "_" + type.getName(), () -> humanoidArmorItem);

	}

	private static <T extends Item>RegistryObject<T> reg(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}

	public static void register (IEventBus eventBus) {
		ITEMS.register(eventBus);
}
