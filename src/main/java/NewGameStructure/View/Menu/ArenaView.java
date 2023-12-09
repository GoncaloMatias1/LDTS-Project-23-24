package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;

public class ArenaView extends View<ArenaModel> {
    public ArenaView(ArenaModel arenaModel){
        super(arenaModel);
    }

    @Override
    public void draw(GUI gui) {
        TextGraphics graphics = gui.getGraphics();
        gui.getScreen().clear();

        // Draw the arena boundaries at the edges of the screen
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        graphics.drawLine(0, 0, getModel().getWidth() - 1, 0, '-'); // Top boundary
        graphics.drawLine(0, getModel().getHeight() - 1, getModel().getWidth() - 1, getModel().getHeight() - 1, '-'); // Bottom boundary
        graphics.drawLine(0, 0, 0, getModel().getHeight() - 1, '|'); // Left boundary
        graphics.drawLine(getModel().getWidth() - 1, 0, getModel().getWidth() - 1, getModel().getHeight() - 1, '|'); // Right boundary

        // Draw the player ship
        getModel().getPlayerShip().draw(graphics);
        for (Projectile projectile : getModel().getProjectiles()) {
            projectile.draw(graphics);
        }
        // Update the screen to show the latest drawings
        try {
            gui.getScreen().refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
