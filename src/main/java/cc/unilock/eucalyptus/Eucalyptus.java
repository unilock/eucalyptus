package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusFeatures;
import cc.unilock.eucalyptus.registry.EucalyptusItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Eucalyptus implements ModInitializer {
	public static final String MOD_ID = "eucalyptus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		EucalyptusBlocks.init();
		EucalyptusItems.init();
		EucalyptusFeatures.init();
	}

	public static final ItemGroup EUCALYPTUS_ITEM_GROUP = FabricItemGroupBuilder.create(id("item_group"))
		.icon(() -> new ItemStack(EucalyptusItems.EUCALYPTUS_DOOR))
		.build();

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
