package org.armoroftheages;

import net.minecraftforge.client.event.EntityRenderersEvent;
import org.armoroftheages.item.AotAItemsRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.armoroftheages.model.japanese_light_armor.JapaneseLightHelmetModel;

import static org.armoroftheages.ArmorOfTheAges.MOD_ID;
import static org.armoroftheages.model.AotAModelLayers.JAPANESE_LIGHT_HELMET;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HandlerCommon {

    public static CreativeModeTab DOT_TAB;
    public static boolean DOT_SELECTED = false;

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        DOT_TAB = event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "dot_tab"),
                builder -> builder.icon(() -> new ItemStack(AotAItemsRegistry.BAMBOO_HAT.get()))
                .title(Component.translatable("item_group." + MOD_ID + ".dottab")).withSearchBar().build());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(JAPANESE_LIGHT_HELMET, JapaneseLightHelmetModel::createMesh);
    }

    @SubscribeEvent
    public static void setDotTab(CreativeModeTabEvent.BuildContents event) {
        DOT_SELECTED = event.getTab() == DOT_TAB;
    }

    public static boolean isDotSelected() {
        return DOT_SELECTED;
    }
}
