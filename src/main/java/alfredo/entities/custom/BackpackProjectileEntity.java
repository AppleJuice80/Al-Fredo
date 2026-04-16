package alfredo.entities.custom;

import alfredo.entities.ModEntities;
import alfredo.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class BackpackProjectileEntity extends ThrownItemEntity {
	public BackpackProjectileEntity(EntityType<? extends ThrownItemEntity> entity_type, World world) {
        super(entity_type, world);
    }
    
    public BackpackProjectileEntity(World world, PlayerEntity player) {
		super(ModEntities.BACKPACK, player, world, new ItemStack(ModItems.BACKPACK));
    }
	
	@Override
	protected Item getDefaultItem() {
		return ModItems.BACKPACK;
	}
    
	@Override
	protected void onCollision(HitResult result) {
		super.onCollision(result);
		
		if (!this.getEntityWorld().isClient()) {
			this.getEntityWorld().sendEntityStatus(this, (byte)3);
			this.getEntityWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 7.5f, true, World.ExplosionSourceType.TNT);
			this.discard();
		}
	}
}