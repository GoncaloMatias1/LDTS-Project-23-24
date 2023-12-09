package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.MainMenuState;

public class ControlsController extends Controller<ControlsModel> {
    public ControlsController(ControlsModel controlsModel){
        super(controlsModel);
    }

    @Override
    public void step(Application application, GUI.ACTION action){
        switch (action){
            case BACK:
                application.setState(new MainMenuState(new MainMenuModel()));
        }
    }
}

