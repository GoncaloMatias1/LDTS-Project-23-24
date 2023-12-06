package NewGameStructure.States.Menu;

import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.ArenaController;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.ArenaView;
import NewGameStructure.View.View;

public class ArenaState extends State<ArenaModel>{
    public ArenaState(ArenaModel arenaModel){
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
