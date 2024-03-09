package org.armoroftheages.model;

import com.google.common.collect.Sets;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Set;
import java.util.stream.Stream;

import static org.armoroftheages.ArmorOfTheAges.MOD_ID;
import static org.armoroftheages.item.AotAItemsRegistry.JAPANESE_LIGHT_NAME;

@OnlyIn(Dist.CLIENT)
public class AotAModelLayers {
    private static final Set<ModelLayerLocation> ALL_MODELS = Sets.newHashSet();
    public static final ModelLayerLocation JAPANESE_LIGHT_HELMET = register(JAPANESE_LIGHT_NAME, Type.HELMET);

    private static ModelLayerLocation register(String armorSet, Type type) {
        ModelLayerLocation modellayerlocation = new ModelLayerLocation(new ResourceLocation(MOD_ID, armorSet + "/" + type.getName()), "main");
        if (!ALL_MODELS.add(modellayerlocation)) {
            throw new IllegalStateException("Duplicate registration for " + modellayerlocation);
        } else {
            return modellayerlocation;
        }
    }

    public static Stream<ModelLayerLocation> getKnownLocations() {
        return ALL_MODELS.stream();
    }
}
