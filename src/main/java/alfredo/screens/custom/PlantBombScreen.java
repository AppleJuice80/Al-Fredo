package alfredo.screens.custom;

import alfredo.AlFredo;
import net.minecraft.client.gl.RenderPipelines;
//import com.mojang.blaze3d.pipeline.RenderPipeline;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PlantBombScreen extends HandledScreen<PlantBombScreenHandler> {
	public static final Identifier GUI_TEXTURE = Identifier.of(AlFredo.MOD_ID,
			"textures/gui/plant_bomb/plant_bomb_gui.png");
	private TextFieldWidget text_field;

	public PlantBombScreen(PlantBombScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
		this.text_field = new TextFieldWidget(
			this.textRenderer, 
			184,				// X position
			57,					// Y position
			110,				// Width
			15,					// Height
			Text.literal("")	// Placeholder/label text
		);
		this.addDrawableChild(this.text_field);
		AlFredo.LOGGER.info("AAAAAAAAAAAAAAAAAAAAAAWidth: " + width + "; Height: " + height);
	}

	@Override
	protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;
		AlFredo.LOGGER.info("BBBBBBBBBBBBBBBBBBBBBBWidth: " + width + "; Height: " + height);

		context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0f, 0f, backgroundWidth, backgroundHeight,
				backgroundWidth, backgroundHeight);// 300, 283// 256, 256
	}
}