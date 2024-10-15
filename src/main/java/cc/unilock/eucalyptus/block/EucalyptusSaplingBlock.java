package cc.unilock.eucalyptus.block;

import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusSaplingGenerator;
import net.minecraft.block.SaplingBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EucalyptusSaplingBlock extends SaplingBlock {
	public EucalyptusSaplingBlock(Settings settings) {
		super(new EucalyptusSaplingGenerator(), settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("block.eucalyptus.eucalyptus_sapling.tooltip").formatted(Formatting.GRAY).formatted(Formatting.ITALIC));
		super.appendTooltip(stack, world, tooltip, context);
	}
}
