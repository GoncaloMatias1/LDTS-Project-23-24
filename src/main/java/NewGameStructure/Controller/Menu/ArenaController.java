package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.States.Menu.GameOverState;

import java.util.ArrayList;
import java.util.List;

public class ArenaController extends Controller<ArenaModel> {
    public ArenaController(ArenaModel arenaModel){
        super(arenaModel);
        cooldown = 0;
    }
    private int cooldown;

    @Override
    public void step(Application application, GUI.ACTION action){
        int time = 3;
        if (!getModel().getPlayerShip().isAlive()){
            application.setState(new GameOverState(new GameOverModel()));
        }
        if(cooldown == time){
            getModel().enemyShoot();
            cooldown = 0;
        }
        else cooldown++;
        getModel().updateKills();
        getModel().updatePlayerHit();
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


        // Remove projectiles that have gone off-screen or hit an enemy
        // Update enemy positions or behaviors
}



