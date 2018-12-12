package cz.mstein.minecraft.uwm.items;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestingWand extends UWMItem {
	public TestingWand() {
		super("testing_wand");
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote && !player.isSneaking()) {
			world.destroyBlock(pos, false);
			return EnumActionResult.SUCCESS;
		} else if(world.isRemote && player.isSneaking()) {
			player.displayGui(new BlockWorkbench.InterfaceCraftingTable(world, pos));
		}
		return EnumActionResult.PASS;
	}
}