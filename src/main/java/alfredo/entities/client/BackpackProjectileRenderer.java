package alfredo.entities.client;

import alfredo.AlFredo;
import alfredo.entities.custom.BackpackProjectileEntity;

import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.util.Identifier;


public class BackpackProjectileRenderer
		extends EntityRenderer<BackpackProjectileEntity, ProjectileEntityRenderState> {
	protected BackpackProjectileModel model;
	
	public BackpackProjectileRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new BackpackProjectileModel(ctx.getPart(BackpackProjectileModel.BACKPACK));
	}

	@Override
	public ProjectileEntityRenderState createRenderState() {
		return null;
	}

	//@Override
	public void render(BackpackProjectileEntity entity, float yaw, float tick_delta, MatrixStack matrices,
			VertexConsumerProvider vertex_consumers, int light) {
		matrices.push();

		VertexConsumer vertex_consumer = ItemRenderer.getItemGlintConsumer(vertex_consumers,
				this.model.getLayer(Identifier.of(AlFredo.MOD_ID, "textures/entity/backpack/backpack.png")),
				false, false);
		this.model.render(matrices, vertex_consumer, light, OverlayTexture.DEFAULT_UV);

		matrices.pop();
		//super.render(entity, yaw, tick_delta, matrices, vertex_consumers, light);
		//super.render(this.createRenderState(), matrices, vertex_consumers, light);
	}
	
	//@Override
	public Identifier getTexture(BackpackProjectileEntity entity) {
		return Identifier.of(AlFredo.MOD_ID, "textures/entity/backpack/backpack.png");
	}

	//@Override
	public Identifier getTexture(ProjectileEntityRenderState render_state) {
		return Identifier.of(AlFredo.MOD_ID, "textures/entity/backpack/backpack.png");
	}
}
