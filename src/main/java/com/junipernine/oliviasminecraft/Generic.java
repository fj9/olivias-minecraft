package com.junipernine.oliviasminecraft;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import com.junipernine.oliviasminecraft.items.GenericItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;


@Mod(modid = "Generic", name = "Generic", version = "0.0.0")
//@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = { "GenericRandom" }, packetHandler = PacketHandler.class)
public class Generic {

    // Begin Basic Items
    public final static Item genericItem = new GenericItem(5000);
    public final static Item genericIngot = new GenericItem(5001)

    .setMaxStackSize(16)
//            .setIconIndex(1)
//            .setItemName("specificItem");
    // End Basic Items

    // Begin Basic Blocks
    public final static Block genericDirt = new GenericBlock(
            Material.GROUND).setHardness(0.5F)
//            .setStepSound(Block.soundGravelFootstep)
//            .setBlockName("genericDirt").setCreativeTab(CreativeTabs.tabBlock);
    public final static Block genericOre = new GenericOre(501, 1);
    // End Basic Blocks

    // Begin Damage Values and Metadata
    public static final int multiBlockId = 502;
    public static final Block multiBlock = new MultiBlock(multiBlockId);

    private static final String[] multiBlockNames = { "White Block",
            "Orange Block", "Magenta Block", "Light Blue Block",
            "Yellow Block", "Light Green Block", "Pink Block",
            "Dark Grey Block", "Light Grey Block", "Cyan Block",
            "Purple Block", "Blue Block", "Brown Block", "Green Block",
            "Red Block", "Black Block" };
    // End Damage Values and Metadata

    // Begin Packet Handling
    public static final Block randomBlock = new RandomBlock(503, 2);
    // End Packet Handling

    // Begin Plant
    public static final Block tomatoCrop = new TomatoCrop(504);
    public static final ItemSeeds tomatoSeeds = (ItemSeeds) new ItemSeeds(5002,
            tomatoCrop.blockID, Block.tilledField.blockID).setIconIndex(2)
            .setTextureFile(CommonProxy.ITEMS_PNG);
    public static final Item tomatoFruit = new GenericItem(5003)
            .setIconIndex(3);
    // End Plant

    // The instance of your mod that Forge uses.
    @Mod.Instance("Generic")
    public static Generic instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "tutorial.generic.client.ClientProxy", serverSide = "tutorial.generic.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        // Stub Method
    }

    @Mod.EventHandler
    public void load (FMLInitializationEvent event) {
        proxy.registerRenderers();

        initCraftingAndSmelting();
        initBasicItems();
        initBasicBlocks();
        initDamageValuesAndMetadata();
        initPacketHandling();
        initPlants();
        initWorldGen();
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event) {
        // Stub Method
    }

    private void initCraftingAndSmelting () {
        ItemStack dirtStack = new ItemStack(Blocks.DIRT);
        ItemStack diamondsStack = new ItemStack(Items.DIAMOND, 64);
        ItemStack blackWoolStack = new ItemStack(Blocks.WOOL, 42, 15);
        ItemStack gravelStack = new ItemStack(Blocks.GRAVEL);
        ItemStack cobbleStack = new ItemStack(Blocks.COBBLESTONE);

        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);

        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack, dirtStack,
                dirtStack, dirtStack, dirtStack, dirtStack, new ItemStack(
                        Blocks.SAND), gravelStack, cobbleStack);

        GameRegistry.addRecipe(new ItemStack(Blocks.COBBLESTONE), "xy", "yx",
                'x', dirtStack, 'y', gravelStack);

        GameRegistry.addRecipe(new ItemStack(Blocks.STONE), "xyx", "y y", "xyx",
                'x', dirtStack, 'y', gravelStack);
    }

    private void initBasicItems () {
        LanguageRegistry.addName(genericItem, "Generic Item");
        LanguageRegistry.addName(genericIngot, "Specific Item");
    }

    private void initBasicBlocks () {
        GameRegistry.registerBlock(genericDirt, "genericDirt");
        LanguageRegistry.addName(genericDirt, "Generic Dirt");
        MinecraftForge.setBlockHarvestLevel(genericDirt, "shovel", 0);

        GameRegistry.registerBlock(genericOre, "genericOre");
        LanguageRegistry.addName(genericOre, "Genreric Ore");
        MinecraftForge.setBlockHarvestLevel(genericOre, "pickaxe", 3);
    }

    private void initDamageValuesAndMetadata () {
        GameRegistry.registerBlock(multiBlock, MultiItemBlock.class);

        for (int ix = 0; ix < 16; ix++) {
            ItemStack cloth = new ItemStack(Block.cloth, 1, ix);
            ItemStack multiBlockStack = new ItemStack(multiBlock, 1, ix);

            GameRegistry.addShapelessRecipe(multiBlockStack, cloth, cloth);
            LanguageRegistry.addName(multiBlockStack,
                    multiBlockNames[multiBlockStack.getItemDamage()]);
        }
    }

    private void initPacketHandling () {
        GameRegistry.registerBlock(randomBlock, "randomBlock");
        LanguageRegistry.addName(randomBlock, "Random Block");
    }

    private void initPlants () {
        LanguageRegistry.addName(tomatoSeeds, "Tomato Seeds");
        MinecraftForge.addGrassSeed(new ItemStack(tomatoSeeds), 10);

        LanguageRegistry.addName(tomatoFruit, "Tomato");
        GameRegistry.addShapelessRecipe(new ItemStack(tomatoSeeds, 4),
                new ItemStack(tomatoFruit));

        GameRegistry.registerBlock(tomatoCrop, "tomatoCrop");
    }
    
    private void initWorldGen () {
        GameRegistry.registerWorldGenerator(new BasicWorldGen());
    }
}
