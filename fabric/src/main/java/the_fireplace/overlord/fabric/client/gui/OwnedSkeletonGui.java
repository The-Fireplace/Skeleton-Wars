package the_fireplace.overlord.fabric.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import the_fireplace.overlord.OverlordHelper;
import the_fireplace.overlord.fabric.entity.OwnedSkeletonContainer;
import the_fireplace.overlord.fabric.entity.OwnedSkeletonEntity;
import the_fireplace.overlord.fabric.entity.SkeletonInventory;

import java.util.Objects;

import static net.minecraft.client.gui.screen.ingame.InventoryScreen.drawEntity;

@Environment(EnvType.CLIENT)
public class OwnedSkeletonGui extends ContainerScreen<OwnedSkeletonContainer> {
    public static final Identifier BACKGROUND_TEXTURE = new Identifier(OverlordHelper.MODID, "textures/gui/skeleton_inventory.png");
    private int mouseX;
    private int mouseY;
    private boolean isMouseDown;
    private SkeletonInventory inv;
    private OwnedSkeletonEntity entity;
    public OwnedSkeletonGui(OwnedSkeletonEntity skeleton) {
        super(skeleton.getContainer(Objects.requireNonNull(MinecraftClient.getInstance().player).inventory), Objects.requireNonNull(MinecraftClient.getInstance().player).inventory, new TranslatableText("entity.overlord.owned_skeleton"));
        inv = skeleton.getInventory();
        entity = skeleton;
        containerHeight = 252;
    }

    @Override
    protected void drawBackground(float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        assert this.minecraft != null;
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int i = this.x;
        int j = this.y;
        this.blit(i, j, 0, 0, this.containerWidth, this.containerHeight);
        drawEntity(i + 51, j + 75, 30, (float)(i + 51) - this.mouseX, (float)(j + 75 - 50) - this.mouseY, entity);
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        this.renderBackground();
        super.render(mouseX, mouseY, delta);
        this.drawMouseoverTooltip(mouseX, mouseY);
        this.mouseX = mouseX;
        this.mouseY = mouseY;
    }
}