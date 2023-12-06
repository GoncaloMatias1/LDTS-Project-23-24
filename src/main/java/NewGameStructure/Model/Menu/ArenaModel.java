package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Model.Game.Entities.PlayerShip;
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
}
