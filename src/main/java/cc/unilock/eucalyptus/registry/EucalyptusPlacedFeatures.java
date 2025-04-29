package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;

import java.util.List;

public class EucalyptusPlacedFeatures {
	public static final RegistryKey<PlacedFeature> EUCALYPTUS = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Eucalyptus.id("eucalyptus_tree"));

	public static void init() {}

	public static void populate(FabricDynamicRegistryProvider.Entries entries) {
		entries.add(EUCALYPTUS, new PlacedFeature(
			entries.ref(EucalyptusConfiguredFeatures.EUCALYPTUS),
			List.of(PlacedFeatures.wouldSurvive(EucalyptusBlocks.EUCALYPTUS_SAPLING))
		));
	}
}
