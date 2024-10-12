package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.mixin.TrunkPlacerTypeInvoker;
import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusTrunkPlacer;
import net.minecraft.tag.BiomeTags;
import net.minecraft.util.Holder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.BiomePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.decorator.SurfaceWaterDepthFilterPlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.foliage.AcaciaFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import org.quiltmc.qsl.worldgen.biome.api.BiomeModifications;
import org.quiltmc.qsl.worldgen.biome.api.BiomeSelectors;

import java.util.List;
import java.util.OptionalInt;

public class EucalyptusFeatures {
	public static final TrunkPlacerType<EucalyptusTrunkPlacer> EUCALYPTUS_TRUNK_PLACER_TYPE = TrunkPlacerTypeInvoker.callRegister(Eucalyptus.id("eucalyptus_trunk_placer").toString(), EucalyptusTrunkPlacer.CODEC);
	public static final Identifier EUCALYPTUS_FEATURE_ID = Eucalyptus.id("eucalyptus_tree");

	public static final Holder<ConfiguredFeature<TreeFeatureConfig, ?>> EUCALYPTUS_CONFIGURED = ConfiguredFeatureUtil.register(
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

	public static final Holder<PlacedFeature> EUCALYPTUS_PLACED = PlacedFeatureUtil.register(
		EUCALYPTUS_FEATURE_ID.toString(),
		EUCALYPTUS_CONFIGURED,
		List.of(
			PlacedFeatureUtil.createWouldSurvivePlacementModifier(EucalyptusBlocks.EUCALYPTUS_SAPLING),
			// TODO: lower this from "count: 20" probably lol
			PlacedFeatureUtil.createCountExtraModifier(20, 0.1F, 1),
			InSquarePlacementModifier.getInstance(),
			SurfaceWaterDepthFilterPlacementModifier.create(0),
			PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP,
			BiomePlacementModifier.getInstance()
		)
	);

	public static void init() {
		BiomeModifications.addFeature(
			//BiomeSelectors.isIn(QuiltTagKey.of(Registry.BIOME_KEY, Eucalyptus.id("valid_biomes"), TagType.NORMAL)),
			BiomeSelectors.isIn(BiomeTags.IS_SAVANNA),
			GenerationStep.Feature.VEGETAL_DECORATION,
			RegistryKey.of(Registry.PLACED_FEATURE_KEY, EUCALYPTUS_FEATURE_ID)
		);
	}
}
