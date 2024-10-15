package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusTrunkPlacer;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.OptionalInt;

public class EucalyptusConfiguredFeatures {
	public static final RegistryKey<ConfiguredFeature<?, ?>> EUCALYPTUS = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Eucalyptus.id("eucalyptus_tree"));

	public static void init() {}

	public static void populate(FabricDynamicRegistryProvider.Entries entries) {
		entries.add(EUCALYPTUS, new ConfiguredFeature<>(
			Feature.TREE,
			new TreeFeatureConfig.Builder(
				BlockStateProvider.of(EucalyptusBlocks.EUCALYPTUS_LOG),
				new EucalyptusTrunkPlacer(4, 3, 3),
				BlockStateProvider.of(EucalyptusBlocks.EUCALYPTUS_LEAVES),
				new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), // TODO: copy(?) this into its own EucalyptusFoliagePlacer, for future proofing
				new TwoLayersFeatureSize(1, 0, 2, OptionalInt.of(6))
			).build()
		));
	}
}
