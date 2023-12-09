package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Projectile extends EntityModel {
    private static final int SPEED = 2; // Speed of projectile
    private final TextCharacter projectileCharacter;

    public Projectile(Position startPosition) {
        super(startPosition, null, true); // Assuming null for Health and true for destructible
        this.projectileCharacter = new TextCharacter('|', TextColor.ANSI.WHITE, TextColor.ANSI.BLACK);
    }

    public void update() {
        Position currentPosition = getPosition();
        currentPosition.setY(currentPosition.getY() - SPEED); // Move the projectile up
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), projectileCharacter);
    }
}