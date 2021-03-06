package dev.the_fireplace.overlord.api.client;

import dev.the_fireplace.overlord.api.entity.OrderableEntity;
import dev.the_fireplace.overlord.client.gui.SkeletonOrdersGuiFactory;
import net.minecraft.client.gui.screen.Screen;

public interface OrdersGuiFactory {
    static OrdersGuiFactory getInstance() {
        //noinspection deprecation
        return SkeletonOrdersGuiFactory.INSTANCE;
    }

    Screen build(Screen parent, OrderableEntity aiEntity);
}
