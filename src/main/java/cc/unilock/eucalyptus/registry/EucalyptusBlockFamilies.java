package cc.unilock.eucalyptus.registry;

import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;

public class EucalyptusBlockFamilies {
	public static final BlockFamily EUCALYPTUS = BlockFamilies.register(EucalyptusBlocks.EUCALYPTUS_PLANKS)
		.button(EucalyptusBlocks.EUCALYPTUS_BUTTON)
		.fence(EucalyptusBlocks.EUCALYPTUS_FENCE)
		.fenceGate(EucalyptusBlocks.EUCALYPTUS_FENCE_GATE)
		.pressurePlate(EucalyptusBlocks.EUCALYPTUS_PRESSURE_PLATE)
		.sign(EucalyptusBlocks.EUCALYPTUS_SIGN, EucalyptusBlocks.EUCALYPTUS_WALL_SIGN)
		.slab(EucalyptusBlocks.EUCALYPTUS_SLAB)
		.stairs(EucalyptusBlocks.EUCALYPTUS_STAIRS)
		.door(EucalyptusBlocks.EUCALYPTUS_DOOR)
		.trapdoor(EucalyptusBlocks.EUCALYPTUS_TRAPDOOR)
		.group("wooden")
		.unlockCriterionName("has_planks")
		.build();

	public static void init() {}
}
