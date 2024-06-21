package org.dawnoftime.armoroftheages.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.dawnoftime.armoroftheages.client.models.ArmorModel;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

// Client side
public class ArmorModelProvider {
    private static final ResourceLocation PLAYER_RESOURCE_LOCATION = new ResourceLocation("minecraft:player");

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinitionSupplier){
        return new ArmorModelProvider(armorName, slot, modelSupplier, modelClass, layerDefinitionSupplier);
    }

    public static ArmorModelProvider create(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier){
        return new MixedArmorModelProvider(armorName, slot, modelSupplier, modelClass, layerDefinitionSupplier, slimLayerDefinitionSupplier);
    }

    private final Supplier<LayerDefinition> layerDefinitionSupplier;
    private final Class<? extends ArmorModel> modelClass;
    protected final ArmorModelSupplier armorModelSupplier;
    private final ModelLayerLocation modelLayerLocation;
    private final ResourceLocation resourceLocations;

    private ArmorModelProvider(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinitionSupplier){
        this.layerDefinitionSupplier = layerDefinitionSupplier;
        this.armorModelSupplier = modelSupplier;
        this.modelClass = modelClass;
        this.modelLayerLocation = new ModelLayerLocation(PLAYER_RESOURCE_LOCATION, armorName + "_" + slot.name().toLowerCase());
        this.resourceLocations = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + ".png");
    }

    @NotNull
    public ResourceLocation getTexture(Entity entity) {
        return this.resourceLocations;
    }

    @NotNull
    public ModelLayerLocation getLayerLocation() {
        return this.modelLayerLocation;
    }

    public LayerDefinition createLayer(){
        return this.layerDefinitionSupplier.get();
    }

    public <T extends LivingEntity> ArmorModel<T> createModel(T entity){
        return this.armorModelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.modelLayerLocation), false);
    }

    public Class<? extends ArmorModel> getModelClass(){
        return this.modelClass;
    }

    public static boolean isSlim(Entity entity){
        return entity instanceof AbstractClientPlayer player && "slim".equals(player.getModelName());
    }

    public static class MixedArmorModelProvider extends ArmorModelProvider{
        private final Supplier<LayerDefinition> slimLayerDefinitionSupplier;
        private final ModelLayerLocation slimModelLayerLocation;
        private final ResourceLocation slimResourceLocations;

        private MixedArmorModelProvider(String armorName, EquipmentSlot slot, ArmorModelSupplier modelSupplier, Class<? extends ArmorModel> modelClass, Supplier<LayerDefinition> layerDefinitionSupplier, Supplier<LayerDefinition> slimLayerDefinitionSupplier){
            super(armorName, slot, modelSupplier, modelClass, layerDefinitionSupplier);
            this.slimLayerDefinitionSupplier = slimLayerDefinitionSupplier;
            this.slimModelLayerLocation = new ModelLayerLocation(PLAYER_RESOURCE_LOCATION, armorName + "_" + slot.name().toLowerCase() + "_slim");
            this.slimResourceLocations = new ResourceLocation(MOD_ID, "textures/models/armor/" + armorName + "_slim.png");
        }

        @NotNull
        public ModelLayerLocation getSlimLayerLocation() {
            return this.slimModelLayerLocation;
        }

        public LayerDefinition createSlimLayer(){
            return this.slimLayerDefinitionSupplier.get();
        }

        @Override
        public <T extends LivingEntity> ArmorModel<T> createModel(T entity){
            return this.armorModelSupplier.create(Minecraft.getInstance().getEntityModels().bakeLayer(this.slimModelLayerLocation), isSlim(entity));
        }

        @Override
        public @NotNull ResourceLocation getTexture(Entity entity) {
            return isSlim(entity) ? this.slimResourceLocations : super.getTexture(entity);
        }
    }
}