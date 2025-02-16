package cc.unilock.eucalyptus.registry;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.block.EucalyptusSaplingBlock;
import cc.unilock.eucalyptus.mixinsupport.BlockEntityTypeExtension;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SignBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class EucalyptusBlocks {
	// TODO: make our own settings (later)
	public static final Block EUCALYPTUS_SAPLING = registerBlockItem("eucalyptus_sapling", new EucalyptusSaplingBlock(FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));
	public static final Block EUCALYPTUS_LEAVES = registerBlockItem("eucalyptus_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES)));
	public static final Block EUCALYPTUS_PLANKS = registerBlockItem("eucalyptus_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block EUCALYPTUS_LOG = registerBlockItem("eucalyptus_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG)));
	public static final Block EUCALYPTUS_WOOD = registerBlockItem("eucalyptus_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD)));
	public static final Block EUCALYPTUS_BUTTON = registerBlockItem("eucalyptus_button", Blocks.createWoodenButtonBlock(EucalyptusBlockSetTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_FENCE = registerBlockItem("eucalyptus_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block EUCALYPTUS_FENCE_GATE = registerBlockItem("eucalyptus_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), EucalyptusWoodTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_PRESSURE_PLATE = registerBlockItem("eucalyptus_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), EucalyptusBlockSetTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_SLAB = registerBlockItem("eucalyptus_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block EUCALYPTUS_STAIRS = registerBlockItem("eucalyptus_stairs", new StairsBlock(EUCALYPTUS_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
	public static final Block EUCALYPTUS_TRAPDOOR = registerBlockItem("eucalyptus_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), EucalyptusBlockSetTypes.EUCALYPTUS));
	public static final Block STRIPPED_EUCALYPTUS_LOG = registerBlockItem("stripped_eucalyptus_log", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG)));
	public static final Block STRIPPED_EUCALYPTUS_WOOD = registerBlockItem("stripped_eucalyptus_wood", new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD)));
	public static final Block EUCALYPTUS_DOOR = registerBlock("eucalyptus_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), EucalyptusBlockSetTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_SIGN = registerBlock("eucalyptus_sign", new SignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), EucalyptusWoodTypes.EUCALYPTUS));
	public static final Block EUCALYPTUS_WALL_SIGN = registerBlock("eucalyptus_wall_sign", new WallSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(EUCALYPTUS_SIGN), EucalyptusWoodTypes.EUCALYPTUS));

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
