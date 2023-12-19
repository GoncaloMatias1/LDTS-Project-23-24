package com.goncalomatias1.l05gr06.Model.Game;

import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyWave {
    private List<Enemy> enemies = new ArrayList<>();
    public List<Enemy> getEnemies(){
        return enemies;
    }
    public EnemyWave(){
        for (int i = 5; i<=11; i=i+3){
            for (int j = 1; j<=76; j=j+5){
                Enemy newenemy = new Enemy(j, i, 1, 10);
                enemies.add(newenemy);
            }
        }
        for (int i = 0; i<3; i++){
            Random rand = new Random();
            Enemy chosenEnemy = enemies.get(rand.nextInt(enemies.size()));
            chosenEnemy.turnToMisteryShip();
        }
    }
    public void draw(TextGraphics graphics){
        for (Enemy enemy : enemies){
            enemy.draw(graphics);
        }
    }
    public Projectile randomShot(){
        Random rand = new Random();
        Enemy chosenEnemy = enemies.get(rand.nextInt(enemies.size()));
        return chosenEnemy.shoot();
    }

    public void moveEnemiesRight(){
        for(Enemy enemy : enemies){
            enemy.moveRight();
        }
    }
    public void moveEnemiesLeft(){
        for(Enemy enemy : enemies){
            enemy.moveLeft();
        }
    }
    public void moveEnemiesDown(){
        for(Enemy enemy : enemies){
            enemy.moveDown();
        }
    }

}
