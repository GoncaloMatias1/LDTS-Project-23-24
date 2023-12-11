package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Projectile {
    private Position position;
    private final int speed = 1; // Determines how many spaces the projectile moves per update

    public Projectile(int x, int y) {
        this.position = new Position(x, y);
    }

    public void update() {
        position.setY(position.getY() - speed); // Moves the projectile up by reducing the Y coordinate
    }

    public Position getPosition() {
        return position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), '|'); //projectile character
    }

    public boolean checkCollision(Enemy enemy) {
        return position.equals(enemy.getPosition());
    }

    // Additional methods for drawing and collision detection might go here
}
