package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.TerminalPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GameOverViewTest {

    private GUI mockGui;
    private GameOverModel mockModel;
    private TextGraphics mockTextGraphics;
    private Screen mockScreen;
    private GameOverView gameOverView;

    @BeforeEach
    void setUp() {
        mockGui = mock(GUI.class);
        mockModel = mock(GameOverModel.class);
        mockTextGraphics = mock(TextGraphics.class);
        mockScreen = mock(Screen.class);
        gameOverView = new GameOverView(mockModel);

        when(mockGui.getGraphics()).thenReturn(mockTextGraphics);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        when(mockGui.getWidth()).thenReturn(100); // Assuming a specific width for the GUI
        when(mockGui.getHeight()).thenReturn(30); // Assuming a specific height for the GUI
        when(mockModel.getMenuItems()).thenReturn(new String[]{"Item1", "Item2"});
        when(mockModel.getSelectedItem()).thenReturn(0);
        when(mockModel.getCurrentScore()).thenReturn(123);
        when(mockModel.getHighScore()).thenReturn(999);
    }

    /*@Test
    void testDraw() {
        gameOverView.draw(mockGui);

        // Verify that the screen is cleared
        verify(mockScreen).clear();

        // Verify that the background color is set
        verify(mockTextGraphics).setBackgroundColor(TextColor.Factory.fromString("#000000"));

        // Verify that the text graphics are set up correctly
        verify(mockTextGraphics, atLeastOnce()).setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        verify(mockTextGraphics, atLeastOnce()).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));

        // Verify that the score strings are put at the correct positions
        verify(mockTextGraphics).putString(any(TerminalPosition.class), contains("Your Score:"));
        verify(mockTextGraphics).putString(any(TerminalPosition.class), contains("High Score:"));

        // Verify that the menu items are drawn at the correct positions
        verify(mockTextGraphics, times(mockModel.getMenuItems().length)).putString(anyInt(), anyInt(), anyString());

        // Verify that the selector is drawn correctly
        verify(mockTextGraphics).putString(any(TerminalPosition.class), eq(">>"));
    }*/
}
