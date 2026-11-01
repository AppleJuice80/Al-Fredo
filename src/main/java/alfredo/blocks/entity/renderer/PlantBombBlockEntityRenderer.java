package alfredo.blocks.entity.renderer;

import org.jetbrains.annotations.Nullable;

import alfredo.blocks.entity.custom.PlantBombBlockEntity;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class PlantBombBlockEntityRenderer implements BlockEntityRenderer<PlantBombBlockEntity, PlantBombBlockEntityRenderState> {
	@SuppressWarnings("unused")
	private final ItemModelManager itemModelManager;
	
	public PlantBombBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
		itemModelManager = context.itemModelManager();
	}
	
	
	@Override
	public PlantBombBlockEntityRenderState createRenderState() {
		return new PlantBombBlockEntityRenderState();
	}

	@Override
	public void render(PlantBombBlockEntityRenderState render_state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState camera_state) {
		matrices.push();
		matrices.translate(0.5f, 1.15f, 0.5f);
		matrices.scale(0.5f, 0.5f, 0.5f);
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0));
		
		render_state.itemRenderState.render(matrices, queue,
				GetLightLevel(render_state.blockEntityWorld, render_state.pos), OverlayTexture.DEFAULT_UV, 0);
		matrices.pop();
	}
	private int GetLightLevel(World world, BlockPos pos) {
		int blight = world.getLightLevel(LightType.BLOCK, pos);
		int slight = world.getLightLevel(LightType.SKY, pos);
		return LightmapTextureManager.pack(blight, slight);
	}
	
	@Override
	public void updateRenderState(PlantBombBlockEntity block_entity, PlantBombBlockEntityRenderState state,
			float tick_progress, Vec3d camera_pos,
			@Nullable ModelCommandRenderer.CrumblingOverlayCommand crumbling_overlay) {
		BlockEntityRenderer.super.updateRenderState(block_entity, state, tick_progress, camera_pos, crumbling_overlay);

		state.lightPosition = block_entity.getPos();
		state.blockEntityWorld = block_entity.getWorld();
		
		//itemModelManager.clearAndUpdate(state.itemRenderState, null, ItemDisplayContext.FIXED,
		//		block_entity.getWorld(), null, 0);
	}
}