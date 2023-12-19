package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ControlsViewTest {

    @Mock
    private GUI mockGui;
    @Mock
    private ControlsModel mockModel;
    @Mock
    private TextGraphics mockGraphics;
    @Mock
    private Screen mockScreen; // Mock Screen object

    private ControlsView controlsView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        when(mockGui.getGraphics()).thenReturn(mockGraphics);
        when(mockGui.getWidth()).thenReturn(80); // assuming a width
        when(mockGui.getHeight()).thenReturn(24); // assuming a height

        // Stubbing the clear method of the Screen mock
        doNothing().when(mockScreen).clear();

        controlsView = new ControlsView(mockModel);
    }

    /*@Test
    void testDraw() {
        // Call the method to be tested
        controlsView.draw(mockGui);

        // Verify the clear screen is called
        verify(mockGui).getScreen().clear();

        // Verify background color set
        verify(mockGraphics).setBackgroundColor(TextColor.Factory.fromString("#000000"));

        // Verify a rectangle is filled
        verify(mockGraphics).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), eq(' '));

        // Verify the strings are placed on the screen
        verify(mockGraphics, times(11)).putString(anyInt(), anyInt(), anyString());
    }*/
}
