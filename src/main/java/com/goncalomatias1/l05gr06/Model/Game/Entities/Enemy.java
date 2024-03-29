package com.goncalomatias1.l05gr06.Model.Game.Entities;

import com.goncalomatias1.l05gr06.Model.Game.EntityModel;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.goncalomatias1.l05gr06.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Enemy extends EntityModel {
    private int pointsAward;
    public Enemy(int startX, int startY, int initialLives, int pointsAward){
        super(new Position(startX, startY), initialLives, true);
        this.pointsAward = pointsAward;
    }

    public void moveLeft() {
        Position currentPosition = getPosition();
        currentPosition.setX(currentPosition.getX() - 1);
    }

    public void moveRight() {
        Position currentPosition = getPosition();
        currentPosition.setX(currentPosition.getX() + 1);
    }

    public void moveDown() {
        Position currentPosition = getPosition();
        currentPosition.setY(currentPosition.getY() + 1);
    }

    public void draw(TextGraphics graphics) {
        if (pointsAward == 50){
            graphics.setForegroundColor(TextColor.ANSI.RED);
            graphics.setCharacter(position.getX(), position.getY(), 'M');
        }
        else {
            graphics.setForegroundColor(TextColor.ANSI.YELLOW);
            graphics.setCharacter(position.getX(), position.getY(), 'W');
        }

    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void hit() {
        lives--;
    }

    public Projectile shoot() {
        return new Projectile(getPosition().getX(), getPosition().getY() + 1);
    }
    public int getPointsAward(){
        return pointsAward;
    }

    public void turnToMisteryShip(){
        lives = 3;
        pointsAward = 50;
    }
}
