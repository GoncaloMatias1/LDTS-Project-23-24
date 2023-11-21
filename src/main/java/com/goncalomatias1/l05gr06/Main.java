package com.goncalomatias1.l05gr06;

import View.MainMenu;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {

    public static void main(String[] args) {
        // Create a terminal and screen to display the menu
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            screen.setCursorPosition(null); // we don't need a cursor
            TextGraphics graphics = screen.newTextGraphics();

            // Calculate the center position based on the terminal size
            int width = screen.getTerminalSize().getColumns();
            int height = screen.getTerminalSize().getRows();

            // Instantiate MainMenuView with the terminal's size
            MainMenu mainMenu = new MainMenu(width, height);

            // Main loop to update and redraw the screen
            boolean running = true;
            while (running) {
                // Draw the menu
                mainMenu.draw(graphics);
                screen.refresh();

                // Handle key input for navigation
                KeyStroke keyStroke = screen.pollInput();
                if (keyStroke != null) {
                    if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                        mainMenu.update(-1); // Move selection up
                    } else if (keyStroke.getKeyType() == KeyType.ArrowDown) {
                        mainMenu.update(1); // Move selection down
                    } else if (keyStroke.getKeyType() == KeyType.Enter) {
                        // Execute the selected option
                        // Placeholder for action based on selected item
                        System.out.println("Selected: " + mainMenu.getSelectedItem());
                        // Add logic here for what happens when an item is selected
                    } else if (keyStroke.getKeyType() == KeyType.Escape) {
                        running = false; // Exit on ESC
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cleanup the screen and terminal
            if (screen != null) {
                try {
                    screen.stopScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

