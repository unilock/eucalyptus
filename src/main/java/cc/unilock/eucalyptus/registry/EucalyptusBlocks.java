package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.block.EucalyptusSaplingBlock;
import cc.unilock.eucalyptus.world.tree.eucalyptus.EucalyptusSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class EucalyptusBlocks {
	// TODO: make our own settings (later)
	public static final Block EUCALYPTUS_SAPLING = registerBlockItem("eucalyptus_sapling", new EucalyptusSaplingBlock(new EucalyptusSaplingGenerator(), QuiltBlockSettings.copyOf(Blocks.OAK_SAPLING)));
	public static final Block EUCALYPTUS_LEAVES = registerBlockItem("eucalyptus_leaves", new LeavesBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block EUCALYPTUS_PLANKS = registerBlockItem("eucalyptus_planks", new Block(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block EUCALYPTUS_LOG = registerBlockItem("eucalyptus_log", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block EUCALYPTUS_WOOD = registerBlockItem("eucalyptus_wood", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block EUCALYPTUS_BUTTON = registerBlockItem("eucalyptus_button", new WoodenButtonBlock(QuiltBlockSettings.copyOf(Blocks.OAK_BUTTON)));
	public static final Block EUCALYPTUS_FENCE = registerBlockItem("eucalyptus_fence", new FenceBlock(QuiltBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block EUCALYPTUS_FENCE_GATE = registerBlockItem("eucalyptus_fence_gate", new FenceGateBlock(QuiltBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
	public static final Block EUCALYPTUS_PRESSURE_PLATE = registerBlockItem("eucalyptus_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
	public static final Block EUCALYPTUS_SLAB = registerBlockItem("eucalyptus_slab", new SlabBlock(QuiltBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block EUCALYPTUS_STAIRS = registerBlockItem("eucalyptus_stairs", new StairsBlock(EUCALYPTUS_PLANKS.getDefaultState(), QuiltBlockSettings.copyOf(Blocks.OAK_STAIRS)));
	public static final Block EUCALYPTUS_TRAPDOOR = registerBlockItem("eucalyptus_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));
	public static final Block STRIPPED_EUCALYPTUS_LOG = registerBlockItem("stripped_eucalyptus_log", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_EUCALYPTUS_WOOD = registerBlockItem("stripped_eucalyptus_wood", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block EUCALYPTUS_DOOR = registerBlock("eucalyptus_door", new DoorBlock(QuiltBlockSettings.copyOf(Blocks.OAK_DOOR)));
	public static final Block EUCALYPTUS_SIGN = registerBlock("eucalyptus_sign", new SignBlock(QuiltBlockSettings.copyOf(Blocks.OAK_SIGN), EucalyptusSignTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_WALL_SIGN = registerBlock("eucalyptus_wall_sign", new WallSignBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(EUCALYPTUS_SIGN), EucalyptusSignTypes.EUCALYPTUS));

	private static Block registerBlock(String path, Block block) {
		return Registry.register(Registry.BLOCK, Eucalyptus.id(path), block);
	}

	private static Block registerBlockItem(String path, Block block) {
		Registry.register(Registry.ITEM, Eucalyptus.id(path), new BlockItem(block, new QuiltItemSettings().group(Eucalyptus.EUCALYPTUS_ITEM_GROUP)));
		return registerBlock(path, block);
	}

	public static void init() {
		BlockEntityType.SIGN.addSupportedBlocks(
			EUCALYPTUS_SIGN,
			EUCALYPTUS_WALL_SIGN
		);
	}
}
