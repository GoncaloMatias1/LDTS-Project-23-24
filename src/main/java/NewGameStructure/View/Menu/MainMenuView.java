package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MainMenuView extends View<MainMenuModel> {

    public MainMenuView(MainMenuModel menuModel){
        super(menuModel);
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
                    "      _____                               _____                        _                      \n" +
                            "     /  ___|                             |_   _|                      | |                     \n" +
                            "    | (___  _ __   __ _  ___   ___         | |  _ _ __    __ __ _   __| |  ___  _ __  ___     \n" +
                            " \\___ \\| '_ \\ / _` |/ __\\ / _ \\        | | | '_ \\ \\  / // _` | / _` | / _ \\| '__|/ __|\n" +
                            "   ____) | |_) | (_| | |__ |  __/       _| |_| | | \\ \\/ /| (_| || (_| ||  __/| |   \\__ \\  \n" +
                            "|_____/| .__/ \\__,_|\\___/ \\___|      |_____|_| |_|\\__/  \\__,_| \\__,_| \\___||_|   |___/ \n" +
                            "           | |                                                                                \n" +
                            "           |_|                                                                                \n";

            String drawArt=
                    " ___\n"+
                            " ___/   \\___\n"+
                            "/   '---'   \\\n"+
                            "'--_______--'\n"+
                            "   / \\  \n"+
                            "  /   \\  \n"+
                            "  /\\O/\\  \n"+
                            "  / | \\  \n"+
                            "  // \\\\  \n";




            String[] lines2 = drawArt.split("\n");
            int startYdraw = 20; // Start Y position for the title

            for (int i = 0; i < lines2.length; i++) {
                graphics.putString(width / 2 - lines2[i].length() / 2 - 25, startYdraw + i, lines2[i]);
            }

            String[] lines = titleArt.split("\n");
            int startY = 2;

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

            graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00")); // Yellow color
            graphics.putString(new TerminalPosition(getModel().getSelectorPos().getX(), getModel().getSelectorPos().getY()), ">>");
            getModel().getSelectorPos().setY(height / 2 + getModel().getSelectedItem() * 2);

            String drawAlien1 =
                    "       .-\"\"\"\"-.    \n"+
                            "        /        \\    \n"+
                            "       /_        _\\   \n"+
                            "     // \\      / \\\\ \n"+
                            "     |\\__\\    /__/|  \n"+
                            "       \\    ||    /   \n"+
                            "        \\        /    \n"+
                            "         \\  __  /     \n"+
                            "          '.__.'       \n"+
                            "           |  |        \n"+
                            "           |  |        \n";

            TextColor orange = new TextColor.RGB(255, 165, 0); // RGB value for orange
            graphics.setForegroundColor(orange); // Set the color to orange

            String[] lines3 = drawAlien1.split("\n");
            int startYalien = 19; // Start Y position for the title

            for (int i = 0; i < lines3.length; i++) {
                graphics.putString(width / 2 - lines3[i].length() / 2 + 20, startYalien + i, lines3[i]);
            }


            String drawAlien2 =
                    "       .-\"\"\"\"-.    \n"+
                            "        /        \\    \n"+
                            "       /_        _\\   \n"+
                            "     // \\      / \\\\ \n"+
                            "     |\\__\\    /__/|  \n"+
                            "       \\    ||    /   \n"+
                            "        \\        /    \n"+
                            "         \\  __  /     \n"+
                            "          '.__.'       \n"+
                            "           |  |        \n"+
                            "           |  |        \n";

            graphics.setForegroundColor(TextColor.ANSI.RED);

            String[] lines4 = drawAlien2.split("\n");
            int startYalien2 = 19;

            for (int i = 0; i < lines4.length; i++) {
                graphics.putString(width / 2 - lines4[i].length() / 2 + 39, startYalien2 + i, lines4[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
