package alfredo.entities.client;

import alfredo.AlFredo;
import alfredo.entities.custom.ThrustBombProjectileEntity;

import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
//import net.minecraft.client.render.command.OrderedRenderCommandQueue;
//import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.util.Identifier;


public class ThrustBombProjectileRenderer
        extends EntityRenderer<ThrustBombProjectileEntity, ProjectileEntityRenderState> {
    protected ThrustBombProjectileModel model;
    
    public ThrustBombProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new ThrustBombProjectileModel(ctx.getPart(ThrustBombProjectileModel.THRUST_BOMB));
    }

    @Override
    public ProjectileEntityRenderState createRenderState() {
        return null;
    }
    
    //@Override
    public void render(ThrustBombProjectileEntity entity, float yaw, float tick_delta, MatrixStack matrices,
            VertexConsumerProvider vertex_consumers, int light) {
        matrices.push();
    
        VertexConsumer vertex_consumer = ItemRenderer.getItemGlintConsumer(vertex_consumers,
                this.model.getLayer(Identifier.of(AlFredo.MOD_ID, "textures/entity/thrust_bomb/thrust_bomb.png")),
                false, false);
        this.model.render(matrices, vertex_consumer, light, OverlayTexture.DEFAULT_UV);
    
        matrices.pop();
        //super.render(entity, yaw, tick_delta, matrices, vertex_consumers, light);
        //super.render(this.createRenderState(), matrices, queue, new CameraRenderState());
        super.updateRenderState(entity, this.createRenderState(), tick_delta);
    }
    

    
    /*
    @Override
    public void render(ProjectileEntityRenderState render_state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState camera_state) {
        matrices.push();

        VertexConsumer vertex_consumer = ItemRenderer.getItemGlintConsumer(vertex_consumers,
                this.model.getLayer(Identifier.of(AlFredo.MOD_ID, "textures/entity/thrust_bomb/thrust_bomb.png")),
                false, false);
        this.model.render(matrices, vertex_consumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        //super.render(entity, yaw, tick_delta, matrices, vertex_consumers, light);
        //super.render(this.createRenderState(), matrices, vertex_consumers, light);
    }
    */


    
    //@Override
    public Identifier getTexture(ThrustBombProjectileEntity entity) {
        return Identifier.of(AlFredo.MOD_ID, "textures/entity/thrust_bomb/thrust_bomb.png");
    }

    //@Override
    public Identifier getTexture(ProjectileEntityRenderState render_state) {
        //if (Identifier.of(AlFredo.MOD_ID, "textures/entity/thrust_bomb/thrust_bomb.png") == null)
        //    return Identifier.of(AlFredo.MOD_ID, "thrust_bomb");
        return Identifier.of(AlFredo.MOD_ID, "textures/entity/thrust_bomb/thrust_bomb.png");
    }
}
