package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusBiomeModifications;
import cc.unilock.eucalyptus.registry.EucalyptusBlockSetTypes;
import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusConfiguredFeatures;
import cc.unilock.eucalyptus.registry.EucalyptusItemGroups;
import cc.unilock.eucalyptus.registry.EucalyptusItems;
import cc.unilock.eucalyptus.registry.EucalyptusPlacedFeatures;
import cc.unilock.eucalyptus.registry.EucalyptusTrunkPlacerTypes;
import cc.unilock.eucalyptus.registry.EucalyptusWoodTypes;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eucalyptus implements ModInitializer {
	public static final String MOD_ID = "eucalyptus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		EucalyptusBlockSetTypes.init();
		EucalyptusWoodTypes.init();

		EucalyptusBlocks.init();
		EucalyptusItems.init();
		EucalyptusItemGroups.init();

		EucalyptusTrunkPlacerTypes.init();
		EucalyptusConfiguredFeatures.init();
		EucalyptusPlacedFeatures.init();

		EucalyptusBiomeModifications.register();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
