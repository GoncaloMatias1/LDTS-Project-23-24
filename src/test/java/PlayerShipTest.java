import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerShipTest {

    private PlayerShip playerShip;
    private final int screenWidth = 80; // Assume a screen width of 80 characters
    private Health health;

    @BeforeEach
    void setUp() {
        health = new Health(100);
        // Center the player ship horizontally on the screen
        playerShip = new PlayerShip(screenWidth / 2, 20, screenWidth, health);
    }

    @Test
    void moveLeft_ShouldNotMovePastLeftBoundary() {
        // Move the ship to the leftmost position
        for (int i = 0; i < screenWidth; i++) {
            playerShip.moveLeft();
        }
        // Assert that the x position of the ship is at the left boundary
        assertEquals(1, playerShip.getPosition().getX(), "Player ship should not move past left boundary");
    }

    @Test
    void moveRight_ShouldNotMovePastRightBoundary() {
        // Move the ship to the rightmost position
        for (int i = 0; i < screenWidth; i++) {
            playerShip.moveRight();
        }
        // Assert that the x position of the ship is at the right boundary
        assertEquals(screenWidth - 2, playerShip.getPosition().getX(), "Player ship should not move past right boundary");
    }
}
