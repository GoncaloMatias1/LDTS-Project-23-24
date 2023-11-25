package com.goncalomatias1.l05gr06;

import com.goncalomatias1.l05gr06.Objects.PlayerShip;
import com.goncalomatias1.l05gr06.View.MainMenu;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Application {

    public static void main(String[] args) {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(100, 30));

        Screen screen = null;

        try {
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            screen.setCursorPosition(null); // we don't need a cursor
            TextGraphics graphics = screen.newTextGraphics();

            int width = screen.getTerminalSize().getColumns();
            int height = screen.getTerminalSize().getRows();

            MainMenu mainMenu = new MainMenu(width, height);
            PlayerShip playerShip = new PlayerShip(width / 2, height - 5);

            boolean running = true;
            boolean inMainMenu = true;
            boolean inGame = false;

            KeyStroke keyStroke = null;

            while (running) {
                // Clear previous frame
                screen.clear();

                if (inMainMenu) {
                    mainMenu.draw(graphics);
                } else if (inGame) {
                    playerShip.draw(graphics);
                    // TODO: Add game logic and drawing here
                }

                screen.refresh();

                if (inMainMenu) {
                    keyStroke = screen.readInput();
                } else if (inGame) {
                    keyStroke = screen.pollInput();
                    // Handle game input here
                    // TODO: Implement game input handling
                }

                if (keyStroke != null) {
                    if (keyStroke.getKeyType() == KeyType.Escape) {
                        running = false;
                    }

                    if (inMainMenu) {
                        if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                            mainMenu.update(-1);
                        } else if (keyStroke.getKeyType() == KeyType.ArrowDown) {
                            mainMenu.update(1);
                        } else if (keyStroke.getKeyType() == KeyType.Enter) {
                            String selectedItem = mainMenu.getSelectedItem();
                            System.out.println("Selected: " + selectedItem);
                            switch (selectedItem) {
                                case "PLAY":
                                    inMainMenu = false;
                                    inGame = true;
                                    break;
                                case "CONTROLS":
                                    // Implement control view logic
                                    break;
                                case "QUIT":
                                    running = false;
                                    break;
                            }
                        }
                    } else if (inGame) {
                        // Game controls
                        if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
                            playerShip.moveLeft();
                        } else if (keyStroke.getKeyType() == KeyType.ArrowRight) {
                            playerShip.moveRight();
                        }
                        // Add other controls like shooting, pausing, etc.
                    }
                }

                // Sleep to control the frame rate in the game loop
                if (inGame) {
                    try {
                        Thread.sleep(16); // Sleep for 16 ms for approximately 60 FPS
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (screen != null) {
                try {
                    screen.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
