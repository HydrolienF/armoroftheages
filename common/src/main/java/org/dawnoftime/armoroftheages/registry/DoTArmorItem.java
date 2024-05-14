package org.dawnoftime.armoroftheages.registry;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

public class DoTArmorItem extends ArmorItem {

    public DoTArmorItem(Holder<ArmorMaterial> armorMaterialHolder, Type type) {
        super(armorMaterialHolder, type, new Item.Properties().durability(200).stacksTo(1));
        // Properties should be in .json, but it's not working
    }

}
