package cc.unilock.eucalyptus.mixin;

import cc.unilock.eucalyptus.mixinsupport.BlockEntityTypeExtension;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin implements BlockEntityTypeExtension {
	@Shadow
	@Final
	@Mutable
	private Set<Block> blocks;

	@Override
	public void eucalyptus$addSupportedBlocks(Block... blocks) {
		Set<Block> theBlocks = new HashSet<>(this.blocks);
		theBlocks.addAll(List.of(blocks));
		this.blocks = theBlocks;
	}
}
