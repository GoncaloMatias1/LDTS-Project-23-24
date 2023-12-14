import NewGameStructure.Model.Game.Entities.PlayerShip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerShipTest {

    private PlayerShip playerShip;
    private final int screenWidth = 80;
    private final int initialLives = 3;

    @BeforeEach
    void setUp() {
        playerShip = new PlayerShip(screenWidth / 2, 20, screenWidth, initialLives);
    }

    @Test
    void moveLeft_ShouldNotMovePastLeftBoundary() {
        for (int i = 0; i < screenWidth; i++) {
            playerShip.moveLeft();
        }
        assertEquals(1, playerShip.getPosition().getX(), "Player ship should not move past left boundary");
    }

    @Test
    void moveRight_ShouldNotMovePastRightBoundary() {
        for (int i = 0; i < screenWidth; i++) {
            playerShip.moveRight();
        }
        assertEquals(screenWidth - 2, playerShip.getPosition().getX(), "Player ship should not move past right boundary");
    }

    @Test
    void loseLife_ShouldDecreaseLivesByOne() {
        int livesBefore = playerShip.getLives();
        playerShip.loseLife();
        assertEquals(livesBefore - 1, playerShip.getLives(), "Lose life should decrease lives by one");
    }

    @Test
    void isAlive_WhenLivesAboveZero_ShouldReturnTrue() {
        assertTrue(playerShip.isAlive(), "Player should be alive when lives are above zero");
    }

    @Test
    void isAlive_WhenLivesZero_ShouldReturnFalse() {
        playerShip.setLives(0);
        assertFalse(playerShip.isAlive(), "Player should not be alive when lives are zero");
    }
}
