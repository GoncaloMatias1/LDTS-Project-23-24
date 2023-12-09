package NewGameStructure.View.Menu;

import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ControlsView extends View {
    private ControlsModel model;

    public ControlsView(ControlsModel model) {
        super(model);
    }

    public void draw(TextGraphics graphics) {
        for (Projectile projectile : model.getProjectiles()) {
            System.out.println("Drawing projectile at " + projectile.getPosition());
            projectile.draw(graphics);
        }
    }
}
