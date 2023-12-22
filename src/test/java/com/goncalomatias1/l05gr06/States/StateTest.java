package com.goncalomatias1.l05gr06.States;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.View.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

import static org.mockito.Mockito.*;

class StateTest {

    @Mock
    private Application mockApplication;
    @Mock
    private GUI mockGui;
    @Mock
    private Screen mockScreen;
    @Mock
    private View<Object> mockView;
    @Mock
    private Controller<Object> mockController;

    private State<Object> testableState;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        when(mockGui.getScreen()).thenReturn(mockScreen); // Return the mock Screen when getScreen is called

        testableState = new TestableState(new Object());
    }

    @Test
    void step_ShouldInvokeControllerAndView() throws IOException {
        when(mockGui.getAction()).thenReturn(GUI.ACTION.NONE);

        testableState.step(mockApplication, mockGui);

        verify(mockController).step(mockApplication, GUI.ACTION.NONE);
        verify(mockView).draw(mockGui);
        verify(mockScreen).refresh();
    }

    private class TestableState extends State<Object> {
        public TestableState(Object model) {
            super(model);
        }

        @Override
        protected View<Object> getView() {
            return mockView;
        }

        @Override
        protected Controller<Object> getController() {
            return mockController;
        }
    }
}
