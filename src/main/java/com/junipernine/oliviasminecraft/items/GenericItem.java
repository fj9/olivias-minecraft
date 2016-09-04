package com.junipernine.oliviasminecraft.items;

import com.junipernine.oliviasminecraft.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GenericItem extends Item {

    public GenericItem(int id) {
        super();

        // Constructor Configuration
        maxStackSize = 64;
        setCreativeTab(CreativeTabs.MISC);
//        setIconIndex(0);
//        setItemName("genericItem");
    }

    public GenericItem(int id, int maxStackSize, CreativeTabs tab,
                       int texture, String name) {
        super();
        setMaxStackSize(maxStackSize);
        setCreativeTab(tab);
//        setIconIndex(texture);
//        setItemName(name);
    }

    public String getTextureFile() {
        return CommonProxy.ITEMS_PNG;
    }
}
