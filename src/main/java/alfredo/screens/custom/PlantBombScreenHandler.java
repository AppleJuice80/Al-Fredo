package alfredo.screens.custom;

import alfredo.screens.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class PlantBombScreenHandler extends ScreenHandler {
	private BlockPos pos;

	public PlantBombScreenHandler(int syncID, PlayerInventory inventory, BlockPos pos) {
		this(syncID, inventory.player.getEntityWorld().getBlockEntity(pos));
		this.pos = pos;
	}

	public PlantBombScreenHandler(int syncID, BlockEntity block_entity) {
		super(ModScreenHandlers.PLANTBOMB_SCREEN_HANDLER, syncID);
	}

	@Override
	public ItemStack quickMove(PlayerEntity player, int slot) {
		return null;
	}
	@Override
	public boolean canUse(PlayerEntity player) {
		if (Math.abs(pos.getX() - player.getX()) > 10) return false;
		if (Math.abs(pos.getY() - player.getY()) > 10) return false;
		if (Math.abs(pos.getZ() - player.getZ()) > 10) return false;

		return true;
	}
}
