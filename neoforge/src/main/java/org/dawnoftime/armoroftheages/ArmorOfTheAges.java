package org.dawnoftime.armoroftheages;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;

import static org.dawnoftime.armoroftheages.AotAArmorMaterialRegistry.ARMOR_MATERIALS;
import static org.dawnoftime.armoroftheages.Constants.MOD_ID;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.ITEMS;
import static org.dawnoftime.armoroftheages.AotAItemRegistry.TAB_ICON;

@Mod(MOD_ID)
public class ArmorOfTheAges {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public ArmorOfTheAges(IEventBus modEventBus, ModContainer modContainer) {
        // Materials init
        ARMOR_MATERIALS.register(modEventBus);

        // Items init
        ITEMS.register(modEventBus);

        // Creative inventory init
        CREATIVE_MODE_TAB.register(modEventBus);
        CREATIVE_MODE_TAB.register(MOD_ID, () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup." + MOD_ID))
                .icon(() -> TAB_ICON.get().getDefaultInstance())
                .displayItems((params, output) -> output.acceptAll(ITEMS.getEntries().stream().filter(holder -> holder != TAB_ICON).map((itemDeferredHolder) -> itemDeferredHolder.get().getDefaultInstance()).toList()))
                .build());

        // Client init
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(ArmorOfTheAges::registerLayerDefinitions);
        }

        CommonClass.init();
    }

    /**
     * Registers the LayerDefinitions. Must be client side only !
     * @param event Event called.
     */
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
        ModelProviderRegistry.REGISTRY.forEach((name, provider) -> {
            event.registerLayerDefinition(provider.getLayerLocation(), provider::createLayer);
            if(provider instanceof ArmorModelProvider.MixedArmorModelProvider slimProvide){
                event.registerLayerDefinition(slimProvide.getSlimLayerLocation(), slimProvide::createSlimLayer);
            }
        });
    }
}