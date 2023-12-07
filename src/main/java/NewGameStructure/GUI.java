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
    public enum ACTION {UP, DOWN, LEFT, RIGHT, ENTER, NONE, BACK}
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
    public ACTION getAction() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.ArrowUp ||
                (keyStroke.getKeyType() == KeyType.Character &&
                        (keyStroke.getCharacter() == 'w' || keyStroke.getCharacter() == 'W'))) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowDown ||
                (keyStroke.getKeyType() == KeyType.Character &&
                        (keyStroke.getCharacter() == 's' || keyStroke.getCharacter() == 'S'))) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft ||
                (keyStroke.getKeyType() == KeyType.Character &&
                        (keyStroke.getCharacter() == 'a' || keyStroke.getCharacter() == 'A'))) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.ArrowRight ||
                (keyStroke.getKeyType() == KeyType.Character &&
                        (keyStroke.getCharacter() == 'd' || keyStroke.getCharacter() == 'D'))) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.Enter ||
                (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == ' ')) return ACTION.ENTER;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.BACK;
        return ACTION.NONE;
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
