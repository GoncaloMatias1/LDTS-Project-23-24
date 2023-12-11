package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.MainMenuState;

public class GameOverController extends Controller<GameOverModel> {
    public GameOverController(GameOverModel gameOverModel){
        super(gameOverModel);
    }
    @Override
    public void step(Application application, GUI.ACTION action) {
        switch (action){
            case BACK:
                application.setState(new MainMenuState(new MainMenuModel()));
        }
    }
}
