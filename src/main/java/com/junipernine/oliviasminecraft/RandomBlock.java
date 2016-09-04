package com.junipernine.oliviasminecraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Random;

/**
 * Created by tonydawson on 04/09/2016.
 */
public class RandomBlock extends Block {
    public RandomBlock (int id, int texture) {
        super( Material.GROUND);
        setBlockName("random");
        setCreativeTab(CreativeTabs.tabBlock);
    }

//    @Override
    public boolean onBlockActivated (World world, int bx, int by, int bz,
                                     EntityPlayer playerEntity, int unknown, float px, float py, float pz) {
        Random random = new Random();
        int randomInt1 = random.nextInt();
        int randomInt2 = random.nextInt();

        ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
        DataOutputStream outputStream = new DataOutputStream(bos);
        try {
            outputStream.writeInt(randomInt1);
            outputStream.writeInt(randomInt2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "XPdec";
        packet.data = bos.toByteArray();
        packet.length = bos.size();

        Side side = FMLCommonHandler.instance().getEffectiveSide();
        if (side == Side.SERVER) {
            // We are on the server side.
            EntityPlayerMP player = (EntityPlayerMP) playerEntity;
        } else if (side == Side.CLIENT) {
            // We are on the client side.
            EntityClientPlayerMP player = (EntityClientPlayerMP) playerEntity;
            player.sendQueue.addToSendQueue(packet);
        } else {
            // We are on the Bukkit server.
        }

        return false;
    }

//    @Override
    public String getTextureFile () {
        return CommonProxy.BLOCK_PNG;
    }
}
