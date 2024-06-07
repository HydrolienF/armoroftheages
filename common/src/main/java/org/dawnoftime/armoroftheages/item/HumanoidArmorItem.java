package org.dawnoftime.armoroftheages.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.dawnoftime.armoroftheages.client.ArmorModelProvider;
import org.dawnoftime.armoroftheages.registry.ModelProviderRegistry;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

import static org.dawnoftime.armoroftheages.Constants.MOD_ID;

public class HumanoidArmorItem extends ArmorItem {
    protected final String armorSetName;
    public HumanoidArmorItem(String armorSetName, ArmorMaterial material, Type type) {
        super(material, type, new Properties().stacksTo(1));
        this.armorSetName = armorSetName;
    }

    public @NotNull ArmorModelProvider getModelProvider(){
        return ModelProviderRegistry.REGISTRY.get(this.armorSetName);
    }

    public @NotNull ResourceLocation getTexture(Entity entity) {
        return this.getModelProvider().getTexture(entity instanceof AbstractClientPlayer player && "slim".equals(player.getModelName()));
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltips, @NotNull TooltipFlag flagIn) {
        super.appendHoverText(stack, level, tooltips, flagIn);
        if(this.material.getRepairIngredient().getItems().length > 0){
            MutableComponent text = Component.translatable("tooltip." + MOD_ID + ".repair_with").withStyle(ChatFormatting.GRAY)
                    .append(this.material.getRepairIngredient().getItems()[0].getHoverName().plainCopy().withStyle(ChatFormatting.YELLOW));
            tooltips.add(text);
        }
    }
}
