package com.junipernine.oliviasminecraft;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by tonydawson on 04/09/2016.
 */
public class MultiItemBlock extends ItemBlock {

    private final static String[] subNames = {
            "white", "orange",  "magenta", "lightBlue", "yellow", "lightGreen",
            "pink", "darkGrey", "lightGrey", "cyan", "purple", "blue", "brown",
            "green", "red", "black"
    };

    public MultiItemBlock(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }

}