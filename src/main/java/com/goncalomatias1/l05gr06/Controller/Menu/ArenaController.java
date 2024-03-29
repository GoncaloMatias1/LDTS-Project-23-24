package com.goncalomatias1.l05gr06.Controller.Menu;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Game.EnemyWave;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Shield;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import com.goncalomatias1.l05gr06.States.Menu.GameOverState;

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

        List<Shield> shields = getModel().getShields();
        gameOverArea = shields.isEmpty() ? 0 : shields.get(0).getPosition().getY();

        shootCooldown = 0;
    }
    @Override
    public void step(Application application, GUI.ACTION action) {
        int time = 10;
        int shootime = 4;

        // Enemy respawn
        if (getModel().getEnemyWave().getEnemies().isEmpty()){
            getModel().setEnemyWave(new EnemyWave());
            getModel().initializeShields(getModel().getWidth(), getModel().getHeight());
            steps = 76;
            hasToMoveDown = false;
            hasToMoveRight = true;
        }

        // The two conditions to losing:
        // 0 lives
        if (!getModel().getPlayerShip().isAlive()) {
            GameOverModel gameOverModel = new GameOverModel();
            gameOverModel.setCurrentScore(getModel().getScore());
            application.setState(new GameOverState(gameOverModel));
        }
        // Aliens reach shields
        List<Enemy> enemies = getModel().getEnemyWave().getEnemies();
        if (!enemies.isEmpty() && enemies.get(enemies.size() - 1).getPosition().getY() == gameOverArea) {
            GameOverModel gameOverModel = new GameOverModel();
            gameOverModel.setCurrentScore(getModel().getScore());
            application.setState(new GameOverState(gameOverModel));
        }

        // Enemy wave movement and shooting pattern
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

        // Update for entity statuses
        List<Enemy> killedEnemies = getModel().updateKills();
        getModel().increaseScore(killedEnemies.size());
        getModel().updatePlayerHit();

        // Player controls:
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
        // Cooldown between shots
        if (shootCooldown != shootime){
            shootCooldown++;
        }
    }

    public int getGameOverArea() {
        return gameOverArea;
    }
}

