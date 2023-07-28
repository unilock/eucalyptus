package cc.unilock.eucalyptus.registery;

import cc.unilock.eucalyptus.Eucalyptus;
import net.fabricmc.fabric.api.object.builder.v1.sign.SignTypeRegistry;
import net.minecraft.util.SignType;

public class EucalyptusSignTypes {
	public static final SignType EUCALYPTUS = SignTypeRegistry.registerSignType(Eucalyptus.id("eucalyptus"));
}
