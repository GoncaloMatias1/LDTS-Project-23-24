package NewGameStructure.Model.Game.Entities;

import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Model.Game.EntityModel;
import NewGameStructure.Position;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shield extends EntityModel {
    private static final int MAX_HEALTH = 4;
    private TextCharacter shieldCharacter;

    public Shield(Position position) {
        super(position, new Health(MAX_HEALTH), false);
        this.shieldCharacter = new TextCharacter('#', TextColor.ANSI.GREEN, TextColor.ANSI.BLACK);
    }

    public void draw(TextGraphics graphics) {
        if (getHealth().isAlive()) {
            graphics.setCharacter(getPosition().getX(), getPosition().getY(), shieldCharacter);
        }
    }

    // Other methods like takeDamage can be added if needed
}

