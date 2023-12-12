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
    private int cooldown;
    private int steps;
    private boolean hasToMoveDown;
    private boolean hasToMoveRight;
    private int gameOverArea;
    public ArenaController(ArenaModel arenaModel){
        super(arenaModel);
        cooldown = 0;
        steps = 76;
        hasToMoveDown = false;
        hasToMoveRight = true;
        gameOverArea = getModel().getShields().get(0).getPosition().getY();
    }


    @Override
    public void step(Application application, GUI.ACTION action){
        int time = 4;
        if (!getModel().getPlayerShip().isAlive()){
            application.setState(new GameOverState(new GameOverModel()));
        }
        if (getModel().getEnemyWave().getEnemies().get(getModel().getEnemyWave().getEnemies().size()-1).getPosition().getY() == gameOverArea){
            application.setState(new GameOverState(new GameOverModel()));
        }
        if(cooldown == time){
            getModel().enemyShoot();
            cooldown = 0;
            if(!hasToMoveDown){
                if(hasToMoveRight){
                    getModel().getEnemyWave().moveEnemiesRight();
                    steps++;
                    if(steps == 98){
                        hasToMoveRight = false;
                        hasToMoveDown = true;
                    }
                }
                else{
                    getModel().getEnemyWave().moveEnemiesLeft();
                    steps--;
                    if(steps == 76){
                        hasToMoveRight = true;
                        hasToMoveDown = true;
                    }
                }
            }
            else {
                getModel().getEnemyWave().moveEnemiesDown();
                hasToMoveDown = false;
            }
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
}



