package cc.unilock.eucalyptus.datagen.provider;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusItems;
import cc.unilock.eucalyptus.registry.EucalyptusTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class EucalyptusItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public EucalyptusItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture, @Nullable BlockTagProvider blockTagProvider) {
		super(output, completableFuture, blockTagProvider);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		copy(EucalyptusTags.Blocks.EUCALYPTUS_LOGS, EucalyptusTags.Items.EUCALYPTUS_LOGS);

		getOrCreateTagBuilder(ItemTags.BUTTONS).add(EucalyptusBlocks.EUCALYPTUS_BUTTON.asItem());
		//getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add();
		getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(EucalyptusBlocks.EUCALYPTUS_FENCE_GATE.asItem());
		//getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add();
		getOrCreateTagBuilder(ItemTags.LEAVES).add(EucalyptusBlocks.EUCALYPTUS_LEAVES.asItem());
		getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(EucalyptusTags.Items.EUCALYPTUS_LOGS);
		getOrCreateTagBuilder(ItemTags.PLANKS).add(EucalyptusBlocks.EUCALYPTUS_PLANKS.asItem());
		getOrCreateTagBuilder(ItemTags.SAPLINGS).add(EucalyptusBlocks.EUCALYPTUS_SAPLING.asItem());
		//getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add();
		getOrCreateTagBuilder(ItemTags.SIGNS).add(EucalyptusItems.EUCALYPTUS_SIGN);
		getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(EucalyptusBlocks.EUCALYPTUS_BUTTON.asItem());
		getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(EucalyptusItems.EUCALYPTUS_DOOR);
		getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(EucalyptusBlocks.EUCALYPTUS_FENCE.asItem());
		getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(EucalyptusBlocks.EUCALYPTUS_PRESSURE_PLATE.asItem());
		getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(EucalyptusBlocks.EUCALYPTUS_SLAB.asItem());
		getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(EucalyptusBlocks.EUCALYPTUS_STAIRS.asItem());
		getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(EucalyptusBlocks.EUCALYPTUS_TRAPDOOR.asItem());

		//getOrCreateTagBuilder(ItemTags.BOATS).add();
		//getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add();
	}
}
