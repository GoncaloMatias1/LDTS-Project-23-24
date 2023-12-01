package NewGameStructure.Controller.Menu;


import NewGameStructure.Model.Menu.ArenaModel;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class ArenaController {
    private ArenaModel model;

    public ArenaController(ArenaModel model) {
        this.model = model;
    }

    public void handleInput(KeyStroke keyStroke) {
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
            model.movePlayerShipLeft();
        } else if (keyStroke.getKeyType() == KeyType.ArrowRight) {
            model.movePlayerShipRight();
        }
    }
}

