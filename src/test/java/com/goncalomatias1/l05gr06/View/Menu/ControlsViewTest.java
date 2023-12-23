package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ControlsViewTest {

    @Mock
    private ControlsModel mockModel;
    @Mock
    private GUI mockGui;
    @Mock
    private Screen mockScreen;
    @Mock
    private Terminal mockTerminal;
    @Mock
    private TextGraphics mockTextGraphics;

    private ControlsView controlsView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        when(mockGui.getGraphics()).thenReturn(mockTextGraphics);
        when(mockScreen.getTerminalSize()).thenReturn(new TerminalSize(100, 20));
        controlsView = new ControlsView(mockModel);
    }

    @Test
    void testDraw() {
        int width = 100;
        int height = 20;
        when(mockGui.getWidth()).thenReturn(width);
        when(mockGui.getHeight()).thenReturn(height);

        controlsView.draw(mockGui);

        verify(mockScreen, times(1)).clear();
        verify(mockTextGraphics, times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        verify(mockTextGraphics, times(1)).fillRectangle(any(), any(), eq(' '));

        String text = " Press 'A' or Left Arrow Key to move the spaceship left.\n" +
                "Press 'D' or Right Arrow Key to move the spaceship right.\n" +
                "Press 'Spacebar' to shoot lasers at the invaders.\n" +
                "Destroy all invaders before they reach the shields.\n" +
                "Earn points for each invader you destroy. Bonus points for shooting mystery ships.\n" +
                "You start with 3 lives. Losing all lives ends the game.\n" +
                "Move quickly and shoot accurately. Use cover wisely.\n" +
                "\n" +
                "\n" +
                "\n" +
                "PRESS ESC TO GO BACK TO MAIN MENU";
        String[] lines = text.split("\n");
        int startY = 7;
        for (int i = 0; i < lines.length; i++) {
            int expectedX = width / 2 - lines[i].length() / 2;
            verify(mockTextGraphics, times(1))
                    .putString(expectedX, startY + i, lines[i]);
        }
    }

}
