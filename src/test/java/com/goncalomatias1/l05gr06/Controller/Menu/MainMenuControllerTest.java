package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.Menu.ArenaState;
import com.goncalomatias1.l05gr06.States.Menu.ControlsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenuModel mockMainMenuModel;
    private Application mockApplication;
    private GUI mockGUI;

    @BeforeEach
    void setUp() {
        mockMainMenuModel = mock(MainMenuModel.class);
        mockApplication = mock(Application.class);
        mockGUI = mock(GUI.class);
        mainMenuController = new MainMenuController(mockMainMenuModel);

        when(mockApplication.getGui()).thenReturn(mockGUI);
        when(mockGUI.getWidth()).thenReturn(100);
        when(mockGUI.getHeight()).thenReturn(100);
    }

    @Test
    void step_UpAction_ShouldRemoveEntry() {
        mainMenuController.step(mockApplication, GUI.ACTION.UP);
        verify(mockMainMenuModel).removeEntry();
    }

    @Test
    void step_DownAction_ShouldAddEntry() {
        mainMenuController.step(mockApplication, GUI.ACTION.DOWN);
        verify(mockMainMenuModel).addEntry();
    }

    @Test
    void step_EnterAction_WhenSelectedItemIsZero_ShouldSetStateToArena() {
        when(mockMainMenuModel.getSelectedItem()).thenReturn(0);
        mainMenuController.step(mockApplication, GUI.ACTION.ENTER);
        verify(mockApplication).setState(any(ArenaState.class));
    }

    @Test
    void step_EnterAction_WhenSelectedItemIsOne_ShouldSetStateToControls() {
        when(mockMainMenuModel.getSelectedItem()).thenReturn(1);
        mainMenuController.step(mockApplication, GUI.ACTION.ENTER);
        verify(mockApplication).setState(any(ControlsState.class));
    }

    @Test
    void step_EnterAction_WhenSelectedItemIsTwo_ShouldTerminateApplication() {
        when(mockMainMenuModel.getSelectedItem()).thenReturn(2);
        mainMenuController.step(mockApplication, GUI.ACTION.ENTER);
        verify(mockApplication).setState(null);
    }

}
