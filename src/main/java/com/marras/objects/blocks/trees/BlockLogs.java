package com.marras.objects.blocks.trees;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.marras.Main;
import com.marras.init.BlockInit;
import com.marras.init.ItemInit;
import com.marras.objects.blocks.item.ItemBlockVariants;
import com.marras.util.handlers.EnumHandler;
import com.marras.util.interfaces.IHasModel;
import com.marras.util.interfaces.IMetaName;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockLogs extends BlockLog implements IMetaName, IHasModel
{
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class, new Predicate<EnumHandler.EnumType>()
	{
		public boolean apply(@Nullable EnumHandler.EnumType apply)
		{
			return apply.getMeta() < 2;
		}
	});
	
	@SuppressWarnings("unused")
	private String name;
	
	public BlockLogs(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.COPPER).withProperty(LOG_AXIS, EnumAxis.Y));
		setCreativeTab(Main.maintab);
		
		this.name = name;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandler.EnumType customblockplanks$enumtype : EnumHandler.EnumType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		IBlockState state = this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata((meta & 1) % 2));
		
		switch(meta & 6)
		{
		case 0:
			state = state.withProperty(LOG_AXIS, EnumAxis.Y);
			break;
			
		case 2:
			state = state.withProperty(LOG_AXIS, EnumAxis.X);
			break;
			
		case 4:
			state = state.withProperty(LOG_AXIS, EnumAxis.Z);
			break;
			
		default:
			state = state.withProperty(LOG_AXIS, EnumAxis.NONE);
		}
		
		return state;
	}
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = 0;
		i = i | ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
		
		switch((BlockLog.EnumAxis)state.getValue(LOG_AXIS))
		{
		case X:
			i |= 2;
			break;
			
		case Y:
			i |= 4;
			break;
			
		case Z:
			i |= 6;
		}
		
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,LOG_AXIS});
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++)
		{
			Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "log_" + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}	
}
