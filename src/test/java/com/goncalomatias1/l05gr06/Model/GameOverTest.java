package com.goncalomatias1.l05gr06.Model;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Menu.GameOverController;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;


class GameOverTest {

    private GameOverModel model;
    private GameOverController controller;
    private Application application;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        model = new GameOverModel();
        controller = new GameOverController(model);
        application = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    public void testNavigateToStartAgain() {
        // selectedItem is set to 0 "START AGAIN"
        while (model.getSelectedItem() != 0) {
            model.removeEntry();
        }
        controller.step(application, GUI.ACTION.ENTER);
        verify(application).setState(any(MainMenuState.class));
    }

    @Test
    public void testNavigateToQuit() {
        // selectedItem is set to 1 "QUIT"
        while (model.getSelectedItem() != 1) {
            model.addEntry();
        }
        controller.step(application, GUI.ACTION.ENTER);
        verify(application).setState(null);
    }

    @Test
    public void whenEnterPressedOnStartAgain_shouldTransitionToMainMenuState() {
        // Simulate pressing 'UP' until the "START AGAIN" option is selected
        while (model.getSelectedItem() != 0) {
            controller.step(application, GUI.ACTION.UP);
        }
        controller.step(application, GUI.ACTION.ENTER);
        verify(application).setState(any(MainMenuState.class));
    }

    @Test
    public void whenEnterPressedOnQuit_shouldTerminateApplication() {
        // Simulate pressing 'DOWN' until the "QUIT" option is selected
        while (model.getSelectedItem() != 1) {
            controller.step(application, GUI.ACTION.DOWN);
        }
        controller.step(application, GUI.ACTION.ENTER);
        verify(application).setState(null); // The application should set its state to null before stopping
    }
}
