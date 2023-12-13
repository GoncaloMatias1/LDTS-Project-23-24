import NewGameStructure.Application;
import NewGameStructure.Controller.Menu.GameOverController;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.States.Menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

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
}
