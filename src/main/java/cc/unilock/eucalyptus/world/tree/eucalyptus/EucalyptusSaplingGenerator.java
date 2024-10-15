package cc.unilock.eucalyptus.world.tree.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class EucalyptusSaplingGenerator extends SaplingGenerator {
	@Override
	protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
		return EucalyptusConfiguredFeatures.EUCALYPTUS;
	}
}
