package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.block.EucalyptusSaplingBlock;
import cc.unilock.eucalyptus.mixinsupport.BlockEntityTypeExtension;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class EucalyptusBlocks {
	// TODO: make our own settings (later)
	public static final Block EUCALYPTUS_SAPLING = registerBlockItem(
		"eucalyptus_sapling",
		new EucalyptusSaplingBlock(
			AbstractBlock.Settings.create()
				.mapColor(MapColor.DARK_GREEN)
				.noCollision()
				.ticksRandomly()
				.breakInstantly()
				.sounds(BlockSoundGroup.GRASS)
				.pistonBehavior(PistonBehavior.DESTROY)
		)
	);
	public static final Block EUCALYPTUS_LEAVES = registerBlockItem(
		"eucalyptus_leaves",
		Blocks.createLeavesBlock(BlockSoundGroup.GRASS)
	);
	public static final Block EUCALYPTUS_PLANKS = registerBlockItem(
		"eucalyptus_planks",
		new Block(
			AbstractBlock.Settings.create()
				.mapColor(MapColor.TERRACOTTA_PINK)
				.instrument(Instrument.BASS)
				.strength(2.0F, 3.0F)
				.sounds(BlockSoundGroup.WOOD)
				.burnable()
		)
	);
	public static final Block EUCALYPTUS_LOG = registerBlockItem(
		"eucalyptus_log",
		Blocks.createLogBlock(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_GRAY)
	);
	public static final Block EUCALYPTUS_WOOD = registerBlockItem(
		"eucalyptus_wood",
		new PillarBlock(
			AbstractBlock.Settings.create()
				.mapColor(MapColor.TERRACOTTA_GRAY)
				.instrument(Instrument.BASS)
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.burnable()
		)
	);
	public static final Block EUCALYPTUS_BUTTON = registerBlockItem(
		"eucalyptus_button",
		Blocks.createWoodenButtonBlock(EucalyptusBlockSetTypes.EUCALYPTUS)
	);
	public static final Block EUCALYPTUS_FENCE = registerBlockItem(
		"eucalyptus_fence",
		new FenceBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_PLANKS).solid()
		)
	);
	public static final Block EUCALYPTUS_FENCE_GATE = registerBlockItem(
		"eucalyptus_fence_gate",
		new FenceGateBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_PLANKS).solid(),
			EucalyptusWoodTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_PRESSURE_PLATE = registerBlockItem(
		"eucalyptus_pressure_plate",
		new PressurePlateBlock(
			PressurePlateBlock.ActivationRule.EVERYTHING,
			AbstractBlock.Settings.create()
				.mapColor(EUCALYPTUS_PLANKS.getDefaultMapColor())
				.solid()
				.instrument(Instrument.BASS)
				.noCollision()
				.strength(0.5F)
				.burnable()
				.pistonBehavior(PistonBehavior.DESTROY),
			EucalyptusBlockSetTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_SLAB = registerBlockItem(
		"eucalyptus_slab",
		new SlabBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_PLANKS)
		)
	);
	public static final Block EUCALYPTUS_STAIRS = registerBlockItem(
		"eucalyptus_stairs",
		new StairsBlock(
			EUCALYPTUS_PLANKS.getDefaultState(),
			FabricBlockSettings.copyOf(EUCALYPTUS_PLANKS)
		)
	);
	public static final Block EUCALYPTUS_TRAPDOOR = registerBlockItem(
		"eucalyptus_trapdoor",
		new TrapdoorBlock(
			AbstractBlock.Settings.create()
				.mapColor(EUCALYPTUS_PLANKS.getDefaultMapColor())
				.instrument(Instrument.BASS)
				.strength(3.0F)
				.nonOpaque()
				.allowsSpawning(Blocks::never)
				.burnable(),
			EucalyptusBlockSetTypes.EUCALYPTUS
		)
	);
	public static final Block STRIPPED_EUCALYPTUS_LOG = registerBlockItem(
		"stripped_eucalyptus_log",
		Blocks.createLogBlock(MapColor.TERRACOTTA_PINK, MapColor.TERRACOTTA_PINK)
	);
	public static final Block STRIPPED_EUCALYPTUS_WOOD = registerBlockItem(
		"stripped_eucalyptus_wood",
		new PillarBlock(
			AbstractBlock.Settings.create()
				.mapColor(MapColor.TERRACOTTA_PINK)
				.instrument(Instrument.BASS)
				.strength(2.0F)
				.sounds(BlockSoundGroup.WOOD)
				.burnable()
		)
	);
	public static final Block EUCALYPTUS_DOOR = registerBlock(
		"eucalyptus_door",
		new DoorBlock(
			AbstractBlock.Settings.create()
				.mapColor(EUCALYPTUS_PLANKS.getDefaultMapColor())
				.instrument(Instrument.BASS)
				.strength(3.0F)
				.nonOpaque()
				.burnable()
				.pistonBehavior(PistonBehavior.DESTROY),
			EucalyptusBlockSetTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_SIGN = registerBlock(
		"eucalyptus_sign",
		new SignBlock(
			AbstractBlock.Settings.create()
				.mapColor(EUCALYPTUS_PLANKS.getDefaultMapColor())
				.solid()
				.instrument(Instrument.BASS)
				.noCollision()
				.strength(1.0F)
				.burnable(),
			EucalyptusWoodTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_WALL_SIGN = registerBlock(
		"eucalyptus_wall_sign",
		new WallSignBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_SIGN).dropsLike(EUCALYPTUS_SIGN),
			EucalyptusWoodTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_HANGING_SIGN = registerBlock(
		"eucalyptus_hanging_sign",
		new HangingSignBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_SIGN),
			EucalyptusWoodTypes.EUCALYPTUS
		)
	);
	public static final Block EUCALYPTUS_WALL_HANGING_SIGN = registerBlock(
		"eucalyptus_wall_hanging_sign",
		new WallHangingSignBlock(
			FabricBlockSettings.copyOf(EUCALYPTUS_HANGING_SIGN).dropsLike(EUCALYPTUS_HANGING_SIGN),
			EucalyptusWoodTypes.EUCALYPTUS
		)
	);
	public static final Block POTTED_EUCALYPTUS_SAPLING = registerBlock(
		"potted_eucalyptus_sapling",
		Blocks.createFlowerPotBlock(EUCALYPTUS_SAPLING)
	);
	// EUCALYPTUS_BOAT !?
	// EUCALYPTUS_CHEST_BOAT !?

	private static Block registerBlock(String path, Block block) {
		return Registry.register(Registries.BLOCK, Eucalyptus.id(path), block);
	}

	private static Block registerBlockItem(String path, Block block) {
		Registry.register(Registries.ITEM, Eucalyptus.id(path), new BlockItem(block, new FabricItemSettings()));
		return registerBlock(path, block);
	}

	public static void init() {
		((BlockEntityTypeExtension) BlockEntityType.SIGN).eucalyptus$addSupportedBlocks(
			EUCALYPTUS_SIGN,
			EUCALYPTUS_WALL_SIGN
		);

		FlammableBlockRegistry.getDefaultInstance().add(EucalyptusTags.Blocks.EUCALYPTUS_LOGS, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_LEAVES, 30, 60);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_FENCE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_FENCE_GATE, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_SLAB, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(EUCALYPTUS_STAIRS, 5, 20);

		StrippableBlockRegistry.register(EUCALYPTUS_LOG, STRIPPED_EUCALYPTUS_LOG);
		StrippableBlockRegistry.register(EUCALYPTUS_WOOD, STRIPPED_EUCALYPTUS_WOOD);
	}
}
