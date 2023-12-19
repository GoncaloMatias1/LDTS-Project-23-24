package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.Menu.ArenaState;
import com.goncalomatias1.l05gr06.States.Menu.ControlsState;

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
                if (getModel().getSelectedItem() == 0) application.setState(new ArenaState(
                        new ArenaModel(application.getGui().getWidth(), application.getGui().getHeight())));
                if (getModel().getSelectedItem() == 1) application.setState(new ControlsState(new ControlsModel()));
                if (getModel().getSelectedItem() == 2) application.setState(null);
        }
    }
}
