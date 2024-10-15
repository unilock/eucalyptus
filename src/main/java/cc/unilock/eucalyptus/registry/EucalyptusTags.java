package cc.unilock.eucalyptus.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static cc.unilock.eucalyptus.Eucalyptus.id;

public class EucalyptusTags {
	public static class Blocks {
		public static final TagKey<Block> EUCALYPTUS_LOGS = TagKey.of(RegistryKeys.BLOCK, id("eucalyptus_logs"));
	}
	public static class Items {
		public static final TagKey<Item> EUCALYPTUS_LOGS = TagKey.of(RegistryKeys.ITEM, id("eucalyptus_logs"));
	}
}
