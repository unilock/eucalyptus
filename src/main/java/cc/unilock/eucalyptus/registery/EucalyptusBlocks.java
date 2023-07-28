package cc.unilock.eucalyptus.registery;

import cc.unilock.eucalyptus.Eucalyptus;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.util.SignType;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class EucalyptusBlocks {
	// TODO: make our own settings (later)
	public static final Block EUCALYPTUS_SAPLING = register("eucalyptus_sapling", new SaplingBlock(null, QuiltBlockSettings.copyOf(Blocks.OAK_SAPLING)));
	public static final Block EUCALYPTUS_LEAVES = register("eucalyptus_leaves", new LeavesBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block EUCALYPTUS_PLANKS = register("eucalyptus_planks", new Block(QuiltBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block EUCALYPTUS_LOG = register("eucalyptus_log", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block EUCALYPTUS_WOOD = register("eucalyptus_wood", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block EUCALYPTUS_BUTTON = register("eucalyptus_button", new WoodenButtonBlock(QuiltBlockSettings.copyOf(Blocks.OAK_BUTTON)));
	public static final Block EUCALYPTUS_DOOR = register("eucalyptus_door", new DoorBlock(QuiltBlockSettings.copyOf(Blocks.OAK_DOOR)));
	public static final Block EUCALYPTUS_FENCE = register("eucalyptus_fence", new FenceBlock(QuiltBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block EUCALYPTUS_FENCE_GATE = register("eucalyptus_fence_gate", new FenceGateBlock(QuiltBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
	public static final Block EUCALYPTUS_PRESSURE_PLATE = register("eucalyptus_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, QuiltBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
	public static final Block EUCALYPTUS_SIGN = register("eucalyptus_sign", new SignBlock(QuiltBlockSettings.copyOf(Blocks.OAK_SIGN), EucalyptusSignTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_SLAB = register("eucalyptus_slab", new SlabBlock(QuiltBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block EUCALYPTUS_STAIRS = register("eucalyptus_stairs", new StairsBlock(EUCALYPTUS_PLANKS.getDefaultState(), QuiltBlockSettings.copyOf(Blocks.OAK_STAIRS)));
	public static final Block EUCALYPTUS_TRAPDOOR = register("eucalyptus_trapdoor", new TrapdoorBlock(QuiltBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));
	public static final Block EUCALYPTUS_WALL_SIGN = register("eucalyptus_wall_sign", new WallSignBlock(QuiltBlockSettings.copyOf(Blocks.OAK_WALL_SIGN), EucalyptusSignTypes.EUCALYPTUS));
	public static final Block STRIPPED_EUCALYPTUS_LOG = register("stripped_eucalyptus_log", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_EUCALYPTUS_WOOD = register("stripped_eucalyptus_wood", new PillarBlock(QuiltBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));

	private static Block register(String path, Block block) {
		Registry.register(Registry.ITEM, Eucalyptus.id(path), new BlockItem(block, new QuiltItemSettings()));
		return Registry.register(Registry.BLOCK, Eucalyptus.id(path), block);
	}

	public static void init() {}
}
