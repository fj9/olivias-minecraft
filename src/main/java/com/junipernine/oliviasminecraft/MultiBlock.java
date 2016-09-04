package com.junipernine.oliviasminecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by tonydawson on 04/09/2016.
 */
public class MultiBlock extends Block {
    public MultiBlock(int id) {
        super(Material.GROUND);
//        setBlockName("multiBlock");
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

//    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
        return 16 + metadata;
    }

//    @Override
    public String getTextureFile() {
        return CommonProxy.BLOCK_PNG;
    }

//    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems) {
        for (int ix = 0; ix < 16; ix++) {
            subItems.add(new ItemStack(this, 1, ix));
        }
    }
}