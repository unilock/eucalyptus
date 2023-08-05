package cc.unilock.eucalyptus.world.tree.eucalyptus;

import cc.unilock.eucalyptus.registry.EucalyptusFeatures;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class EucalyptusTrunkPlacer extends TrunkPlacer {
	public static final Codec<EucalyptusTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> fillTrunkPlacerFields(instance).apply(instance, EucalyptusTrunkPlacer::new));

	public EucalyptusTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> getType() {
		return EucalyptusFeatures.EUCALYPTUS_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {
		setToDirt(world, replacer, random, startPos.down(), config);

		for (int i = 0; i < height; i++) {
			// method_35375 = getAndSetState
			this.method_35375(world, replacer, random, startPos.up(i), config);
		}

		List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();

		list.add(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));

		this.generateTree(list, world, replacer, random, height, startPos, config);

		return list;
	}

	private void generateTree(List<FoliagePlacer.TreeNode> list, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos startPos, TreeFeatureConfig config) {
		this.genBranch(list, world, replacer, random, height, startPos, config, 1);
		this.genBranch(list, world, replacer, random, height, startPos, config, 2);
		this.genBranch(list, world, replacer, random, height, startPos, config, 3);
		this.genBranch(list, world, replacer, random, height, startPos, config, 4);
		this.genStraightBranch(list, world, replacer, random, height, startPos, config, 1);
		this.genStraightBranch(list, world, replacer, random, height, startPos, config, 2);
		this.genStraightBranch(list, world, replacer, random, height, startPos, config, 3);
		this.genStraightBranch(list, world, replacer, random, height, startPos, config, 4);
		list.add(this.generateNode(world, replacer, random, startPos.up(height), config));
	}

	private void genBranch(List<FoliagePlacer.TreeNode> list, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos pos, TreeFeatureConfig config, int direction)
	{
		int posX = pos.getX();
		int posY = pos.getY() + height - 3;
		int posZ = pos.getZ();

		byte xShift = 0;
		byte zShift = 0;

		switch (direction) {
			case 1 -> {
				xShift = 1;
				zShift = 1;
			}
			case 2 -> {
				xShift = -1;
				zShift = 1;
			}
			case 3 -> {
				xShift = 1;
				zShift = -1;
			}
			case 4 -> {
				xShift = -1;
				zShift = -1;
			}
		}

		int heightShift = random.nextInt(6);

		for (int bIter = 4; bIter > 0; bIter--)
		{
			if (heightShift % 3 != 0)
			{
				posX += xShift;
			}

			if (heightShift % 3 != 1)
			{
				posZ += zShift;
			}

			int branch = heightShift % 3;

			posY += branch;

			BlockPos blockpos = new BlockPos(posX, posY, posZ);

			if (branch == 2)
			{
				//this.setBlockAndMetadata(world, blockpos.down(), this.log);
				this.method_35375(world, replacer, random, blockpos.down(), config);
			}

			//this.setBlockAndMetadata(world, blockpos, this.log);
			this.method_35375(world, replacer, random, blockpos, config);

			if (bIter == 1)
			{
				list.add(this.generateNode(world, replacer, random, blockpos, config));
			}

			heightShift = random.nextInt(6);
		}
	}

	private void genStraightBranch(List<FoliagePlacer.TreeNode> list, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, int height, BlockPos pos, TreeFeatureConfig config, int direction)
	{
		int posX = pos.getX();
		int posY = pos.getY() + height - 3;
		int posZ = pos.getZ();

		byte xShift = 0;
		byte zShift = 0;

		switch (direction) {
			case 1 -> {
				xShift = 1;
				zShift = 0;
			}
			case 2 -> {
				xShift = 0;
				zShift = 1;
			}
			case 3 -> {
				xShift = -1;
				zShift = 0;
			}
			case 4 -> {
				xShift = 0;
				zShift = -1;
			}
		}

		int heightShift = random.nextInt(6);

		for (int j2 = 4; j2 > 0; j2--)
		{
			if (xShift == 0)
			{
				posX = (posX + random.nextInt(3)) - 1;
				posZ += zShift;
			}

			if (zShift == 0)
			{
				posX += xShift;
				posZ = (posZ + random.nextInt(3)) - 1;
			}

			int branch = heightShift % 3;

			posY += branch;

			BlockPos blockpos = new BlockPos(posX, posY, posZ);

			if (branch == 2)
			{
				//this.setBlockAndMetadata(world, blockpos.down(), this.log);
				this.method_35375(world, replacer, random, blockpos.down(), config);
			}

			//this.setBlockAndMetadata(world, blockpos, this.log);
			this.method_35375(world, replacer, random, blockpos, config);

			if (j2 == 1)
			{
				list.add(this.generateNode(world, replacer, random, blockpos, config));
			}

			heightShift = random.nextInt(6);
		}
	}

	public FoliagePlacer.TreeNode generateNode(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, RandomGenerator random, BlockPos pos, TreeFeatureConfig config)
	{
		//this.setBlockAndMetadata(world, pos, this.log);
		this.method_35375(world, replacer, random, pos, config);

		/*
		for (int xIter = pos.getX() - 2; xIter <= pos.getX() + 2; xIter++)
		{
			for (int zIter = pos.getZ() - 1; zIter <= pos.getZ() + 1; zIter++)
			{
				BlockPos newPos = new BlockPos(xIter, pos.getY(), zIter);
				IBlockState state = world.getBlockState(newPos);
				Block block = state.getBlock();

				if (block != NaturaOverworld.overworldLeaves2 && !block.isFullBlock(state))
				{
					this.setBlockAndMetadata(world, newPos, this.leaves);
				}
			}
		}

		for (int xIter = pos.getX() - 1; xIter <= pos.getX() + 1; xIter++)
		{
			for (int zIter = pos.getZ() - 2; zIter <= pos.getZ() + 2; zIter++)
			{
				BlockPos newPos = new BlockPos(xIter, pos.getY(), zIter);
				IBlockState state = world.getBlockState(newPos);
				Block block = state.getBlock();

				if (block != NaturaOverworld.overworldLeaves2 && !block.isFullBlock(state))
				{
					this.setBlockAndMetadata(world, newPos, this.leaves);
				}
			}
		}

		for (int xIter = pos.getX() - 1; xIter <= pos.getX() + 1; xIter++)
		{
			for (int zIter = pos.getZ() - 1; zIter <= pos.getZ() + 1; zIter++)
			{
				BlockPos newPos = new BlockPos(xIter, pos.getY() + 1, zIter);
				IBlockState state = world.getBlockState(newPos);
				Block block = state.getBlock();

				if (block != NaturaOverworld.overworldLeaves2 && !block.isFullBlock(state))
				{
					this.setBlockAndMetadata(world, newPos, this.leaves);
				}
			}
		}
		 */

		return new FoliagePlacer.TreeNode(pos.up(), 0, false);
	}
}
