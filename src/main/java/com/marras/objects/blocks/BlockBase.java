package com.marras.objects.blocks;

import com.marras.util.IHasModel;
import com.marras.Main;
import com.marras.init.BlockInit;
import com.marras.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel

{

	public BlockBase(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.maintab);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		
		registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

	private void registerItemRenderer(Item itemFromBlock, int i, String string) {
		// TODO Auto-generated method stub
		
	}

}
