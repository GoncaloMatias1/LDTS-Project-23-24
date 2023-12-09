package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import NewGameStructure.Model.Game.Entities.Projectile;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int width;
    private int height;
    private PlayerShip playerShip;

    public ArenaModel(int width, int height) {
        this.width = width;
        this.height = height;
        int initialHealthPoints = 100;
        Health playerHealth = new Health(initialHealthPoints);
        this.playerShip = new PlayerShip(width / 2, height - 3, width, playerHealth);
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public PlayerShip getPlayerShip() { return playerShip; }

    // Métodos para atualizar o modelo
    public void movePlayerShipLeft() {
        playerShip.moveLeft();
    }

    public void movePlayerShipRight() {
        playerShip.moveRight();
    }

    private List<Projectile> projectiles = new ArrayList<>();

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void updateProjectiles() {
        // Move projectiles and remove if they go off-screen
        projectiles.forEach(Projectile::update);
        projectiles.removeIf(p -> p.getPosition().getY() < 0);
    }

    public void playerShoot() {
        projectiles.add(playerShip.shoot());
    }
}
