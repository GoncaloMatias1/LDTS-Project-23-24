package com.goncalomatias1.l05gr06.States.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Menu.ArenaController;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.View.Menu.ArenaView;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ArenaStateTest {

    @Mock
    private ArenaModel mockModel;
    @Mock
    private ArenaView mockView;
    @Mock
    private ArenaController mockController;
    @Mock
    private Application mockApplication;
    @Mock
    private GUI mockGui;

    private ArenaState arenaState;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);

        when(mockGui.getAction()).thenReturn(GUI.ACTION.NONE);
        when(mockGui.getScreen()).thenReturn(mock(Screen.class));

        arenaState = new ArenaState(mockModel) {
            @Override
            protected ArenaView getView() {
                return mockView;
            }

            @Override
            protected ArenaController getController() {
                return mockController;
            }
        };
    }

    @Test
    void testStep() throws IOException {
        arenaState.step(mockApplication, mockGui);

        verify(mockController, times(1)).step(mockApplication, GUI.ACTION.NONE);
        verify(mockView, times(1)).draw(mockGui);
        verify(mockGui.getScreen(), times(1)).refresh();

        assertSame(mockModel, arenaState.getModel());
    }
}
