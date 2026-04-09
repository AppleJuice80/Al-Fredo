package alfredo.entities.custom;

import alfredo.entities.ModEntities;
//import alfredo.items.ModItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;

//import net.minecraft.item.ItemStack;

//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
//import net.minecraft.world.explosion.Explosion;

public class BackpackProjectileEntity extends ExplosiveProjectileEntity {
	private World world;


    public BackpackProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> entity_type, World world) {
        super(entity_type, world);
		this.world = world;
    }
    
    public BackpackProjectileEntity(World world, PlayerEntity player) {
        //super(ModEntities.BACKPACK, player, world, new ItemStack(ModItems.BACKPACK), null);
        super(ModEntities.BACKPACK, player, player.getVelocity(), world);
		this.world = world;
    }
    
	@Override
	protected void onCollision(HitResult result) {
		super.onCollision(result);
	
		
		if (!this.world.isClient()) {
			this.world.sendEntityStatus(this, (byte)3);
			this.world.createExplosion(this, this.getX(), this.getY(), this.getZ(), 9.0f, true, World.ExplosionSourceType.TNT);
			this.discard();
		}
		
	}
}
