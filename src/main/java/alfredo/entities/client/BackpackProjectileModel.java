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

public class BackpackProjectileModel extends EntityModel<ProjectileEntityRenderState> {
	public static final EntityModelLayer BACKPACK = new EntityModelLayer(Identifier.of(AlFredo.MOD_ID, "backpack"),
			"main");
	private final ModelPart backpack;

	public BackpackProjectileModel(ModelPart root) {
		super(root);
		this.backpack = root.getChild("backpack");
	}

	//public static TexturedModelData getTexturedModelData() {
	//	ModelData model_data = new ModelData();
	//	ModelPartData model_part_data = model_data.getRoot();
	//	ModelPartData backpack = model_part_data.addChild("backpack", ModelPartBuilder.create(),
	//			ModelTransform.of(0.0f, 16.5f, 0.0f, 0.0f, 0.0f, 0.0f));
	//
	//	/*ModelPartData cube_r1 = */backpack.addChild("cube_r1",
	//			ModelPartBuilder.create().uv(8, 7).cuboid(1.5f, 2.5f, -0.5f, 1.0f, 1.0f, 1.0f, new Dilation(0.0f)),
	//			ModelTransform.of(0.0f, -7.0f, -4.0f, 0.0f, -1.5708f, 0.0f));
	//
	//	/*ModelPartData cube_r2 = */backpack.addChild("cube_r2",
	//			ModelPartBuilder.create().uv(7, 9).cuboid(0.5f, -1.5f, -0.5f, 2.0f, 5.0f, 1.0f, new Dilation(0.0f)),
	//			ModelTransform.of(0.0f, -7.0f, -5.0f, 0.0f, -1.5708f, 0.0f));
	//
	//	/*ModelPartData cube_r3 = */backpack.addChild("cube_r3",
	//			ModelPartBuilder.create().uv(3, 10).cuboid(-2.5f, -1.5f, -0.5f, 1.0f, 4.0f, 1.0f, new Dilation(0.//0f)),
	//			ModelTransform.of(0.0f, -7.0f, -5.0f, 0.0f, -1.5708f, 0.0f));
	//
	//	/*ModelPartData cube_r4 = */backpack.addChild("cube_r4",
	//			ModelPartBuilder.create().uv(1, 4).cuboid(-2.5f, -1.5f, 0.0f, 5.0f, 3.0f, 0.0f, new Dilation(0.0f)),
	//			ModelTransform.of(0.0f, -7.0f, -0.0f, 0.0f, -1.5708f, 0.0f));
	//
	//	/*ModelPartData cube_r5 = */backpack.addChild("cube_r5",
	//			ModelPartBuilder.create().uv(18, 1).cuboid(-0.5f, -0.5f, -0.5f, 1.0f, 18.0f, 1.0f, new Dilation(0.//0f)),
	//			ModelTransform.of(0.0f, -1.5f, -0.0f, 0.0f, -0.7854f, 0.0f));
	//
	//	return TexturedModelData.of(model_data, 16, 16);
	//}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild(
			"backpack",
			ModelPartBuilder.create().uv(0, 0)
				.cuboid("whole thing", -6.5f, -7f, 0f, 13f, 14f, 0.0f, new Dilation(32.0f)),
				//.cuboid("lil top bit", 3.0F, 1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new Dilation(1.0f))
				//.cuboid("handle", 6.0F, 1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new Dilation(1.0f))
				//.cuboid("right strap top", 10.0F, 2.0F, 0.0F, 5.0F, 2.0F, 0.0F, new Dilation(1.0f))
				//.cuboid("right strap bottom", 13.0F, 4.0F, 0.0F, 2.0F, 8.0F, 0.0F, new Dilation(1.0f))
				//.cuboid("body left", 2.0F, 3.0F, 0.0F, 8.0F, 12.0F, 0.0F, new Dilation(1.0f))
				//.cuboid("body right", 10.0F, 4.0F, 0.0F, 3.0F, 12.0F, 0.0F, new Dilation(1.0f)),
				//.cuboid(0f, 0f, 0f, 12f, 13f, 0f),
			ModelTransform.NONE//origin(7, 8, 0)
		);
		return TexturedModelData.of(modelData, 13, 14);// width, height
	}
}