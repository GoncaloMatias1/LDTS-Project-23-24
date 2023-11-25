package com.goncalomatias1.l05gr06.Objects;

import com.goncalomatias1.l05gr06.Objects.Characteristics.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayerShip extends Entity{
    //TODO era uma classe sem super classe antes, por mudar para extender Entity direito
    private final TextCharacter shipCharacter;

    public PlayerShip(int startX, int startY) {
        this.position = new Position(startX, startY);
        this.shipCharacter = new TextCharacter('^', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), shipCharacter);
    }

    public void moveLeft() {
        position.setX(position.getX() - 1);
    }

    public void moveRight() {
        position.setX(position.getX() + 1);
    }

}
