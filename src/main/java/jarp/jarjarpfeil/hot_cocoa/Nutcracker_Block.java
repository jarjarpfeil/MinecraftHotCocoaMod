package jarp.jarjarpfeil.hot_cocoa;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class Nutcracker_Block extends Block{
	
	public Nutcracker_Block(Properties properties) {
		super(properties);
	}
	
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		System.out.println("HELLO");
		ItemStack itemstack = player.getHeldItem(handIn);
		if (itemstack.getItem() == Items.COCOA_BEANS) {
			if (!player.abilities.isCreativeMode) {
				itemstack.shrink(1);
			}
			System.out.println("HELLO2");
			double d0 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.15F;
	        double d1 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.060000002F + 0.6D;
	        double d2 = (double)(worldIn.rand.nextFloat() * 0.7F) + (double)0.15F;
			ItemEntity itementity = new ItemEntity(worldIn, (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, new ItemStack(hot_cocoa.groundCocoa.get()));
			System.out.println("HELLO3");
			itementity.setDefaultPickupDelay();
			worldIn.addEntity(itementity);
			System.out.println("HELLO4");
		}
		
		return ActionResultType.SUCCESS;
	}
}