package alfredo.entities;

import alfredo.AlFredo;
import alfredo.entities.custom.ThrustBombProjectileEntity;
import alfredo.entities.custom.BackpackProjectileEntity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import net.minecraft.util.Identifier;

public class ModEntities {
	public static final EntityType<ThrustBombProjectileEntity> THRUST_BOMB = registerThrustBombEntity("thrust_bomb");
	public static final EntityType<BackpackProjectileEntity> BACKPACK = registerBackpackEntity("backpack");

	
	private static EntityType<ThrustBombProjectileEntity> registerThrustBombEntity(String name) {
		Identifier id = Identifier.of(AlFredo.MOD_ID, name);
		RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);
		EntityType<ThrustBombProjectileEntity> entry = EntityType.Builder.<ThrustBombProjectileEntity>create(ThrustBombProjectileEntity::new, SpawnGroup.MISC).build(key);//before build, .dimensions(1.6f, 1.6f);
		
		return Registry.register(Registries.ENTITY_TYPE, id, entry);
	}
	
	private static EntityType<BackpackProjectileEntity> registerBackpackEntity(String name) {
		Identifier id = Identifier.of(AlFredo.MOD_ID, name);
		RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);
		EntityType<BackpackProjectileEntity> entry = EntityType.Builder.<BackpackProjectileEntity>create(BackpackProjectileEntity::new, SpawnGroup.MISC).build(key);// before build, .dimensions(1.6f, 1.6f)

		return Registry.register(Registries.ENTITY_TYPE, id, entry);
	}

	public static void registerModEntities() {
		AlFredo.LOGGER.info("Registering Mod Entities for " + AlFredo.MOD_ID);
	}
}