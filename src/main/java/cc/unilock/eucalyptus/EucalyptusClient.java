package cc.unilock.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.block.extensions.api.client.BlockRenderLayerMap;

public class EucalyptusClient implements ClientModInitializer {
	public static final int EUCALYPTUS_LEAVES_COLOR = 7842607;

	@Override
	public void onInitializeClient(ModContainer mod) {
		BlockRenderLayerMap.put(
			RenderLayer.getCutoutMipped(),
			EucalyptusBlocks.EUCALYPTUS_LEAVES
		);
		BlockRenderLayerMap.put(
			RenderLayer.getCutout(),
			EucalyptusBlocks.EUCALYPTUS_SAPLING,
			EucalyptusBlocks.EUCALYPTUS_DOOR,
			EucalyptusBlocks.EUCALYPTUS_TRAPDOOR
		);
		ColorProviderRegistry.BLOCK.register(
			(state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : EUCALYPTUS_LEAVES_COLOR,
			EucalyptusBlocks.EUCALYPTUS_LEAVES
		);
		ColorProviderRegistry.ITEM.register(
			(stack, tintIndex) -> EUCALYPTUS_LEAVES_COLOR,
			EucalyptusBlocks.EUCALYPTUS_LEAVES
		);
	}
}
