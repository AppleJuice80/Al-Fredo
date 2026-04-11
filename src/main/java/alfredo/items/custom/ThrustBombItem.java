package alfredo.items.custom;

import alfredo.AlFredo;
import alfredo.entities.custom.ThrustBombProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ThrustBombItem extends Item {
	public ThrustBombItem(Settings settings) {
		super(settings);
	}

	@Override
	public ActionResult use(World world, PlayerEntity user, Hand hand) {
		ItemStack item_stack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW,
				SoundCategory.NEUTRAL, 0.5f, 0.4f);
		if (!world.isClient()) {
			ThrustBombProjectileEntity thrust_bomb = new ThrustBombProjectileEntity(world, user);
			thrust_bomb.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 0f);
			world.spawnEntity(thrust_bomb);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			item_stack.decrement(1);
		}
		AlFredo.LOGGER.info("Yo someone used ts (ts = a Thrust Bomb).");
		return ActionResult.SUCCESS;
	}
}