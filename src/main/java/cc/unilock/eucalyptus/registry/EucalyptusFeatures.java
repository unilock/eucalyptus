package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.mixin.accessor.TrunkPlacerTypeAccessor;
import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusTrunkPlacer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.OptionalInt;

public class EucalyptusFeatures {
	public static final TrunkPlacerType<EucalyptusTrunkPlacer> EUCALYPTUS_TRUNK_PLACER_TYPE = TrunkPlacerTypeAccessor.callRegister(Eucalyptus.id("eucalyptus_trunk_placer").toString(), EucalyptusTrunkPlacer.CODEC);
	public static final Identifier EUCALYPTUS_FEATURE_ID = Eucalyptus.id("eucalyptus_tree");

	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> EUCALYPTUS_CONFIGURED = ConfiguredFeatures.register(
		EUCALYPTUS_FEATURE_ID.toString(),
		Feature.TREE,
		new TreeFeatureConfig.Builder(
			BlockStateProvider.of(EucalyptusBlocks.EUCALYPTUS_LOG),
			new EucalyptusTrunkPlacer(4, 3, 3),
			BlockStateProvider.of(EucalyptusBlocks.EUCALYPTUS_LEAVES),
			new AcaciaFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0)), // TODO: copy(?) this into its own EucalyptusFoliagePlacer, for future proofing
			new TwoLayersFeatureSize(1, 0, 2, OptionalInt.of(6))
		).build()
	);

	public static final RegistryEntry<PlacedFeature> EUCALYPTUS_PLACED = PlacedFeatures.register(
		EUCALYPTUS_FEATURE_ID.toString(),
		EUCALYPTUS_CONFIGURED,
		List.of(
			PlacedFeatures.wouldSurvive(EucalyptusBlocks.EUCALYPTUS_SAPLING),
			// TODO: lower this from "count: 20" probably lol
			PlacedFeatures.createCountExtraModifier(20, 0.1F, 1),
			SquarePlacementModifier.of(),
			SurfaceWaterDepthFilterPlacementModifier.of(0),
			PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
			BiomePlacementModifier.of()
		)
	);

	public static void init() {
		BiomeModifications.addFeature(
			//BiomeSelectors.isIn(QuiltTagKey.of(Registry.BIOME_KEY, Eucalyptus.id("valid_biomes"), TagType.NORMAL)),
			BiomeSelectors.tag(BiomeTags.IS_SAVANNA),
			GenerationStep.Feature.VEGETAL_DECORATION,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, EUCALYPTUS_FEATURE_ID)
		);
	}
}
