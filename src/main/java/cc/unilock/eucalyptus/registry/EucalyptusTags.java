package cc.unilock.eucalyptus.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static cc.unilock.eucalyptus.Eucalyptus.id;

public class EucalyptusTags {
	public static class Blocks {
		public static final TagKey<Block> EUCALYPTUS_LOGS = TagKey.of(Registry.BLOCK_KEY, id("eucalyptus_logs"));
	}
	public static class Items {
		public static final TagKey<Item> EUCALYPTUS_LOGS = TagKey.of(Registry.ITEM_KEY, id("eucalyptus_logs"));
	}
}
