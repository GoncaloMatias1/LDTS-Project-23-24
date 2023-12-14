package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Model.Game.Projectile;
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
        currentPosition.setY(currentPosition.getY() + 1);
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

    public Projectile shoot() {
        // Assuming the projectile spawns under the enemy
        return new Projectile(getPosition().getX(), getPosition().getY() + 1);
    }
}
