package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Game.Entities.Shield;
import NewGameStructure.Position;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int width;
    private int height;
    private PlayerShip playerShip;
    private List<Projectile> projectiles = new ArrayList<>();

    private List<Shield> shields = new ArrayList<>();


    public ArenaModel(int width, int height) {
        this.width = width;
        this.height = height;
        int initialHealthPoints = 100;
        Health playerHealth = new Health(initialHealthPoints);
        this.playerShip = new PlayerShip(width / 2, height - 3, width, playerHealth);
        initializeShields(width, height);
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

    private void initializeShields(int width, int height) {
        int shieldSpacing = width / 6; // Example spacing value
        int shieldY = height - 10; // Example Y position, adjust as needed
        for (int i = 0; i < 5; i++) {
            shields.add(new Shield(new Position(10+ i * shieldSpacing + shieldSpacing / 2, shieldY)));
        }
    }

    public List<Shield> getShields() {
        return shields;
    }
}
