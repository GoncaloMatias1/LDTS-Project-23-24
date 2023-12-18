import NewGameStructure.GUI;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanternGUITest {

    private Screen mockScreen;
    private GUI gui;

    @BeforeEach
    public void setUp() throws IOException {
        mockScreen = mock(Screen.class);
        gui = new GUI(mockScreen);
    }

    // Test for ArrowUp
    @Test
    public void whenArrowUpPressed_thenActionUpReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowUp);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    // Test for ArrowDown
    @Test
    public void whenArrowDownPressed_thenActionDownReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    // Test for ArrowLeft
    @Test
    public void whenArrowLeftPressed_thenActionLeftReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowLeft);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    // Test for ArrowRight
    @Test
    public void whenArrowRightPressed_thenActionRightReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowRight);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    // Test for Enter key
    @Test
    public void whenEnterPressed_thenActionEnterReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.ENTER, action);
    }

    // Test for 'w' key
    @Test
    public void whenWPressed_thenActionUpReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('w', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    // Test for 's' key
    @Test
    public void whenSPressed_thenActionDownReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('s', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    // Test for 'a' key
    @Test
    public void whenAPressed_thenActionLeftReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('a', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    // Test for 'd' key
    @Test
    public void whenDPressed_thenActionRightReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('d', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    // Test for Escape key
    @Test
    public void whenEscapePressed_thenActionBackReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.Escape);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.BACK, action);
    }

    // Test for no input
    @Test
    public void whenNoKeyPressed_thenActionNoneReturned() throws IOException {
        when(mockScreen.pollInput()).thenReturn(null);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.NONE, action);
    }
}