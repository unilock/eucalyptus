package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.mixin.accessor.TrunkPlacerTypeAccessor;
import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class EucalyptusTrunkPlacerTypes {
	public static final TrunkPlacerType<EucalyptusTrunkPlacer> EUCALYPTUS = TrunkPlacerTypeAccessor.callRegister(Eucalyptus.id("eucalyptus").toString(), EucalyptusTrunkPlacer.CODEC);

	public static void init() {}
}
