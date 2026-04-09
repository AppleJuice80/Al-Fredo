package alfredo.entities.custom;

//import alfredo.items.ModItems;
import alfredo.entities.ModEntities;

//import net.minecraft.item.ItemStack;

import net.minecraft.util.hit.HitResult;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.hit.EntityHitResult;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;

import net.minecraft.world.World;
//import net.minecraft.world.explosion.Explosion;

public class ThrustBombProjectileEntity extends ExplosiveProjectileEntity {
	//private float rotation;
	private World world;

	public ThrustBombProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> entity_type, World world) {
		super(entity_type, world);
		this.world = world;
	}
	
	public ThrustBombProjectileEntity(World world, PlayerEntity player) {
		//super(ModEntities.THRUST_BOMB, player, world, new ItemStack(ModItems.THRUST_BOMB), null);
		super(ModEntities.THRUST_BOMB, player, player.getVelocity(), world);
		this.world = world;
	}
	
	@Override
	protected void onCollision(HitResult result) {
		super.onCollision(result);
	
		
		if (!this.world.isClient()) {
			this.world.sendEntityStatus(this, (byte)3);
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 3.0f, true, World.ExplosionSourceType.TNT);
			this.discard();
		}
		
	}
}
