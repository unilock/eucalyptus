package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.mixin.accessor.WoodTypeAccessor;
import net.minecraft.block.WoodType;

public class EucalyptusWoodTypes {
	public static final WoodType EUCALYPTUS = WoodTypeAccessor.callRegister(new WoodType(Eucalyptus.id("eucalyptus").toString(), EucalyptusBlockSetTypes.EUCALYPTUS));

	public static void init() {}
}
