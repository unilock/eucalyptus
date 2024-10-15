package cc.unilock.eucalyptus.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.gen.GenerationStep;

public class EucalyptusBiomeModifications {
	public static void register() {
		BiomeModifications.addFeature(
			//BiomeSelectors.isIn(TagKey.of(RegistryKeys.BIOME_KEY, Eucalyptus.id("valid_biomes"))),
			BiomeSelectors.tag(BiomeTags.IS_SAVANNA),
			GenerationStep.Feature.VEGETAL_DECORATION,
			EucalyptusPlacedFeatures.EUCALYPTUS
		);
	}
}
