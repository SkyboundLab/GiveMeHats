package gd.rf.acro.givemehats;

import com.google.gson.Gson;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import gd.rf.acro.givemehats.CustomHatItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GiveMeHats implements ModInitializer {

    public static final ItemGroup TAB = FabricItemGroup.builder()
            .displayName(Text.of("Give Me Hats!"))
            .build();

    public static List<Item> LOADED_HATS;

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("givemehats", "tab"), TAB);
        LOADED_HATS = new ArrayList<>();
        registerJsonHats();
        System.out.println("May you find fine hats!");
    }

    private void registerJsonHats() {
        Path dir = Paths.get("config/givemehats/hats");
        if (!Files.exists(dir)) {
            System.err.println("Hat JSON folder missing: " + dir.toAbsolutePath());
            return;
        }

        Gson gson = new Gson();

        try (Stream<Path> stream = Files.walk(dir)) {
            stream.filter(p -> p.toString().endsWith(".json")).forEach(path -> {
                try {
                    String json = Files.readString(path);
                    HatData data = gson.fromJson(json, HatData.class);

                    Identifier id = new Identifier("givemehats", data.name);
                    Item item = new CustomHatItem(new Item.Settings(), data);

                    Registry.register(Registries.ITEM, id, item);
                    LOADED_HATS.add(item);

                    ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(TAB).get()).register(entries -> {
                        entries.add(item);
                    });
                    TrinketRendererRegistry.registerRenderer(item, (TrinketRenderer) item);

                    System.out.println("Registered hat from JSON: " + data.name);
                } catch (IOException e) {
                    System.err.println("Failed to load hat JSON: " + path);
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void translateToFace(MatrixStack matrices, EntityModel<? extends LivingEntity> model, LivingEntity entity, float headYaw, float headPitch) {
        if (entity.isInSwimmingPose() || entity.isFallFlying()) {
            if (model instanceof PlayerEntityModel<?> ctx) {
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(ctx.head.roll));
            }
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-45.0F));
        } else {
            if (entity.isInSneakingPose() && !model.riding) {
                matrices.translate(0.0F, 0.25F, 0.0F);
            }
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(headPitch));
        }
        matrices.translate(0.0F, -0.25F, -0.3F);
    }
}
