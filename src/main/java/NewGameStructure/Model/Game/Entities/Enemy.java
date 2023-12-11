package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Enemy extends EntityModel {
    public Enemy(int startX, int startY, int initialLives){
        super(new Position(startX, startY), initialLives, true);
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
        currentPosition.setX(currentPosition.getY() + 1);
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), 'W'); //projectile character
    }

    public boolean isAlive() {
        return lives > 0;
    }

    public void hit() {
        lives--;
    }

}
