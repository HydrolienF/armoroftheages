package org.dawnoftime.armoroftheages.registry;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import org.dawnoftime.armoroftheages.item.AotAMaterials;
import org.dawnoftime.armoroftheages.item.HumanoidArmorItem;

import java.util.EnumMap;

import static net.minecraft.world.item.ArmorItem.Type.HELMET;
import static org.dawnoftime.armoroftheages.Constants.ANUBIS_ARMOR_NAME;

public class ArmorMaterialRegistry {

    public static final ArmorMaterial IRON_PLATE = new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
            // Gold uses 25, we put copper slightly below that.
            20,
            // Determines the sound played when equipping this armor.
            // This is wrapped with a Holder.
            SoundEvents.ARMOR_EQUIP_GENERIC,
            // Determines the repair item for this armor.
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
            // Determines the texture locations of the armor to apply when rendering
            // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
            List.of(
                    // Creates a new armor texture that will be located at:
                    // - 'assets/mod_id/textures/models/armor/copper_layer_1.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/copper_layer_2.png' for the inner texture (only legs)
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(MOD_ID, "copper")
                    ),
                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/copper_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/copper_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(MOD_ID, "copper"), "_overlay", true
                    )
            ),
            // Returns the toughness value of the armor. The toughness value is an additional value included in
            // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
            // https://minecraft.wiki/w/Armor#Armor_toughness
            // Only diamond and netherite have values greater than 0 here, so we just return 0.
            0,
            // Returns the knockback resistance value of the armor. While wearing this armor, the player is
            // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
            // from all armor pieces combined, they will not take any knockback at all.
            // Only netherite has values greater than 0 here, so we just return 0.
            0
    ));

    IRON_PLATE("iron_plate",				25, 3, 9, 7, 3,  6, 0.0F,SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.IRON_BLOCK.asItem())),
    HOLY("holy",							40, 4,10, 8, 4,  4, 2.0F, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
    JAPANESE_LIGHT("japanese_light",		12, 2, 7, 6, 2, 10, 0.0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Items.LEATHER)),
    O_YOROI("o_yoroi",					20, 3, 8, 6, 3, 16, 2.0F, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(Items.REDSTONE_BLOCK.asItem())),
    RAIJIN("raijin",						35, 3, 9, 7, 3, 26, 2.0F, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
    PHARAOH("pharaoh",					10, 3, 8, 6, 3, 37, 2.0F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Items.GOLD_BLOCK.asItem())),
    ANUBIS("anubis",						25, 3, 8, 6, 3, 52, 3.0F, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(Blocks.LAPIS_BLOCK.asItem())),
    CENTURION("centurion",				22, 3, 7, 5, 3, 10, 3.0F, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(Blocks.GOLD_BLOCK.asItem())),
    QUETZALCOATL("quetzalcoatl",			25, 2, 6, 5, 2, 20, 6.0F, SoundEvents.ARMOR_EQUIP_TURTLE, () -> Ingredient.of(Items.FEATHER));

    private static ArmorMaterial createArmorMaterial(){
        return new ArmorMaterial(
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 2);
                    map.put(ArmorItem.Type.LEGGINGS, 4);
                    map.put(ArmorItem.Type.CHESTPLATE, 6);
                    map.put(ArmorItem.Type.HELMET, 2);
                    map.put(ArmorItem.Type.BODY, 4);
                }),
                // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                // Gold uses 25, we put copper slightly below that.
                20,
                // Determines the sound played when equipping this armor.
                // This is wrapped with a Holder.
                SoundEvents.ARMOR_EQUIP_GENERIC,
                // Determines the repair item for this armor.
                () -> Ingredient.of(Tags.Items.INGOTS_COPPER),
                // Determines the texture locations of the armor to apply when rendering
                // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                List.of(
                        // Creates a new armor texture that will be located at:
                        // - 'assets/mod_id/textures/models/armor/copper_layer_1.png' for the outer texture
                        // - 'assets/mod_id/textures/models/armor/copper_layer_2.png' for the inner texture (only legs)
                        new ArmorMaterial.Layer(
                                ResourceLocation.fromNamespaceAndPath(MOD_ID, "copper")
                        ),
                        // Creates a new armor texture that will be rendered on top of the previous at:
                        // - 'assets/mod_id/textures/models/armor/copper_layer_1_overlay.png' for the outer texture
                        // - 'assets/mod_id/textures/models/armor/copper_layer_2_overlay.png' for the inner texture (only legs)
                        // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                        new ArmorMaterial.Layer(
                                ResourceLocation.fromNamespaceAndPath(MOD_ID, "copper"), "_overlay", true
                        )
                ),
                // Returns the toughness value of the armor. The toughness value is an additional value included in
                // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
                // https://minecraft.wiki/w/Armor#Armor_toughness
                // Only diamond and netherite have values greater than 0 here, so we just return 0.
                0,
                // Returns the knockback resistance value of the armor. While wearing this armor, the player is
                // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
                // from all armor pieces combined, they will not take any knockback at all.
                // Only netherite has values greater than 0 here, so we just return 0.
                0
        ));
    }
}
