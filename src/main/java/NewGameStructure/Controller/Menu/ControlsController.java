package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.Position;

import java.io.IOException;

public class ControlsController extends Controller<ControlsModel> {

    public ControlsController(ControlsModel model) {
        super(model);
    }

    @Override
    public void step(Application application, GUI.ACTION action) throws IOException {
        // Implement the action handling logic here
        if (action == GUI.ACTION.SHOOT) {
            System.out.println("SHOOT action received in ControlsController");
            handleSpacebar();
        }
    }

    public void handleSpacebar() {
        System.out.println("Spacebar pressed - Shooting");
        Position shipPosition = getModel().getPlayerShipPosition();
        Projectile projectile = new Projectile(shipPosition.getX(), shipPosition.getY() - 1);
        getModel().addProjectile(projectile);
    }
}

