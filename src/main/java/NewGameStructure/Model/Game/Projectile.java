package NewGameStructure.Model.Game;

import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import NewGameStructure.Position;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Projectile {
    private Position position;
    private final int speed = 1;

    public Projectile(int x, int y) {
        this.position = new Position(x, y);
    }

    public void update() {
        position.setY(position.getY() - speed);
    }
    public void updateEnemyBullet(){
        position.setY(position.getY() + speed);
    }

    public Position getPosition() {
        return position;
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), '|');
    }

    public boolean checkCollision(Enemy enemy) {
        return position.equals(enemy.getPosition());
    }

    public boolean checkPlayerCollision(PlayerShip playerShip){
        return position.equals(playerShip.getPosition());
    }
}
