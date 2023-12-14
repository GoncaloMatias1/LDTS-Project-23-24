package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Model.Game.Projectile;
import NewGameStructure.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayerShip extends EntityModel {
    private final TextCharacter shipCharacter;


    public PlayerShip(int startX, int startY, int screenWidth, int initialLives) {
        super(new Position(startX, startY), initialLives, false);
        this.shipCharacter = new TextCharacter('^', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
        this.minX = 1;
        this.maxX = screenWidth - 2;
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), shipCharacter);
    }


    public Projectile shoot() {
        return new Projectile(getPosition().getX(), getPosition().getY() - 1);
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        }
    }

    public boolean isAlive() {
        return lives > 0;
    }
}
