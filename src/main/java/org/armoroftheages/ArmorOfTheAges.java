package org.armoroftheages;

import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.armoroftheages.item.AotAItemsRegistry;

import java.util.Map;

@Mod(ArmorOfTheAges.MOD_ID)
public class ArmorOfTheAges {
	public static final String MOD_ID = "armoroftheages";

	public ArmorOfTheAges() {
		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

		AotAItemsRegistry.register(eventBus);

		eventBus.addListener(HandlerCommon::commonSetup);
		// modEventBus.addListener(HandlerClient::clientSetup);

		eventBus.addListener(HandlerCommon::registerCreativeModeTabs);
		eventBus.addListener(HandlerCommon::setDotTab);
		// modEventBus.addListener(HandlerClient::entityRenderers);

		eventBus.addListener(this::createCreativeTab);
	}

	public void createCreativeTab(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == HandlerCommon.DOT_TAB) {
			ForgeRegistries.ITEMS.getEntries().stream().filter(
							entry -> entry
									.getKey()
									.location()
									.getNamespace()
									.equalsIgnoreCase(MOD_ID))
					.map(Map.Entry::getValue)
					.forEachOrdered(event::accept);
		}
	}
}