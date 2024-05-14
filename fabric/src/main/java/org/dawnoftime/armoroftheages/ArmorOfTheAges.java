package org.dawnoftime.armoroftheages;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class ArmorOfTheAges implements ModInitializer {
    private static final CreativeModeTab CREATIVE_MODE_TAB = FabricItemGroup.builder()
            .title(Component.translatable("itemGroup." + org.dawnoftime.armoroftheages.Constants.MOD_ID))
            // .icon(() -> new ItemStack(TAB_ICON)).displayItems((params, output) -> output
            // .acceptAll(ITEMS.stream().filter(holder -> holder != TAB_ICON).map(Item::getDefaultInstance).toList()))
            .build();

    @Override
    public void onInitialize() {
        org.dawnoftime.armoroftheages.Constants.LOG.info("Armor of the Ages is initializing...");
        // Items init
        ItemModRegistry.init();

        org.dawnoftime.armoroftheages.Constants.LOG.info("Armor of the Ages items initialized.");

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                new ResourceLocation(org.dawnoftime.armoroftheages.Constants.MOD_ID, org.dawnoftime.armoroftheages.Constants.MOD_ID),
                CREATIVE_MODE_TAB);
    }
}
