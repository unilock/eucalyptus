package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.*;
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

		EucalyptusBlockFamilies.init();
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
