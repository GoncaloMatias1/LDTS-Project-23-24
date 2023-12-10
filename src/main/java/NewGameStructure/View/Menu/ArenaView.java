package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Game.Entities.Shield;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
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

        // Draw arena boundaries
        drawBoundaries(graphics);

        // Draw player lives as hearts
        drawLives(graphics);

        // Draw the player ship
        getModel().getPlayerShip().draw(graphics);

        // Draw projectiles
        for (Projectile projectile : getModel().getProjectiles()) {
            projectile.draw(graphics);
        }

        // Draw shields
        for (Shield shield : getModel().getShields()) {
            shield.draw(graphics);
        }

        // Refresh the screen to display the latest drawings
        try {
            gui.getScreen().refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawBoundaries(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        graphics.drawLine(0, 0, getModel().getWidth() - 1, 0, '-'); // Top boundary
        graphics.drawLine(0, getModel().getHeight() - 1, getModel().getWidth() - 1, getModel().getHeight() - 1, '-'); // Bottom boundary
        graphics.drawLine(0, 0, 0, getModel().getHeight() - 1, '|'); // Left boundary
        graphics.drawLine(getModel().getWidth() - 1, 0, getModel().getWidth() - 1, getModel().getHeight() - 1, '|'); // Right boundary
    }

    private void drawLives(TextGraphics graphics) {
        int startX = 2; // Set the X position where the lives display starts
        int startY = 1; // Set the Y position slightly lower on the screen

        graphics.putString(new TerminalPosition(startX, startY), "LIVES", SGR.BOLD);
        startX += 6; // Move the start position for the hearts to the right after the text

        String heart = "\u2665"; // This is the Unicode character for a heart
        graphics.setForegroundColor(TextColor.ANSI.RED);
        graphics.enableModifiers(SGR.BOLD); // Bold makes the heart larger

        int lives = getModel().getPlayerShip().getLives(); // Get the number of lives from our player ship model
        for (int i = 0; i < lives; i++) {
            graphics.putString(new TerminalPosition(startX + i * 4, startY), heart); // Draw hearts with spacing
        }
        graphics.disableModifiers(SGR.BOLD); // Reset to normal text for other drawings
    }


}
