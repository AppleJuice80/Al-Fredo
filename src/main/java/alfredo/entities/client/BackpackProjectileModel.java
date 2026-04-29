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
	public static final EntityModelLayer BACKPACK = new EntityModelLayer(Identifier.of(AlFredo.MOD_ID, "backpack"), "main");
	private final ModelPart backpack;

	public BackpackProjectileModel(ModelPart root) {
		super(root);
		this.backpack = root.getChild("backpack");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("backpack", ModelPartBuilder.create().uv(0, 0).cuboid("whole thing", -6.5f, -7f, 0f, 13f, 14f, 0.0f, new Dilation(32.0f)), ModelTransform.NONE);
		
		return TexturedModelData.of(modelData, 13, 14);// width, height
	}
}