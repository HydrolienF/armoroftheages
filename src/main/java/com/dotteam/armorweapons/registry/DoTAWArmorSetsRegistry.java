package com.dotteam.armorweapons.registry;

import com.dotteam.armorweapons.set.ArmorSet;
import com.dotteam.armorweapons.set.japanese_light_armor.JapaneseLightArmorSet;
import net.minecraftforge.client.event.EntityRenderersEvent;

import java.util.ArrayList;
import java.util.List;

public class DoTAWArmorSetsRegistry {

    public static List<ArmorSet> REGISTRY = new ArrayList<>();

    public static JapaneseLightArmorSet JAPANESE_LIGHT_ARMOR;

    public static void register() {
        JAPANESE_LIGHT_ARMOR = register(new JapaneseLightArmorSet("japanese_light_armor"));
    }

    public static <T extends ArmorSet> T register(T set) {
        REGISTRY.add(set);
        return set;
    }

    public static void onLayerRegister(EntityRenderersEvent.RegisterLayerDefinitions event) {
        for(ArmorSet set : REGISTRY) {
            set.registerMesh(event);
        }
    }

}
