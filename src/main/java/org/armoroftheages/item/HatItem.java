package org.armoroftheages.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class HatItem extends Item {

    public HatItem() {
        super(new Properties());
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }
}
