package com.marras.objects.blocks;

import com.marras.Main;
import com.marras.objects.blocks.tileentity.TEEnergyStorage;
import com.marras.util.handlers.ConfigHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEnergyStorage extends BlockBase {

	public BlockEnergyStorage(String name) {
		super(name, Material.IRON, Main.maintab);
	}
	
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TEEnergyStorage();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			
			playerIn.openGui(Main.instance, ConfigHandler.GUI_ENERGY_STORAGE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
	

}
