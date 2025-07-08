package cc.unilock.eucalyptus.datagen.provider;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EucalyptusBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public EucalyptusBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(EucalyptusBlocks.EUCALYPTUS_HANGING_SIGN);
		getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(EucalyptusBlocks.EUCALYPTUS_FENCE_GATE);
		getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(EucalyptusBlocks.POTTED_EUCALYPTUS_SAPLING);
		getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(EucalyptusBlocks.EUCALYPTUS_LEAVES);
		getOrCreateTagBuilder(BlockTags.LEAVES).add(EucalyptusBlocks.EUCALYPTUS_LEAVES);
		getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(EucalyptusTags.Blocks.EUCALYPTUS_LOGS);
		getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(EucalyptusBlocks.EUCALYPTUS_LOG);
		getOrCreateTagBuilder(BlockTags.PLANKS).add(EucalyptusBlocks.EUCALYPTUS_PLANKS);
		getOrCreateTagBuilder(BlockTags.SAPLINGS).add(EucalyptusBlocks.EUCALYPTUS_SAPLING);
		getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(EucalyptusBlocks.EUCALYPTUS_SIGN);
		getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(EucalyptusBlocks.EUCALYPTUS_WALL_HANGING_SIGN);
		getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(EucalyptusBlocks.EUCALYPTUS_WALL_SIGN);
		getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(EucalyptusBlocks.EUCALYPTUS_BUTTON);
		getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(EucalyptusBlocks.EUCALYPTUS_DOOR);
		getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(EucalyptusBlocks.EUCALYPTUS_FENCE);
		getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(EucalyptusBlocks.EUCALYPTUS_PRESSURE_PLATE);
		getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(EucalyptusBlocks.EUCALYPTUS_SLAB);
		getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(EucalyptusBlocks.EUCALYPTUS_STAIRS);
		getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(EucalyptusBlocks.EUCALYPTUS_TRAPDOOR);
		getOrCreateTagBuilder(EucalyptusTags.Blocks.EUCALYPTUS_LOGS).add(EucalyptusBlocks.EUCALYPTUS_LOG, EucalyptusBlocks.EUCALYPTUS_WOOD, EucalyptusBlocks.STRIPPED_EUCALYPTUS_LOG, EucalyptusBlocks.STRIPPED_EUCALYPTUS_WOOD);
	}
}
