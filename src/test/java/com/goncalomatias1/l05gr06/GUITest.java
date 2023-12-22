package com.goncalomatias1.l05gr06;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GUITest {

    private Screen mockScreen;
    private GUI gui;

    @BeforeEach
    public void setUp() throws IOException {
        mockScreen = mock(Screen.class);
        gui = new GUI(mockScreen);
    }

    @Test
    public void whenArrowUpPressed_thenActionUpReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowUp);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    public void whenArrowDownPressed_thenActionDownReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowDown);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    public void whenArrowLeftPressed_thenActionLeftReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowLeft);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    public void whenArrowRightPressed_thenActionRightReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowRight);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    public void whenEnterPressed_thenActionEnterReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.Enter);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.ENTER, action);
    }

    @Test
    public void whenWPressed_thenActionUpReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('w', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.UP, action);
    }

    @Test
    public void whenSPressed_thenActionDownReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('s', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.DOWN, action);
    }

    @Test
    public void whenAPressed_thenActionLeftReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('a', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.LEFT, action);
    }

    @Test
    public void whenDPressed_thenActionRightReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke('d', false, false);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.RIGHT, action);
    }

    @Test
    public void whenEscapePressed_thenActionBackReturned() throws IOException {
        KeyStroke keyStroke = new KeyStroke(KeyType.Escape);
        when(mockScreen.pollInput()).thenReturn(keyStroke);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.BACK, action);
    }

    @Test
    public void whenNoKeyPressed_thenActionNoneReturned() throws IOException {
        when(mockScreen.pollInput()).thenReturn(null);

        GUI.ACTION action = gui.getAction();

        assertEquals(GUI.ACTION.NONE, action);
    }
}