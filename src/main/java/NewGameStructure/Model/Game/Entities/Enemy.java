package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Model.Game.Projectile;
import NewGameStructure.Position;
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
        if (pointsAward == 30){
            graphics.setCharacter(position.getX(), position.getY(), 'M');
        }
        else graphics.setCharacter(position.getX(), position.getY(), 'W');

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
