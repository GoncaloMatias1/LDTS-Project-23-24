package NewGameStructure.States.Menu;

import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.ControlsController;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.ControlsView;
import NewGameStructure.View.View;

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


