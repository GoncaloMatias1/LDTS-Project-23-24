package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ControlsModel {
    private List<Projectile> projectiles = new ArrayList<>();
    private ArenaModel arenaModel;

    public ControlsModel(ArenaModel arenaModel) {
        this.arenaModel = arenaModel;
    }
    public Position getPlayerShipPosition() {
        return arenaModel.getPlayerShip().getPosition();
    }

    public void update() {
        Iterator<Projectile> iterator = projectiles.iterator();
        while (iterator.hasNext()) {
            Projectile projectile = iterator.next();
            projectile.update();
            if (projectile.getPosition().getY() < 0) {
                iterator.remove();
            }
        }
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }
}

