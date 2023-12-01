package NewGameStructure.View.Game;

import NewGameStructure.Model.Game.EntityModel;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class EntityView {
    protected EntityModel model;

    public EntityView(EntityModel model) {
        this.model = model;
    }

    public abstract void draw(TextGraphics graphics);
}

