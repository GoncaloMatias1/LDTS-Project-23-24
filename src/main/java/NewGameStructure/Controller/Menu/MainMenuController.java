package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.MainMenuModel;

public class MainMenuController extends Controller<MainMenuModel> {
    public MainMenuController(MainMenuModel mainMenuModel){
        super(mainMenuModel);
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

        }
    }
}
