package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.registry.Registry;

public class EucalyptusItems {
	public static final Item EUCALYPTUS_DOOR = registerItem("eucalyptus_door", new TallBlockItem(EucalyptusBlocks.EUCALYPTUS_DOOR, new FabricItemSettings().group(Eucalyptus.EUCALYPTUS_ITEM_GROUP)));
	public static final Item EUCALYPTUS_SIGN = registerItem("eucalyptus_sign", new SignItem(new FabricItemSettings().maxCount(16).group(Eucalyptus.EUCALYPTUS_ITEM_GROUP), EucalyptusBlocks.EUCALYPTUS_SIGN, EucalyptusBlocks.EUCALYPTUS_WALL_SIGN));

	private static Item registerItem(String path, Item item) {
		return Registry.register(Registry.ITEM, Eucalyptus.id(path), item);
	}

	public static void init() {}
}
