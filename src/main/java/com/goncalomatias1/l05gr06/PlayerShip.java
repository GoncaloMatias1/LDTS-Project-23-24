package com.goncalomatias1.l05gr06;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayerShip {
    private Position position;
    private final TextCharacter shipCharacter;
    private final int minX; // Left boundary
    private final int maxX; // Right boundary

    public PlayerShip(int startX, int startY, int screenWidth) {
        this.position = new Position(startX, startY);
        this.shipCharacter = new TextCharacter('^', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
        this.minX = 1; // Assuming the border is 1 character thick
        this.maxX = screenWidth - 2; // Adjusted for 1 character thick border
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), shipCharacter);
    }

    public void moveLeft() {
        if (position.getX() > minX) { // Check if it's not at the left edge
            position.setX(position.getX() - 1);
        }
    }

    public void moveRight() {
        if (position.getX() < maxX) { // Check if it's not at the right edge
            position.setX(position.getX() + 1);
        }
    }

    // Add getters and setters for position if needed
}
