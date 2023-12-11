package NewGameStructure.Controller.Game;


import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Position;
import NewGameStructure.Model.Game.EntityModel;

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
        // Remove projectiles that have gone off-screen or hit an enemy
        // Update enemy positions or behaviors
    }



    public void moveEntity(int deltaX, int deltaY) {
        Position position = model.getPosition();
        position.setX(position.getX() + deltaX);
        position.setY(position.getY() + deltaY);
    }
}

