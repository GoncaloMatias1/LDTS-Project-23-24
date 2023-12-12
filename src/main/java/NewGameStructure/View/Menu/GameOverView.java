package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class GameOverView extends View<GameOverModel> {
    public GameOverView(GameOverModel gameOverModel){
        super(gameOverModel);
    }

    @Override
    public void draw(GUI gui){
        try {
            gui.getScreen().clear();
            int width = gui.getWidth();
            int height = gui.getHeight();
            TextGraphics graphics = gui.getGraphics();
            graphics.setBackgroundColor(TextColor.Factory.fromString("#000000")); //preto
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            // ASCII Art for "Space Invaders"
            String titleArt =
                    "   ______                                    ___                   \n" +
                            " / _____|                                  / _ \\                 \n" +
                            "     | |  _____   __ _   _ _    __    ___      | | | | __    __  ___   _ __\n" +
                            "      | | |_   _| / _` | | '_ \\/_  \\  / _ \\     | | | | \\ \\  / / / _ \\ | '__|\n" +
                            "     | |___| |  | (_| | | | | | | | |  __/     | |_| |  \\ \\/ / |  __/ | | \n" +
                            "    \\______|   \\__,_| |_| |_| |_|  \\___|      \\___/    \\__/   \\___| |_|\n";

            // Split the ASCII art into lines
            String[] lines = titleArt.split("\n");
            int startY = 2; // Start Y position for the title

            // Draw each line of the ASCII art
            for (int i = 0; i < lines.length; i++) {
                graphics.putString(width / 2 - lines[i].length() / 2, startY + i, lines[i]);
            }
            for (int i = 0; i < getModel().getMenuItems().length; i++) {
                if (i == getModel().getSelectedItem()) {
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00")); // amarelo
                } else {
                    graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF")); // branco
                }
                graphics.putString(new TerminalPosition(width / 2 - getModel().getMenuItems()[i].length() / 2, height / 2 + i * 2), getModel().getMenuItems()[i]);
            }

            // Draw the selector
            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00")); // Yellow color for selector
            graphics.putString(new TerminalPosition(getModel().getSelectorPos().getX()-2, getModel().getSelectorPos().getY()), ">>");
            getModel().getSelectorPos().setY(height / 2 + getModel().getSelectedItem() * 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
