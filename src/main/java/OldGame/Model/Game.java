package OldGame.Model;


import OldGame.View.Menu.Arena;
import OldGame.View.Menu.MainMenu;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Game {
    private Screen screen;
    private Arena arena;
    private MainMenu mainMenu;

    public Game() {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(100, 30));

        try {
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            screen.setCursorPosition(null); // we don't need a cursor

            int width = screen.getTerminalSize().getColumns();
            int height = screen.getTerminalSize().getRows();

            arena = new Arena(width, height);
            mainMenu = new MainMenu(width, height);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            boolean running = true;
            boolean inMainMenu = true;
            boolean inGame = false;

            KeyStroke keyStroke;
            TextGraphics graphics = screen.newTextGraphics();

            while (running) {
                screen.clear();

                if (inMainMenu) {
                    mainMenu.draw(graphics);
                    // Use pollInput for non-blocking input reading
                    keyStroke = screen.pollInput();

                    if (keyStroke != null) {
                        if (keyStroke.getKeyType() == KeyType.Enter) {
                            String selectedItem = mainMenu.getSelectedItem();
                            if ("PLAY".equals(selectedItem)) {
                                inMainMenu = false;
                                inGame = true;
                            } else if ("CONTROLS".equals(selectedItem)) {
                                // Implement control view logic
                            } else if ("QUIT".equals(selectedItem)) {
                                running = false;
                            }
                        } else if (keyStroke.getKeyType() == KeyType.ArrowUp) {
                            mainMenu.update(-1);
                        } else if (keyStroke.getKeyType() == KeyType.ArrowDown) {
                            mainMenu.update(1);
                        }
                    }
                } else if (inGame) {
                    arena.draw(graphics); // Delegate drawing to the Arena class
                    arena.update(); // Update the game state through Arena
                    keyStroke = screen.pollInput(); // Non-blocking input polling
                    if (keyStroke != null) {
                        if (keyStroke.getKeyType() == KeyType.Escape) {
                            inGame = false;
                            inMainMenu = true;
                        } else {
                            arena.handleInput(keyStroke); // Delegate input handling to the Arena class
                        }
                    }
                }

                screen.refresh();
                // Sleep to control the frame rate in the game loop
                Thread.sleep(16); // Sleep for 16 ms to approximate 60 FPS
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
