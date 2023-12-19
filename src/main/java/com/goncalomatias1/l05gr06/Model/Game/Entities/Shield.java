package com.goncalomatias1.l05gr06.Model.Game.Entities;

import com.goncalomatias1.l05gr06.Model.Game.EntityModel;
import com.goncalomatias1.l05gr06.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shield extends EntityModel {
    private TextCharacter shieldCharacter;

    private static final TextColor[] LIFE_COLORS = {
            new TextColor.RGB(0, 102, 51), // Dark green, for 1 life
            new TextColor.RGB(0, 153, 0), // Medium green, for 2 lives
            new TextColor.RGB(0, 204, 0), // Light green, for 3 lives
            new TextColor.RGB(51, 255, 51),         // Bright green, for 4 lives
    };
    public Shield(Position position) {
        super(position, 4, false);
        updateShieldCharacter();
    }

    private void updateShieldCharacter() {
        int colorIndex = Math.max(0, lives - 1);
        shieldCharacter = new TextCharacter('#', LIFE_COLORS[colorIndex], TextColor.ANSI.BLACK);
    }
    public void draw(TextGraphics graphics) {
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), shieldCharacter);
    }

    public void takeDamage() {
        if (this.lives > 0) {
            this.lives--;
            updateShieldCharacter();
        }
    }

    public boolean isAlive() {
        return this.lives > 0;
    }

    public TextCharacter getShieldCharacter() {
        return shieldCharacter;
    }


}
