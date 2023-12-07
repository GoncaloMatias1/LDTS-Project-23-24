package NewGameStructure.View.Menu;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.View.View;

public class ControlsView extends View<ControlsModel> {
    public ControlsView(ControlsModel controlsModel){
        super(controlsModel);
    }

    @Override
    public void draw(GUI gui){
        gui.getScreen().clear();
    }
}
