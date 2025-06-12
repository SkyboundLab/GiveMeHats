package gd.rf.acro.givemehats;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import gd.rf.acro.givemehats.GiveMeHats;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public class CustomHatItem extends TrinketItem implements TrinketRenderer {
    private final HatData data;

    public CustomHatItem(Settings settings, HatData data) {
        super(settings);
        this.data = data;
    }

    @Override
    public void render(ItemStack stack, SlotReference slotRef, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {

        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
        GiveMeHats.translateToFace(matrices, contextModel, entity, headYaw, headPitch);

        if (data.invertX) {
            matrices.scale(-data.scale, -data.scale, data.scale);
        } else {
            matrices.scale(data.scale, -data.scale, data.scale);
        }

        matrices.translate(data.translation[0], data.translation[1], data.translation[2]);

        renderer.renderItem(entity, stack, ModelTransformationMode.FIXED, false,
                matrices, vertexConsumers, entity.getWorld(), light, OverlayTexture.DEFAULT_UV, 0);
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable(data.display_name != null ? data.display_name : "item.givemehats." + data.name);
    }
}
