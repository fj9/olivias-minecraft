package com.junipernine.oliviasminecraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
/**
 * Created by tonydawson on 04/09/2016.
 */
public class CommonProxy implements IGuiHandler {
    public static String ITEMS_PNG = "/resources/asserts/items/items.png";
    public static String BLOCK_PNG = "/resources/asserts/blocks/block.png";

    // Client stuff
    public void registerRenderers () {
        // Nothing here as this is the server side proxy
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        // TileEntity tile = world.getBlockTileEntity(x, y, z);

        /*
        if (!(tile instanceof CrystalizerTileEntity)) {
        	return null;
        }

        return new CrystalizerContainer(player.inventory, (CrystalizerTileEntity) tile);
        */

        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
	    /*
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if (!(tileEntity instanceof GenericTileEntity)) {
        	return null;
        }

        return new GenericGui(player.inventory, (GenericTileEntity) tileEntity);
        */

        return null;
    }
}