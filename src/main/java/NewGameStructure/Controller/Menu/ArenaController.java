package NewGameStructure.Controller.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.EnemyWave;
import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.GameOverModel;
import NewGameStructure.States.Menu.ArenaState;
import NewGameStructure.States.Menu.GameOverState;

import java.util.List;

public class ArenaController extends Controller<ArenaModel> {
    private int cooldown;
    private int steps;
    private boolean hasToMoveDown;
    private boolean hasToMoveRight;
    private int gameOverArea;
    private int shootCooldown;

    public ArenaController(ArenaModel arenaModel) {
        super(arenaModel);
        cooldown = 0;
        steps = 76;
        hasToMoveDown = false;
        hasToMoveRight = true;
        gameOverArea = getModel().getShields().get(0).getPosition().getY();
        shootCooldown = 0;
    }

    @Override
    public void step(Application application, GUI.ACTION action) {
        int time = 10;
        int shootime = 4;
        if (getModel().getEnemyWave().getEnemies().isEmpty()){
            getModel().setEnemyWave(new EnemyWave());
            getModel().initializeShields(getModel().getWidth(), getModel().getHeight());
            steps = 76;
            hasToMoveDown = false;
            hasToMoveRight = true;
        }
        if (!getModel().getPlayerShip().isAlive()) {
            GameOverModel gameOverModel = new GameOverModel();
            gameOverModel.setCurrentScore(getModel().getScore());
            application.setState(new GameOverState(gameOverModel));
        }
        if (getModel().getEnemyWave().getEnemies().get(getModel().getEnemyWave().getEnemies().size() - 1).getPosition().getY() == gameOverArea) {
            GameOverModel gameOverModel = new GameOverModel();
            gameOverModel.setCurrentScore(getModel().getScore());
            application.setState(new GameOverState(gameOverModel));
        }
        if (cooldown == time) {
            getModel().enemyShoot();
            cooldown = 0;
            if (!hasToMoveDown) {
                if (hasToMoveRight) {
                    getModel().getEnemyWave().moveEnemiesRight();
                    steps++;
                    if (steps == 98) {
                        hasToMoveRight = false;
                        hasToMoveDown = true;
                    }
                } else {
                    getModel().getEnemyWave().moveEnemiesLeft();
                    steps--;
                    if (steps == 76) {
                        hasToMoveRight = true;
                        hasToMoveDown = true;
                    }
                }
            } else {
                getModel().getEnemyWave().moveEnemiesDown();
                hasToMoveDown = false;
            }
        } else cooldown++;
        List<Enemy> killedEnemies = getModel().updateKills();
        getModel().increaseScore(killedEnemies.size());
        getModel().updatePlayerHit();

        switch (action) {
            case RIGHT:
                getModel().movePlayerShipRight();
                break;
            case LEFT:
                getModel().movePlayerShipLeft();
                break;
            case ENTER:
                if(shootCooldown == shootime) {
                    getModel().playerShoot();
                    shootCooldown = 0;
                }
                break;
        }
        if (shootCooldown != shootime){
            shootCooldown++;
        }
    }
}
