package cc.unilock.eucalyptus.datagen.provider;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class EucalyptusBlockLootTableProvider extends FabricBlockLootTableProvider {
	public EucalyptusBlockLootTableProvider(FabricDataOutput dataOutput) {
		super(dataOutput);
	}

	@Override
	public void generate() {
		addDrop(EucalyptusBlocks.EUCALYPTUS_SAPLING);
		addDrop(EucalyptusBlocks.EUCALYPTUS_LEAVES, block -> leavesDrops(block, EucalyptusBlocks.EUCALYPTUS_SAPLING, SAPLING_DROP_CHANCE));
		addDrop(EucalyptusBlocks.EUCALYPTUS_PLANKS);
		addDrop(EucalyptusBlocks.EUCALYPTUS_LOG);
		addDrop(EucalyptusBlocks.EUCALYPTUS_WOOD);
		addDrop(EucalyptusBlocks.EUCALYPTUS_BUTTON);
		addDrop(EucalyptusBlocks.EUCALYPTUS_FENCE);
		addDrop(EucalyptusBlocks.EUCALYPTUS_FENCE_GATE);
		addDrop(EucalyptusBlocks.EUCALYPTUS_PRESSURE_PLATE);
		addDrop(EucalyptusBlocks.EUCALYPTUS_SLAB, this::slabDrops);
		addDrop(EucalyptusBlocks.EUCALYPTUS_STAIRS);
		addDrop(EucalyptusBlocks.EUCALYPTUS_TRAPDOOR);
		addDrop(EucalyptusBlocks.STRIPPED_EUCALYPTUS_LOG);
		addDrop(EucalyptusBlocks.STRIPPED_EUCALYPTUS_WOOD);
		addDrop(EucalyptusBlocks.EUCALYPTUS_DOOR, this::doorDrops);
		addDrop(EucalyptusBlocks.EUCALYPTUS_SIGN);
	}
}
