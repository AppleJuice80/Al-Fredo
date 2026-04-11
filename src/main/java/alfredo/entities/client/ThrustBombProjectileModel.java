package alfredo.entities.client;

import alfredo.AlFredo;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.util.Identifier;

public class ThrustBombProjectileModel extends EntityModel<ProjectileEntityRenderState> {
	public static final EntityModelLayer THRUST_BOMB = new EntityModelLayer(Identifier.of(AlFredo.MOD_ID, "thrust_bomb"), "main");
	private final ModelPart thrust_bomb;

	public ThrustBombProjectileModel(ModelPart root) {
		super(root);
		this.thrust_bomb = root.getChild("thrust_bomb");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData model_data = new ModelData();
		ModelPartData model_part_data = model_data.getRoot();
		ModelPartData thrust_bomb = model_part_data.addChild("thrust_bomb", ModelPartBuilder.create(),
				ModelTransform.of(0.0f, 16.5f, 0.0f, 0.0f, 0.0f, 0.0f));
	
		/*ModelPartData cube_r1 = */thrust_bomb.addChild("cube_r1",
				ModelPartBuilder.create().uv(8, 7).cuboid(1.5f, 2.5f, -0.5f, 1.0f, 1.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -7.0f, -4.0f, 0.0f, -1.5708f, 0.0f));
	
		/*ModelPartData cube_r2 = */thrust_bomb.addChild("cube_r2",
				ModelPartBuilder.create().uv(7, 9).cuboid(0.5f, -1.5f, -0.5f, 2.0f, 5.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -7.0f, -5.0f, 0.0f, -1.5708f, 0.0f));
	
		/*ModelPartData cube_r3 = */thrust_bomb.addChild("cube_r3",
				ModelPartBuilder.create().uv(3, 10).cuboid(-2.5f, -1.5f, -0.5f, 1.0f, 4.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -7.0f, -5.0f, 0.0f, -1.5708f, 0.0f));
	
		/*ModelPartData cube_r4 = */thrust_bomb.addChild("cube_r4",
				ModelPartBuilder.create().uv(1, 4).cuboid(-2.5f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -7.0f, -0.0f, 0.0f, -1.5708f, 0.0f));
	
		/*ModelPartData cube_r5 = */thrust_bomb.addChild("cube_r5",
				ModelPartBuilder.create().uv(18, 1).cuboid(-0.5f, -0.5f, -0.5f, 1.0f, 18.0f, 1.0f, new Dilation(0.0f)),
				ModelTransform.of(0.0f, -1.5f, -0.0f, 0.0f, -0.7854f, 0.0f));
		
		return TexturedModelData.of(model_data, 16, 16);
	}
}