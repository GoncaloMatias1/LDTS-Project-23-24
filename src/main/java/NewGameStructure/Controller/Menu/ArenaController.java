package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;

public class ArenaController extends Controller<ArenaModel> {
    public ArenaController(ArenaModel arenaModel){
        super(arenaModel);
    }

    @Override
    public void step(Application application, GUI.ACTION action){
        switch (action){
            case RIGHT:
                getModel().movePlayerShipRight();
                break; // Break statement added here
            case LEFT:
                getModel().movePlayerShipLeft();
                break; // Break statement added here
        }
    }
}
