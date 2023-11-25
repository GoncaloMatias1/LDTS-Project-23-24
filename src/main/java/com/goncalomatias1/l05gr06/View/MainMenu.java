package com.goncalomatias1.l05gr06.View;

import com.goncalomatias1.l05gr06.Objects.Characteristics.Position;
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

        // ASCII Art for "Space Invaders" - this is a placeholder, replace with your ASCII art
        String titleArt =
                        "      _____                               _____                        _                      \n" +
                        "     /  ___|                             |_   _|                      | |                     \n" +
                        "    | (___  _ __   __ _  ___   ___         | |  _ _ __    __ __ _   __| |  ___  _ __  ___     \n" +
                        " \\___ \\| '_ \\ / _` |/ __\\ / _ \\        | | | '_ \\ \\  / // _` | / _` | / _ \\| '__|/ __|\n" +
                        "   ____) | |_) | (_| | |__ |  __/       _| |_| | | \\ \\/ /| (_| || (_| ||  __/| |   \\__ \\  \n" +
                        "|_____/| .__/ \\__,_|\\___/ \\___|      |_____|_| |_|\\__/  \\__,_| \\__,_| \\___||_|   |___/ \n" +
                        "           | |                                                                                \n" +
                        "           |_|                                                                                \n";

        // Split the ASCII art into lines
        String[] lines = titleArt.split("\n");
        int startY = 2; // Start Y position for the title

        // Draw each line of the ASCII art
        for (int i = 0; i < lines.length; i++) {
            graphics.putString(width / 2 - lines[i].length() / 2, startY + i, lines[i]);
        }
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


