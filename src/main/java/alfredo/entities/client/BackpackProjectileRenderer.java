package alfredo.entities.client;

import alfredo.AlFredo;
import alfredo.entities.custom.BackpackProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;

public class BackpackProjectileRenderer
		extends EntityRenderer<BackpackProjectileEntity, ProjectileEntityRenderState> {
	protected BackpackProjectileModel model;
	
	public BackpackProjectileRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new BackpackProjectileModel(ctx.getPart(BackpackProjectileModel.BACKPACK));
	}

	@Override
	public ProjectileEntityRenderState createRenderState() {
		return new ProjectileEntityRenderState();
	}

	@Override
	public void render(ProjectileEntityRenderState render_state, MatrixStack matrices, OrderedRenderCommandQueue queue,
			CameraRenderState camera_state) {
		matrices.push();

		matrices.translate(0.0F, 0.15F, 0.0F);
		//matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(render_state.yaw - 90.0F));
		//matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(render_state.pitch));
		matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180f));
		matrices.multiply(camera_state.orientation);

		queue.submitModel(this.model, render_state, matrices,
				this.model.getLayer(Identifier.of(AlFredo.MOD_ID, "textures/entity/backpack/backpack.png")),
				render_state.light, OverlayTexture.DEFAULT_UV, render_state.outlineColor, null);

		matrices.pop();
		super.render(render_state, matrices, queue, camera_state);
	}
	
	@Override
	public void updateRenderState(BackpackProjectileEntity entity, ProjectileEntityRenderState render_state, float f) {
		super.updateRenderState(entity, render_state, f);
		render_state.pitch = entity.getLerpedPitch(f) + 60f;
		render_state.yaw = entity.getLerpedYaw(f);
	}
}