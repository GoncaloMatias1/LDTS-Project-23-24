package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PlayerShip extends EntityModel {
    private final TextCharacter shipCharacter;
    private final int minX; // Left boundary
    private final int maxX; // Right boundary

    public PlayerShip(int startX, int startY, int screenWidth, Health health) {
        super(new Position(startX, startY), health, false); // Chama o construtor da superclasse
        this.shipCharacter = new TextCharacter('^', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
        this.minX = 1; // Assuming the border is 1 character thick
        this.maxX = screenWidth - 2; // Adjusted for 1 character thick border
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), shipCharacter);
    }

    public void moveLeft() {
        Position currentPosition = getPosition();
        if (currentPosition.getX() > minX) {
            currentPosition.setX(currentPosition.getX() - 1);
        }
    }

    public void moveRight() {
        Position currentPosition = getPosition();
        if (currentPosition.getX() < maxX) {
            currentPosition.setX(currentPosition.getX() + 1);
        }
    }
}
