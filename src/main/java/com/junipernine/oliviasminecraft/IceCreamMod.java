package com.junipernine.oliviasminecraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * Created by tonydawson on 04/09/2016.
 */
@Mod(modid = IceCreamMod.MODID,
        version = IceCreamMod.VERSION,
        name = IceCreamMod.MODNAME)
//@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "GenericRandom" })
public class IceCreamMod {

    public static final String MODID = "icecreammod";
    public static final String VERSION = "1.0";
    public static final String MODNAME= "Ice Cream";

    @SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(value = IceCreamMod.MODID)
    public static IceCreamMod INSTANCE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ItemStack cocoaStack = new ItemStack(Blocks.COCOA);
        ItemStack eggStack = new ItemStack(Items.EGG);
        ItemStack milkStack = new ItemStack(Items.MILK_BUCKET);
        ItemStack iceStack = new ItemStack(Blocks.ICE);
        ItemStack wheatStack = new ItemStack(Blocks.WHEAT);
        GameRegistry.addShapelessRecipe(
                new ItemStack(Items.DIAMOND, 1),
                        cocoaStack,
                        eggStack,
                        milkStack,
                        iceStack,
                        wheatStack);

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        System.out.println("DIRT " +
                "BLOCK >> " + Blocks.DIRT.getUnlocalizedName());

        proxy.registerRenderers();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){

    }
}
