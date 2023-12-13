package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shield extends EntityModel {
    private TextCharacter shieldCharacter;

    public Shield(Position position) {
        super(position, 4, false); // Pass lives to the super constructor
        this.shieldCharacter = new TextCharacter('#', TextColor.ANSI.GREEN, TextColor.ANSI.BLACK);
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(getPosition().getX(), getPosition().getY(), shieldCharacter);
    }

    public void takeDamage() {
        if (this.lives > 0) {
            this.lives--;
        }
    }

    public boolean isAlive() {
        return this.lives > 0;
    }

    // Other methods...
}
