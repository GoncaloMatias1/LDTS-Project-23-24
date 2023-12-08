package NewGameStructure;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GUI {
    private Screen screen;
    public enum ACTION {UP, DOWN, LEFT, RIGHT, ENTER, NONE, ESCAPE}
    public GUI(Screen screen){
        this.screen = screen;
    }

    public GUI(int width, int height) throws IOException{
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height));

        Terminal terminal = terminalFactory.createTerminal();
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }
    // Inside the GUI class...

    public ACTION getAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        switch (keyStroke.getKeyType()) {
            case ArrowUp:
                return ACTION.UP;
            case ArrowDown:
                return ACTION.DOWN;
            case ArrowLeft:
                return ACTION.LEFT;
            case ArrowRight:
                return ACTION.RIGHT;
            case Enter:
                return ACTION.ENTER;
            case Escape:
                return ACTION.ESCAPE; // Handle ESC key
            default:
                return ACTION.NONE;
        }
    }

    public TextGraphics getGraphics(){
        TextGraphics textGraphics = screen.newTextGraphics();
        return textGraphics;
    }
    public int getWidth(){
        return screen.getTerminalSize().getColumns();
    }
    public int getHeight(){
        return screen.getTerminalSize().getRows();
    }
    public Screen getScreen(){
        return screen;
    }
}
