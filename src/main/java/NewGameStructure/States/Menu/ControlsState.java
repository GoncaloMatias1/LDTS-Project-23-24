package NewGameStructure.States.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Menu.ControlsController;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.ControlsView;

import java.io.IOException;

public class ControlsState extends State<ControlsModel> {

    public ControlsState(ControlsModel model) {
        super(model);
        System.out.println("ControlsState initialized");
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        System.out.println("ControlsState step method"); // This should print on each game loop iteration
        super.step(app, gui); // Calls the controller's step method
    }

    @Override
    protected ControlsView getView() {
        return new ControlsView(getModel());
    }

    @Override
    protected ControlsController getController() {
        return new ControlsController(getModel());
    }
}


