package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;

public class GameOverController extends Controller<GameOverModel> {
    public GameOverController(GameOverModel gameOverModel){
        super(gameOverModel);
    }
    @Override
    public void step(Application application, GUI.ACTION action) {
        switch(action){
            case UP:
                getModel().removeEntry();
                break;
            case DOWN:
                getModel().addEntry();
                break;
            case ENTER:
                if (getModel().getSelectedItem() == 0) application.setState(new MainMenuState(new MainMenuModel()));
                if (getModel().getSelectedItem() == 1) application.setState(null);
        }
    }
}
