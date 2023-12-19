package com.goncalomatias1.l05gr06.States.Menu;

import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.Controller.Menu.ArenaController;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.States.State;
import com.goncalomatias1.l05gr06.View.Menu.ArenaView;
import com.goncalomatias1.l05gr06.View.View;


public class ArenaState extends State<ArenaModel> {

    public ArenaState(ArenaModel arenaModel) {
        super(arenaModel);
    }

    @Override
    protected View<ArenaModel> getView() {
        return new ArenaView(getModel());
    }

    @Override
    protected Controller<ArenaModel> getController() {
        return new ArenaController(getModel());
    }

}
