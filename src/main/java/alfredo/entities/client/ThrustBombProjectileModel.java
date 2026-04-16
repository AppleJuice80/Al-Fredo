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
		model_part_data.addChild("thrust_bomb", ModelPartBuilder.create().cuboid("whole thing", -5f, -6f, 0f, 10f, 12f, 0f, new Dilation(1.0f)),
				ModelTransform.NONE);//of(0.0f, 16.5f, 0.0f, 0.0f, 0.0f, 0.0f));
	
		/*ModelPartData cube_r1 = *///thrust_bomb.addChild("body",
				//ModelPartBuilder.create().uv(0, 0).cuboid(3f, 5f, 0f, 10.0f, 9.0f, 0.0f, new Dilation(1.0f)),
				//ModelTransform.NONE);//of(0.0f, -7.0f, -4.0f, 0.0f, -1.5708f, 0.0f));
	
		/*ModelPartData cube_r2 = *///thrust_bomb.addChild("fuse",
				//ModelPartBuilder.create().uv(0, 0).cuboid(8.0f, 2.0f, 0.0f, 3.0f, 3.0f, 0.0f, new Dilation(1.0f)),
				//ModelTransform.NONE);//of(0.0f, -7.0f, -5.0f, 0.0f, -1.5708f, 0.0f));
	
		
		return TexturedModelData.of(model_data, 10, 12);// width, height
	}
}