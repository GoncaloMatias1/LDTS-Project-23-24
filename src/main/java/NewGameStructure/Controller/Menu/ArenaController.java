package NewGameStructure.Controller.Menu;


import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class ArenaController extends Controller<ArenaModel> {
    public ArenaController(ArenaModel arenaModel){
        super(arenaModel);
    }
    @Override
    public void step(Application application, GUI.ACTION action){
        switch (action){
            case RIGHT:
                getModel().movePlayerShipRight();
            case LEFT:
                getModel().movePlayerShipLeft();
        }
    }
}

