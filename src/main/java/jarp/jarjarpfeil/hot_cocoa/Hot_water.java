package jarp.jarjarpfeil.hot_cocoa;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Hot_water extends Item {
	Item.Properties builder;
	public Hot_water(Item.Properties properties) {
		super(properties);
		builder = properties;
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PotionItem PI = new PotionItem(builder);
		entityLiving.onKillCommand();
	    return PI.onItemUseFinish(stack, worldIn, entityLiving);
	}
	public int getUseDuration(ItemStack stack) {
		return 32;
	}
	
	public UseAction getUseAction(ItemStack stack) {
	      return UseAction.DRINK;
	}
	
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
	      return DrinkHelper.startDrinking(worldIn, playerIn, handIn);
	}
}
