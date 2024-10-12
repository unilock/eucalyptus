package cc.unilock.eucalyptus.world.tree.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

public class EucalyptusSaplingGenerator extends SaplingGenerator {
	@Nullable
	@Override
	protected RegistryEntry<? extends ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(Random random, boolean bees) {
		return EucalyptusFeatures.EUCALYPTUS_CONFIGURED;
	}
}
