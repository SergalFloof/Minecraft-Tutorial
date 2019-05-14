package com.marras.objects.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockDoor extends ItemBlock{

	public ItemBlockDoor(Block block) {
		super(block);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(facing != EnumFacing.UP) return EnumActionResult.FAIL;
		else {
			
			IBlockState bdState = worldIn.getBlockState(pos);
			Block bdBlock = bdState.getBlock();
			
			if(!block.isReplaceable(worldIn, pos)) pos =pos.offset(facing);
			
			ItemStack stack = player.getHeldItem(hand);
			if(player.canPlayerEdit(pos, facing, stack) && this.block.canPlaceBlockAt(worldIn, pos)) {
				
				EnumFacing playerFacing = EnumFacing.fromAngle((double)player.rotationYaw);
				int x = playerFacing.getFrontOffsetX();
				int z = playerFacing.getFrontOffsetZ();
				boolean flag = x < 0 && hitZ < 0.5f || x > 0 && hitZ > 0.5f || z < 0 && hitX < 0.5f || z > 0 && hitX > 0.5f;
				placeDoor(worldIn, pos, playerFacing, this.block, flag);
				
				SoundType sound = block.getSoundType(bdState, worldIn, pos, player);
				worldIn.playSound(player, pos, sound.getPlaceSound(), SoundCategory.BLOCKS, (sound.getVolume() + 1.0f) / 2.0f, sound.getPitch() * 0.8f);
				stack.shrink(1);
				return EnumActionResult.SUCCESS;
			}else return EnumActionResult.FAIL;
			
		}
	}

	private static void placeDoor(World worldIn, BlockPos bdPos, EnumFacing playerFacing, Block door, boolean isRightHinge) {
		
		BlockPos posYClockwise = bdPos.offset(playerFacing.rotateY());
		BlockPos posYAntiClockwise = bdPos.offset(playerFacing.rotateYCCW());
		
		int i = (worldIn.getBlockState(posYAntiClockwise).isNormalCube() ? 1 : 0) + (worldIn.getBlockState(posYAntiClockwise.up()).isNormalCube() ? 1 : 0);
		int j = (worldIn.getBlockState(posYClockwise).isNormalCube() ? 1 : 0) + (worldIn.getBlockState(posYClockwise.up()).isNormalCube() ? 1 : 0);

		boolean flag = worldIn.getBlockState(posYAntiClockwise).getBlock() == worldIn.getBlockState(posYAntiClockwise.up()).getBlock();
		boolean flag1 = worldIn.getBlockState(posYClockwise).getBlock() == worldIn.getBlockState(posYClockwise.up()).getBlock();
		
		if((!flag || flag1) && j <= i) {
			
			if(flag1 && !flag || j < i) isRightHinge = false;
		}else isRightHinge = true;
		
		
		BlockPos tdPos = bdPos.up();
		boolean powered = worldIn.isBlockPowered(bdPos) || worldIn.isBlockPowered(tdPos);
		IBlockState doorState = door.getDefaultState()
				.withProperty(BlockDoor.FACING, playerFacing)
				.withProperty(BlockDoor.HINGE, isRightHinge ? BlockDoor.EnumHingePosition.RIGHT : BlockDoor.EnumHingePosition.LEFT)
				.withProperty(BlockDoor.POWERED, Boolean.valueOf(powered))
				.withProperty(BlockDoor.OPEN, Boolean.valueOf(powered));
		
		worldIn.setBlockState(bdPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER));
		worldIn.setBlockState(tdPos, doorState.withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER));
		worldIn.notifyNeighborsOfStateChange(bdPos, door, false);
		worldIn.notifyNeighborsOfStateChange(tdPos, door, false);

			
	}

}
