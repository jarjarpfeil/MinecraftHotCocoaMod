package jarp.jarjarpfeil.hot_cocoa;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class Hot_Cocoa_Drink extends Item {
	public Hot_Cocoa_Drink(Item.Properties properties) {
		super(properties);
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
	      if (playerentity instanceof ServerPlayerEntity) {
	         CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
	      }

	      if (!worldIn.isRemote) {
	         entityLiving.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 200, 5));
	         entityLiving.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200, 5));
	         entityLiving.addPotionEffect(new EffectInstance(Effects.SATURATION, 200, 5));
	         entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200, 5));
	         entityLiving.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 3000, 5));
	      }

	      if (playerentity != null) {
	         playerentity.addStat(Stats.ITEM_USED.get(this));
	         if (!playerentity.abilities.isCreativeMode) {
	            stack.shrink(1);
	         }
	      }

	      if (playerentity == null || !playerentity.abilities.isCreativeMode) {
	         if (stack.isEmpty()) {
	            return new ItemStack(Items.GLASS_BOTTLE);
	         }

	         if (playerentity != null) {
	            playerentity.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
	         }
	      }

	      return stack;
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
