package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.mixin.accessor.BlockSetTypeAccessor;
import net.minecraft.block.BlockSetType;

public class EucalyptusBlockSetTypes {
	public static final BlockSetType EUCALYPTUS = BlockSetTypeAccessor.callRegister(new BlockSetType(Eucalyptus.id("eucalyptus").toString()));

	public static void init() {}
}
