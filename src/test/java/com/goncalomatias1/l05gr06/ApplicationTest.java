package com.goncalomatias1.l05gr06;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;

import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.State;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class ApplicationTest {

    @Mock
    private GUI gui;

    @Mock
    private Screen screen;

    @Mock
    private State state;

    @InjectMocks
    private Application application;

    private AutoCloseable closeable;

    @BeforeEach
    public void setUp() throws IOException {
        closeable = MockitoAnnotations.openMocks(this);
        when(gui.getScreen()).thenReturn(screen);
        application = new Application(); // Normally you would inject mocks here
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void testApplicationConstructor() {
        assertNotNull(application.getGui());
        assertNotNull(application.getState());
    }
    
    @Test
    public void testSetState() {
        State newState = mock(State.class);
        application.setState(newState);
        assertEquals(newState, application.getState());
    }

    @Test
    public void testGetState() {
        application.setState(state);
        assertEquals(state, application.getState());
    }

}
