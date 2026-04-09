package alfredo;

//import alfredo.blocks.ModBlocks;
import alfredo.entities.ModEntities;
import alfredo.entities.client.ThrustBombProjectileModel;
import alfredo.entities.client.ThrustBombProjectileRenderer;
import alfredo.entities.client.BackpackProjectileModel;
import alfredo.entities.client.BackpackProjectileRenderer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactories;

public class AlFredoClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityModelLayerRegistry.registerModelLayer(ThrustBombProjectileModel.THRUST_BOMB,
				ThrustBombProjectileModel::getTexturedModelData);
		EntityRendererFactories.register(ModEntities.THRUST_BOMB, ThrustBombProjectileRenderer::new);

		EntityModelLayerRegistry.registerModelLayer(BackpackProjectileModel.BACKPACK,
				BackpackProjectileModel::getTexturedModelData);
		EntityRendererFactories.register(ModEntities.BACKPACK, BackpackProjectileRenderer::new);
	}
}
