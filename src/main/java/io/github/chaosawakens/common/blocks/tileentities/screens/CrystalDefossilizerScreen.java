package io.github.chaosawakens.common.blocks.tileentities.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import io.github.chaosawakens.ChaosAwakens;
import io.github.chaosawakens.common.blocks.tileentities.containers.CrystalDefossilizerContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class CrystalDefossilizerScreen extends ContainerScreen<CrystalDefossilizerContainer> {
	public static final ResourceLocation TEXTURE = ChaosAwakens.prefix("textures/gui/container/defossilizer.png");

	public CrystalDefossilizerScreen(CrystalDefossilizerContainer container, PlayerInventory playerInventory, ITextComponent title) {
		super(container, playerInventory, title);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		if (minecraft == null) return;

		RenderSystem.clearColor(1, 1, 1, 1);
		minecraft.getTextureManager().bind(TEXTURE);

		int posX = (this.width - this.imageWidth) / 2;
		int posY = (this.height - this.imageHeight) / 2;
		blit(matrixStack, posX, posY, 0, 0, this.imageWidth, this.imageHeight);

		// Progress arrow
		blit(matrixStack, posX + 79, posY + 35, 176, 14, menu.getProgressArrowScale() + 1, 16);
    }
}
