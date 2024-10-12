package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;

public class EucalyptusClient implements ClientModInitializer {
	public static final int EUCALYPTUS_LEAVES_COLOR = 0x77AB2F;

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(
			EucalyptusBlocks.EUCALYPTUS_LEAVES,
			RenderLayer.getCutoutMipped()
		);
		BlockRenderLayerMap.INSTANCE.putBlocks(
			RenderLayer.getCutout(),
			EucalyptusBlocks.EUCALYPTUS_SAPLING,
			EucalyptusBlocks.EUCALYPTUS_DOOR,
			EucalyptusBlocks.EUCALYPTUS_TRAPDOOR
		);
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> (world != null && pos != null) ? BiomeColors.getFoliageColor(world, pos) : EUCALYPTUS_LEAVES_COLOR,
			EucalyptusBlocks.EUCALYPTUS_LEAVES
		);
		ColorProviderRegistry.ITEM.register(
			(stack, tintIndex) -> EUCALYPTUS_LEAVES_COLOR,
			EucalyptusBlocks.EUCALYPTUS_LEAVES
		);
	}
}
