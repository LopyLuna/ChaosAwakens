package io.github.chaosawakens.common.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public final class PathNavigationUtil {
	
	private PathNavigationUtil() {
		throw new IllegalAccessError("Attempted to instantiate a Utility Class!");
	}
	
	/**
	 * Determines the {@link PathNodeType} of the specifies {@link BlockPos} for the specified position <i>alone</i>, meaning 
	 * that other positions (surrounding or not) are not taken into account when determining the {@link PathNodeType} of the 
	 * specified {@link BlockPos}.
	 * @param blockReader The block reader of the current world to use for getting {@linkplain Block blocks}, {@linkplain BlockPos block positions}, 
	 * etc. and use to determine the {@link PathNodeType} for the specified {@link BlockPos}.
	 * @param targetPos The target position to determine the {@link PathNodeType} of.
	 * @return The {@link PathNodeType} for the specified {@link BlockPos}.
	 */
	@SuppressWarnings("deprecation")
	public static PathNodeType determinePathNodeType(IBlockReader blockReader, BlockPos targetPos) {
		BlockState targetBlockState = blockReader.getBlockState(targetPos);
		FluidState targetFluidState = blockReader.getFluidState(targetPos);
		
		if (!targetBlockState.isAir(blockReader, targetPos)) {
			if (targetBlockState.is(BlockTags.LEAVES)) return PathNodeType.LEAVES;
			else if (targetBlockState.getBlock() instanceof CocoaBlock) return PathNodeType.COCOA;
		} else {
			if (targetFluidState.is(FluidTags.WATER)) return PathNodeType.WATER;
			else if (targetFluidState.is(FluidTags.LAVA)) return PathNodeType.LAVA;
			else if (targetFluidState.isEmpty()) return PathNodeType.OPEN;
		}
		
		return PathNodeType.OPEN;
	}
}