package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.Position;
import com.goncalomatias1.l05gr06.View.Menu.MainMenuView;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MainMenuViewTest {

    @Mock
    private MainMenuModel mainMenuModel;

    @Mock
    private GUI gui;

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics textGraphics;

    private MainMenuView mainMenuView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(gui.getScreen()).thenReturn(screen);
        when(gui.getGraphics()).thenReturn(textGraphics);
        when(gui.getWidth()).thenReturn(100); // Assuming a width of 100 for the tests
        when(gui.getHeight()).thenReturn(30); // Assuming a height of 30 for the tests

        mainMenuView = new MainMenuView(mainMenuModel);
    }

    @Test
    void drawClearsScreenAndDrawsArtCorrectly() {
        // Arrange
        when(mainMenuModel.getMenuItems()).thenReturn(new String[]{"START", "EXIT"});
        when(mainMenuModel.getSelectedItem()).thenReturn(0);
        when(mainMenuModel.getSelectorPos()).thenReturn(new Position(50, 15));

        // Act
        mainMenuView.draw(gui);

        // Assert
        verify(screen, times(1)).clear();
        // Verify ASCII art for "Space Invaders" is drawn
        verify(textGraphics, atLeastOnce()).putString(anyInt(), anyInt(), contains("_____"));
        // Verify ASCII art for aliens is drawn
        verify(textGraphics, atLeastOnce()).putString(anyInt(), anyInt(), contains(".__."));
        // ... Add more assertions for different parts of the ASCII art as needed
    }

    @Test
    void drawHighlightsSelectedMenuItem() {
        // Arrange
        String[] menuItems = {"START", "EXIT"};
        when(mainMenuModel.getMenuItems()).thenReturn(menuItems);
        when(mainMenuModel.getSelectedItem()).thenReturn(1); // Assume "EXIT" is selected
        Position selectorPos = new Position(50, 15);
        when(mainMenuModel.getSelectorPos()).thenReturn(selectorPos);

        // Act
        mainMenuView.draw(gui);

        // Assert
        verify(textGraphics, atLeastOnce()).setForegroundColor(TextColor.Factory.fromString("#FFFF00"));
        verify(textGraphics).putString(any(TerminalPosition.class), eq("EXIT"));
    }

}
