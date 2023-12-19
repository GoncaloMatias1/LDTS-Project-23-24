package com.goncalomatias1.l05gr06.States.Menu;

import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.Controller.Menu.GameOverController;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.States.State;
import com.goncalomatias1.l05gr06.View.Menu.GameOverView;
import com.goncalomatias1.l05gr06.View.View;

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

