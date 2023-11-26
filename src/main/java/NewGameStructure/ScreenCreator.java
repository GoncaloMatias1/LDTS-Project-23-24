package NewGameStructure;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class ScreenCreator {
    private static Screen screen;

    public static void createScreen(){
         DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                 .setInitialTerminalSize(new TerminalSize(100, 30));

         try {
             Terminal terminal = terminalFactory.createTerminal();
             screen = new TerminalScreen(terminal);
             screen.startScreen();
             screen.setCursorPosition(null); // we don't need a cursor

             int width = screen.getTerminalSize().getColumns();
             int height = screen.getTerminalSize().getRows();

         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
