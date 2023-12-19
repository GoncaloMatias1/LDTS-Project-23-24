package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;

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

