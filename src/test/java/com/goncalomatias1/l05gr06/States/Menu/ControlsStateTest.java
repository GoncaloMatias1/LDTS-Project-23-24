package com.goncalomatias1.l05gr06.States.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Menu.ControlsController;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.goncalomatias1.l05gr06.View.Menu.ControlsView;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControlsStateTest {

    @Mock
    private ControlsModel mockModel;
    @Mock
    private ControlsView mockView;
    @Mock
    private ControlsController mockController;
    @Mock
    private Application mockApplication;
    @Mock
    private GUI mockGui;

    private ControlsState controlsState;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        when(mockGui.getAction()).thenReturn(GUI.ACTION.NONE);

        when(mockGui.getScreen()).thenReturn(mock(Screen.class));

        controlsState = new ControlsState(mockModel) {
            @Override
            protected ControlsView getView() {
                return mockView;
            }

            @Override
            protected ControlsController getController() {
                return mockController;
            }
        };
    }

    @Test
    void testStep() throws IOException {
        controlsState.step(mockApplication, mockGui);

        verify(mockController, times(1)).step(mockApplication, GUI.ACTION.NONE);
        verify(mockView, times(1)).draw(mockGui);
        verify(mockGui.getScreen(), times(1)).refresh();

        assertSame(mockModel, controlsState.getModel());
    }
}
