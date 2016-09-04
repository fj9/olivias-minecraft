package com.junipernine.oliviasminecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by tonydawson on 04/09/2016.
 */
public class GenericBlock extends Block {

    public GenericBlock (Material material) {
        super(material);
//        super();
//        super(id, texture, material);
    }

    public String getTextureFile () {
        return CommonProxy.BLOCK_PNG;
    }

}

