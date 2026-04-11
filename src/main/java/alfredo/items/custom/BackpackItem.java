package alfredo.items.custom;

import alfredo.entities.custom.BackpackProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class BackpackItem extends Item {
	public BackpackItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		ItemStack item_stack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW,
				SoundCategory.NEUTRAL, 0.57f, 0.2f);
		if (!world.isClient()) {
			BackpackProjectileEntity backpack = new BackpackProjectileEntity(world, user);
			backpack.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0f);
			world.spawnEntity(backpack);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			item_stack.decrement(1);
		}

		return ActionResult.SUCCESS;
	}
}