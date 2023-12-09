package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ControlsView extends View<ControlsModel> {
    public ControlsView(ControlsModel controlsModel){
        super(controlsModel);
    }

    @Override
    public void draw(GUI gui){
        gui.getScreen().clear();
        int width = gui.getWidth();
        int height = gui.getHeight();
        TextGraphics graphics = gui.getGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        String text = " Press 'A' or Left Arrow Key to move the spaceship left.\n" +
                "Press 'D' or Right Arrow Key to move the spaceship right.\n" +
                "Press 'Spacebar' to shoot lasers at the invaders.\n" +
                "Press 'P' to pause the game and resume.\n" +
                "Destroy all invaders before they reach the bottom of the screen.\n" +
                "Earn points for each invader you destroy. Bonus points for shooting mystery ships.\n" +
                "You start with 3 lives. Losing all lives ends the game.\n" +
                "Move quickly and shoot accurately. Use cover wisely.\n" +
                "\n" +
                "\n" +
                "\n" +
                "PRESS ESC TO GO BACK TO MAIN MENU";


        String[] lines = text.split("\n");
        int startY = 7;

        for (int i = 0; i < lines.length; i++) {
            graphics.putString(width / 2 - lines[i].length() / 2, startY + i, lines[i]);
        }
    }
}
