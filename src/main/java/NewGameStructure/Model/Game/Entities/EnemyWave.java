package NewGameStructure.Model.Game.Entities;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class EnemyWave {
    private List<Enemy> enemies = new ArrayList<>();
    public List<Enemy> getEnemies(){
        return enemies;
    }
    public EnemyWave(){
        for (int i = 5; i<=11; i=i+3){
            for (int j = 1; j<=76; j=j+5){
                Enemy newenemy = new Enemy(j, i, 1);
                enemies.add(newenemy);
            }
        }
    }
    public void draw(TextGraphics graphics){
        for (Enemy enemy : enemies){
            enemy.draw(graphics);
        }
    }
}
