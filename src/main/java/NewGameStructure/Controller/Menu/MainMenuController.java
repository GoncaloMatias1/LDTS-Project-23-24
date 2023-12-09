package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.ArenaState;

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
                        new ArenaModel(100, 30)));

        }
    }
}
