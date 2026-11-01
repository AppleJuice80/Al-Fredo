package alfredo.screens.custom;

import alfredo.AlFredo;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PlantBombScreen extends HandledScreen<PlantBombScreenHandler> {
	public static final Identifier GUI_TEXTURE = Identifier.of(AlFredo.MOD_ID,
			"textures/gui/plant_bomb/plant_bomb_gui.png");
	private final TextFieldWidget min_field, sec_field;

	public PlantBombScreen(PlantBombScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
		this.min_field = new TextFieldWidget(
			this.textRenderer, 
			184,				// X position
			57,				// Y position
			15,			// Width
			15,			// Height
			Text.empty()		// Placeholder/label text
		);
		this.sec_field = new TextFieldWidget(textRenderer, 200, 57, 15, 15, Text.empty());
		this.addDrawableChild(this.min_field);
		this.addDrawableChild(this.sec_field);
	}

	@Override
	protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;

		context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0f, 0f, backgroundWidth, backgroundHeight,
				backgroundWidth, backgroundHeight);// 300, 283// 256, 256
	}
}