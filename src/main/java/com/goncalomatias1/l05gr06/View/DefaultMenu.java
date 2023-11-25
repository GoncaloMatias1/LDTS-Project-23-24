package com.goncalomatias1.l05gr06.View;

import com.goncalomatias1.l05gr06.Objects.Characteristics.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class DefaultMenu {
    protected final int width;
    protected final int height;
    protected Position selectorPos;

    public Position getSelectorPos() { return selectorPos; }
    public void setSelectorPos(int x, int y) { selectorPos.setX(x); selectorPos.setY(y); }

    public DefaultMenu(int width, int height){
        this.width = width;
        this.height = height;
        selectorPos = new Position(width/2-6,height/2);
    }

    public void draw(TextGraphics graphics) {}

    public void update(int updateInfo) {}
}
