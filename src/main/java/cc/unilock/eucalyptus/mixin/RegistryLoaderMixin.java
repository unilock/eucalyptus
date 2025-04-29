package cc.unilock.eucalyptus.mixin;

import cc.unilock.eucalyptus.Eucalyptus;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryLoader;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// Make it data-driven, they said.
// It would be fun, they said.

@Mixin(RegistryLoader.class)
public class RegistryLoaderMixin {
	@Inject(
		method = "load(Lnet/minecraft/registry/RegistryOps$RegistryInfoGetter;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/registry/MutableRegistry;Lcom/mojang/serialization/Decoder;Ljava/util/Map;)V",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/serialization/Decoder;parse(Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Lcom/mojang/serialization/DataResult;",
			remap = false
		)
	)
	private static void load$preParse(CallbackInfo ci, @Local(ordinal = 1) RegistryKey<?> registryKey, @Local JsonElement jsonElement) {
		if (VegetationConfiguredFeatures.TREES_SAVANNA.equals(registryKey)) {
			try {
				JsonArray features = jsonElement.getAsJsonObject().getAsJsonObject("config").getAsJsonArray("features");
				for (JsonElement feature : features) {
					if ("eucalyptus:eucalyptus_tree".equals(feature.getAsJsonObject().get("feature").getAsString())) return;
				}
				JsonObject eucalyptus = new JsonObject();
				eucalyptus.addProperty("chance", 0.1);
				eucalyptus.addProperty("feature", "eucalyptus:eucalyptus_tree");
				features.add(eucalyptus);
			} catch (Exception e) {
				Eucalyptus.LOGGER.error("Failed to add eucalyptus_tree feature to trees_savanna config!", e);
			}
		}
	}
}
