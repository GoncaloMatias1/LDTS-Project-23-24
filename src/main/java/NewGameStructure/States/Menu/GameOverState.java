package NewGameStructure.States.Menu;

import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.GameOverController;
import NewGameStructure.Controller.Menu.MainMenuController;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.GameOverView;
import NewGameStructure.View.Menu.MainMenuView;
import NewGameStructure.View.View;

public class GameOverState extends State<GameOverModel> {
    public GameOverState(GameOverModel gameOverModel){
        super(gameOverModel);
    }
    @Override
    protected View<GameOverModel> getView() {
        return new GameOverView(getModel());
    }

    @Override
    protected Controller<GameOverModel> getController() {
        return new GameOverController(getModel());
    }
}

