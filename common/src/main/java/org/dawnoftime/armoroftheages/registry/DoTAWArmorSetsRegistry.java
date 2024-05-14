// package org.dawnoftime.armoroftheages.registry;

// import java.util.ArrayList;
// import java.util.List;
// import org.dawnoftime.armoroftheages.set.ArmorSet;
// import org.dawnoftime.armoroftheages.set.CenturionArmorSet;
// import org.dawnoftime.armoroftheages.set.japanese_light_armor.JapaneseLightArmorSet;
// import net.minecraftforge.client.event.EntityRenderersEvent;

// public class DoTAWArmorSetsRegistry {

// public static List<ArmorSet> REGISTRY = new ArrayList<>();

// public static JapaneseLightArmorSet JAPANESE_LIGHT_ARMOR;
// public static CenturionArmorSet CENTURION_ARMOR;

// public static void register() {
// JAPANESE_LIGHT_ARMOR = register(new JapaneseLightArmorSet("japanese_light_armor"));
// CENTURION_ARMOR = register(new CenturionArmorSet("centurion_armor"));
// }

// public static <T extends ArmorSet> T register(T set) {
// REGISTRY.add(set);
// return set;
// }

// public static void onLayerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
// for (ArmorSet set : REGISTRY) {
// set.registerMesh(event);
// }
// }

// }
