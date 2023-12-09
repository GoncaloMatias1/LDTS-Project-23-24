package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.ArenaState;
import NewGameStructure.States.Menu.ControlsState;

public class MainMenuController extends Controller<MainMenuModel> {
    private Application application;
    public MainMenuController(MainMenuModel mainMenuModel, Application application){
        super(mainMenuModel);
        this.application = application;
    }

    @Override
    public void step(Application application, GUI.ACTION action){
        switch(action){
            case UP:
                getModel().removeEntry();
                break;
            case DOWN:
                getModel().addEntry();
                break;
            case ENTER:
                if (getModel().getSelectedItem() == 0) application.setState(new ArenaState(
                        new ArenaModel(application.getGui().getWidth(), application.getGui().getHeight())));
                if (getModel().getSelectedItem() == 1) application.setState(new ControlsState(new ControlsModel()));
                if (getModel().getSelectedItem() == 2) application.setState(null);
        }
    }
}
