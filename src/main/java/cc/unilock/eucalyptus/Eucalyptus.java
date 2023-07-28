package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registery.EucalyptusBlocks;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eucalyptus implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Eucalyptus");
	public static final String MOD_ID = "eucalyptus";

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());
		EucalyptusBlocks.init();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
