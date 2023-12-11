package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.States.Menu.GameOverState;

public class ArenaController extends Controller<ArenaModel> {
    public ArenaController(ArenaModel arenaModel){
        super(arenaModel);
    }

    @Override
    public void step(Application application, GUI.ACTION action){
        if (!getModel().getPlayerShip().isAlive()){
            application.setState(new GameOverState(new GameOverModel()));
        }

        switch (action){
            case RIGHT:
                getModel().movePlayerShipRight();
                break;
            case LEFT:
                getModel().movePlayerShipLeft();
                break;
            case ENTER:
                getModel().playerShoot();
                break;
        }
    }

    public void updateEntities() {
        for (Projectile projectile : getModel().getProjectiles()) {
            projectile.update(); // Move the projectile
            for (Enemy enemy : enemies) {
                if (projectile.checkCollision(enemy)) {
                    enemy.hit();
                }
            }
        }
        // Remove projectiles that have gone off-screen or hit an enemy
        // Update enemy positions or behaviors
    }
}


