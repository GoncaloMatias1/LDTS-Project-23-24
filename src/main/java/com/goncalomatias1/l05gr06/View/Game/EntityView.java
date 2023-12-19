package com.goncalomatias1.l05gr06.View.Game;

import com.goncalomatias1.l05gr06.Model.Game.EntityModel;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class EntityView {
    protected EntityModel model;

    public EntityView(EntityModel model) {
        this.model = model;
    }

    public abstract void draw(TextGraphics graphics);
}

