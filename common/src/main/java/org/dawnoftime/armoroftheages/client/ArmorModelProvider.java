package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

// Client side
public class ArmorModelProvider {
    private final Supplier<LayerDefinition> layerDefinitionSupplier;
    private final ArmorModelSupplier armorModelSupplier;
    private final ModelLayerLocation modelLayerLocation;
    private final ResourceLocation resourceLocations;
    private final ResourceLocation slimResourceLocations;

    public ArmorModelProvider(String armorName, EquipmentSlot slot, Supplier<LayerDefinition> layerDefinitionSupplier, ArmorModelSupplier modelSupplier){
        this.layerDefinitionSupplier = layerDefinitionSupplier;
        this.armorModelSupplier = modelSupplier;
        this.modelLayerLocation = new ModelLayerLocation(new ResourceLocation("minecraft:player"), armorName + "_" + slot.name().toLowerCase());
        this.resourceLocations = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + ".png");
        this.slimResourceLocations = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_slim.png");
    }

    @NotNull
    public ResourceLocation getTexture(boolean isSlim) {
        return isSlim ? this.slimResourceLocations : this.resourceLocations;
    }

    @NotNull
    public ModelLayerLocation getLayerLocation() {
        return this.modelLayerLocation;
    }

    public LayerDefinition createLayer(){
        return this.layerDefinitionSupplier.get();
    }

    public ArmorModel<LivingEntity> createModel(){
        return this.armorModelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.modelLayerLocation));
    }
}