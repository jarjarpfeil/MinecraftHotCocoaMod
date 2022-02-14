package jarp.jarjarpfeil.hot_cocoa;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("hot_cocoa")
public class hot_cocoa {
	public static final String MODID = "hot_cocoa";
	public static final String VERSION = "1.0";
	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	public static final RegistryObject<Item> groundCocoa = ITEMS.register("ground_cocoa", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> hotcocoamix = ITEMS.register("hot_cocoa_mix", () -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> HOTCOCOA = ITEMS.register("hot_cocoa_bottle", () -> new Hot_Cocoa_Drink(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
	public static final RegistryObject<Item> HOTWATERBOTTLE = ITEMS.register("hot_water_bottle", () -> new Hot_water(new Item.Properties().group(ItemGroup.BREWING).maxStackSize(1)));
	public static final RegistryObject<Block> Nutcrackerblock = BLOCKS.register("nutcracker_block", () -> new Nutcracker_Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(1.0F, 1.0F)));
	public static final RegistryObject<Item> Nutcrackerblock_Item = ITEMS.register("nutcracker_block", () -> new BlockItem(Nutcrackerblock.get(), new Item.Properties().group(ItemGroup.MISC)));
	
	public hot_cocoa(){
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		System.out.println("HELLO");
	}	
}