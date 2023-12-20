package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class GameOverControllerTest {
    private GameOverController gameOverController;
    private GameOverModel mockGameOverModel;
    private Application mockApplication;

    @BeforeEach
    void setUp() {
        mockGameOverModel = mock(GameOverModel.class);
        mockApplication = mock(Application.class);
        gameOverController = new GameOverController(mockGameOverModel);
    }

    @Test
    void step_UpAction_ShouldRemoveEntry() {
        gameOverController.step(mockApplication, GUI.ACTION.UP);
        verify(mockGameOverModel).removeEntry();
    }

    @Test
    void step_DownAction_ShouldAddEntry() {
        gameOverController.step(mockApplication, GUI.ACTION.DOWN);
        verify(mockGameOverModel).addEntry();
    }

    @Test
    void step_EnterAction_WhenSelectedItemIsZero_ShouldSetStateToMainMenu() {
        when(mockGameOverModel.getSelectedItem()).thenReturn(0);
        gameOverController.step(mockApplication, GUI.ACTION.ENTER);
        verify(mockApplication).setState(any(MainMenuState.class));
    }

    @Test
    void step_EnterAction_WhenSelectedItemIsOne_ShouldExitApplication() {
        when(mockGameOverModel.getSelectedItem()).thenReturn(1);
        gameOverController.step(mockApplication, GUI.ACTION.ENTER);
        verify(mockApplication).setState(null);
    }
}
