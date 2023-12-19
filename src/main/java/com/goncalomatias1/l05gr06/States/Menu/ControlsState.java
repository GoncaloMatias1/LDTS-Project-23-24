package com.goncalomatias1.l05gr06.States.Menu;

import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.Controller.Menu.ControlsController;
import com.goncalomatias1.l05gr06.Model.Menu.ControlsModel;
import com.goncalomatias1.l05gr06.States.State;
import com.goncalomatias1.l05gr06.View.Menu.ControlsView;
import com.goncalomatias1.l05gr06.View.View;

public class ControlsState extends State<ControlsModel> {
    public ControlsState(ControlsModel controlsModel){
        super(controlsModel);
    }

    @Override
    protected View<ControlsModel> getView() {
        return new ControlsView(getModel());
    }

    @Override
    protected Controller<ControlsModel> getController() {
        return new ControlsController(getModel());
    }
}


