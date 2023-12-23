package com.goncalomatias1.l05gr06.View;

import com.goncalomatias1.l05gr06.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ViewTest {

    private View<Object> view;

    @Mock
    private GUI mockGui;

    @Mock
    private Object mockModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        view = new View<>(mockModel);
    }

    @Test
    void getModel_shouldReturnModel() {
        assertEquals(mockModel, view.getModel());
    }

    @Test
    void draw_shouldNotThrowException() {
        assertDoesNotThrow(() -> view.draw(mockGui));
    }

    @Test
    public void draw_shouldInvokeGuiMethods() {
        GUI mockGui = mock(GUI.class);
        View<Object> viewWithMockedMethod = new View<>(new Object()) {
            @Override
            public void draw(GUI gui) {
                gui.getScreen();
            }
        };

        viewWithMockedMethod.draw(mockGui);

        verify(mockGui).getScreen();
    }
}
