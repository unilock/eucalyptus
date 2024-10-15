package cc.unilock.eucalyptus.mixin.accessor;

import net.minecraft.block.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BlockSetType.class)
public interface BlockSetTypeAccessor {
	@Invoker("register")
	static BlockSetType callRegister(BlockSetType blockSetType) {
		throw new IllegalStateException();
	}
}
