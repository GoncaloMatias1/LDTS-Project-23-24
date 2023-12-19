package com.goncalomatias1.l05gr06.Controller.Game;


import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.goncalomatias1.l05gr06.Position;
import com.goncalomatias1.l05gr06.Model.Game.EntityModel;

import java.util.List;

public class EntityController {
    private List<Projectile> projectiles;
    private List<Enemy> enemies;
    private EntityModel model;

    public EntityController(EntityModel model) {
        this.model = model;
    }
    public void updateEntities() {
        for (Projectile projectile : projectiles) {
            projectile.update(); // Move the projectile
            for (Enemy enemy : enemies) {
                if (projectile.checkCollision(enemy)) {
                    enemy.hit();
                }
            }
        }
    }



    public void moveEntity(int deltaX, int deltaY) {
        Position position = model.getPosition();
        position.setX(position.getX() + deltaX);
        position.setY(position.getY() + deltaY);
    }
}

