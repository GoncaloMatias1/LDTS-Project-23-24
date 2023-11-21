package View;

import com.goncalomatias1.l05gr06.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MainMenu extends DefaultMenu {

    private static final String[] menuItems = {"PLAY", "CONTROLS", "QUIT"};
    private int selectedItem = 0; // Default selected item index

    public MainMenu(int width, int height){
        super(width, height);
        this.selectorPos = new Position(width / 2 - 6, height / 2);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(width / 2 - "SPACE INVADERS".length() / 2, height / 3), "SPACE INVADERS", SGR.BLINK);

        for (int i = 0; i < menuItems.length; i++) {
            if (i == selectedItem) {
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00")); // Yellow for selected
            } else {
                graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF")); // White for non-selected
            }
            graphics.putString(new TerminalPosition(width / 2 - menuItems[i].length() / 2, height / 2 + i * 2), menuItems[i]);
        }

        // Draw the selector
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF00")); // Yellow color for selector
        graphics.putString(new TerminalPosition(selectorPos.getX(), selectorPos.getY()), ">>");
    }

    @Override
    public void update(int direction) {
        selectedItem += direction;
        if (selectedItem < 0) {
            selectedItem = menuItems.length - 1; // wrap to last item
        } else if (selectedItem >= menuItems.length) {
            selectedItem = 0; // wrap to first item
        }
        // Update the selector position based on the new selected item
        selectorPos.setY(height / 2 + selectedItem * 2);
    }

    public String getSelectedItem() {
        return menuItems[selectedItem];
    }
}


