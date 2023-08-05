package cc.unilock.eucalyptus.world.tree.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.Holder;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

public class EucalyptusSaplingGenerator extends SaplingGenerator {
	@Nullable
	@Override
	protected Holder<? extends ConfiguredFeature<TreeFeatureConfig, ?>> getTreeFeature(RandomGenerator random, boolean bees) {
		return EucalyptusFeatures.EUCALYPTUS_TREE;
	}
}
