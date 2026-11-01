package alfredo.blocks.entity;

import alfredo.AlFredo;
import alfredo.blocks.ModBlocks;
import alfredo.blocks.entity.custom.PlantBombBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
	public static final BlockEntityType<PlantBombBlockEntity> PLANTBOMB_BE = Registry
			.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(AlFredo.MOD_ID, "plantbomb_be"),
					FabricBlockEntityTypeBuilder.create(PlantBombBlockEntity::new, ModBlocks.PLANT_BOMB).build());

	public static void registerBlockEntities() {
        AlFredo.LOGGER.info("Registering Block Entities for " + AlFredo.MOD_ID);
    }
}
