package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class GameOverViewTest {

    @Mock
    private GameOverModel gameOverModel;

    @Mock
    private GUI gui;

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics textGraphics;

    private GameOverView gameOverView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(gui.getScreen()).thenReturn(screen);
        when(gui.getGraphics()).thenReturn(textGraphics);
        when(gui.getWidth()).thenReturn(100); // Assuming a width of 100 for the tests
        when(gui.getHeight()).thenReturn(30); // Assuming a height of 30 for the tests

        gameOverView = new GameOverView(gameOverModel);
    }

    @Test
    void drawTest() {
        String[] menuItems = {"RESTART", "QUIT"};
        when(gameOverModel.getMenuItems()).thenReturn(menuItems);
        when(gameOverModel.getSelectedItem()).thenReturn(0);
        when(gameOverModel.getCurrentScore()).thenReturn(1234);
        when(gameOverModel.getHighScore()).thenReturn(9999);
        when(gameOverModel.getSelectorPos()).thenReturn(new Position(50, 15));

        gameOverView.draw(gui);

        verify(screen, times(1)).clear();

        verify(textGraphics, times(1)).putString(any(TerminalPosition.class), contains("Your Score:"));
        verify(textGraphics, times(1)).putString(any(TerminalPosition.class), contains("High Score:"));

        for (String menuItem : menuItems) {
            verify(textGraphics, times(1)).putString(any(TerminalPosition.class), eq(menuItem));
        }

        verify(textGraphics, times(1)).putString(any(TerminalPosition.class), eq(">>"));

    }

}
