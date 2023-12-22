package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ControlsControllerTest {
    private ControlsController controlsController;
    private ControlsModel controlsModel;
    private Application mockApplication;

    @BeforeEach
    void setUp() {
        controlsModel = new ControlsModel();
        mockApplication = mock(Application.class);
        controlsController = new ControlsController(controlsModel);
    }

    @Test
    void step_BackAction_SetsStateToMainMenu() {
        controlsController.step(mockApplication, GUI.ACTION.BACK);
        verify(mockApplication).setState(any(MainMenuState.class));
    }

    @Test
    void step_OtherActions_DoNotChangeState() {
        for (GUI.ACTION action : GUI.ACTION.values()) {
            if (action != GUI.ACTION.BACK) {
                reset(mockApplication);
                controlsController.step(mockApplication, action);
                verify(mockApplication, never()).setState(any());
            }
        }
    }
}
