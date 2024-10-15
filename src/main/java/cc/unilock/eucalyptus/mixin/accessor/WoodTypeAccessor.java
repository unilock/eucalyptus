package cc.unilock.eucalyptus.mixin.accessor;

import net.minecraft.block.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(WoodType.class)
public interface WoodTypeAccessor {
	@Invoker("register")
	static WoodType callRegister(WoodType type) {
		throw new IllegalStateException();
	}
}
