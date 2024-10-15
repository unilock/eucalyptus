package cc.unilock.eucalyptus.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;

import static cc.unilock.eucalyptus.Eucalyptus.id;

public class EucalyptusItemGroups {
	public static final ItemGroup MAIN = Registry.register(
		Registries.ITEM_GROUP,
		id("main"),
		FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.eucalyptus.main"))
			.icon(EucalyptusItems.EUCALYPTUS_DOOR::getDefaultStack)
			.entries((displayContext, entries) -> {
				entries.add(EucalyptusBlocks.EUCALYPTUS_SAPLING);
				entries.add(EucalyptusBlocks.EUCALYPTUS_LEAVES);
				entries.add(EucalyptusBlocks.EUCALYPTUS_PLANKS);
				entries.add(EucalyptusBlocks.EUCALYPTUS_LOG);
				entries.add(EucalyptusBlocks.EUCALYPTUS_WOOD);
				entries.add(EucalyptusBlocks.EUCALYPTUS_BUTTON);
				entries.add(EucalyptusBlocks.EUCALYPTUS_FENCE);
				entries.add(EucalyptusBlocks.EUCALYPTUS_FENCE_GATE);
				entries.add(EucalyptusBlocks.EUCALYPTUS_PRESSURE_PLATE);
				entries.add(EucalyptusBlocks.EUCALYPTUS_SLAB);
				entries.add(EucalyptusBlocks.EUCALYPTUS_STAIRS);
				entries.add(EucalyptusBlocks.EUCALYPTUS_TRAPDOOR);
				entries.add(EucalyptusBlocks.STRIPPED_EUCALYPTUS_LOG);
				entries.add(EucalyptusBlocks.STRIPPED_EUCALYPTUS_WOOD);
				entries.add(EucalyptusItems.EUCALYPTUS_DOOR);
				entries.add(EucalyptusItems.EUCALYPTUS_SIGN);
			})
			.build()
	);

	public static void init() {}
}
