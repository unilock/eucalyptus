package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusFeatures;
import cc.unilock.eucalyptus.registry.EucalyptusItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.item.group.api.QuiltItemGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eucalyptus implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Eucalyptus");
	public static final String MOD_ID = "eucalyptus";

	@Override
	public void onInitialize(ModContainer mod) {
		EucalyptusBlocks.init();
		EucalyptusItems.init();
		EucalyptusFeatures.init();
	}

	public static final QuiltItemGroup EUCALYPTUS_ITEM_GROUP = QuiltItemGroup.builder(id("item_group"))
		.icon(() -> new ItemStack(EucalyptusItems.EUCALYPTUS_DOOR))
		.build();

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
