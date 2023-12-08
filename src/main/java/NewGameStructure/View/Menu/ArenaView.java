package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
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

        // Draw the health bar
        drawHealthBar(graphics);

        // Draw the player ship
        getModel().getPlayerShip().draw(graphics);

        // Update the screen to show the latest drawings
        try {
            gui.getScreen().refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawHealthBar(TextGraphics graphics) {
        // Define health bar position and size
        int healthBarWidth = 20; // Width of the health bar
        int healthBarStartX = 3; // X position of the health bar
        int healthBarStartY = 1; // Y position of the health bar

        // Calculate the width of the filled portion of the health bar
        int healthPercentageWidth = (int) (((double) getModel().getPlayerShip().getHealth().getCurrentHealth() /
                getModel().getPlayerShip().getHealth().getMaxHealth()) * healthBarWidth);

        // Draw the background of the health bar (empty part)
        graphics.setBackgroundColor(TextColor.ANSI.WHITE);
        graphics.fillRectangle(new TerminalPosition(healthBarStartX, healthBarStartY), new TerminalSize(healthBarWidth, 1), ' ');

        // Draw the foreground of the health bar (filled part)
        graphics.setBackgroundColor(TextColor.ANSI.GREEN); // Changed to green
        graphics.fillRectangle(new TerminalPosition(healthBarStartX, healthBarStartY), new TerminalSize(healthPercentageWidth, 1), ' ');

        // Draw the text "HEALTH"
        graphics.setForegroundColor(TextColor.ANSI.BLACK);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(healthBarStartX, healthBarStartY), "HEALTH");

        // Draw the current health as text
        String healthText = String.format("%d/%d", getModel().getPlayerShip().getHealth().getCurrentHealth(),
                getModel().getPlayerShip().getHealth().getMaxHealth());
        graphics.putString(new TerminalPosition(healthBarStartX + healthBarWidth + 2, healthBarStartY), healthText);

        // Reset graphics settings
        graphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);
        graphics.disableModifiers(SGR.BOLD);
    }
}
