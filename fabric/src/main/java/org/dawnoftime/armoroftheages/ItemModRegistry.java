package org.dawnoftime.armoroftheages;

import java.util.Map;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ItemModRegistry {
    private ItemModRegistry() {}

    public static void init() {
        for (Map.Entry<String, org.dawnoftime.armoroftheages.registry.DoTArmorItem> entry : org.dawnoftime.armoroftheages.registry.DoTAWItemsRegistry.REGISTRY
                .entrySet()) {
            registerItem(entry.getKey(), entry.getValue());
        }
    }

    public static void registerItem(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(org.dawnoftime.armoroftheages.Constants.MOD_ID, name), item);
        org.dawnoftime.armoroftheages.Constants.LOG.info("Registered item: " + name);
    }
}
