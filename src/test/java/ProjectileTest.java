import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.PlayerShip;
import NewGameStructure.Model.Game.Projectile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    private Projectile projectile;
    private Enemy enemy;
    private PlayerShip playerShip;

    @BeforeEach
    void setUp() {
        // Setup initial positions for the projectile, enemy, and playerShip
        projectile = new Projectile(5, 5);
        Enemy enemy = new Enemy(5, 4, 3); // Example: starting at (5,4) with 3 lives
        playerShip = new PlayerShip(5, 6,80,3);
    }

    @Test
    void testProjectileInitialization() {
        assertEquals(5, projectile.getPosition().getX());
        assertEquals(5, projectile.getPosition().getY());
    }

    @Test
    void testProjectileMovement() {
        projectile.update();
        assertEquals(4, projectile.getPosition().getY());
    }

    @Test
    void testProjectileEnemyCollision() {
        // Instantiate enemy with starting position (5, 4) and initial lives (for example, 3)
        Enemy enemy = new Enemy(5, 4, 3);

        // Update the projectile's position to test the collision
        projectile.update();

        // Check for collision
        assertTrue(projectile.checkCollision(enemy), "Projectile should collide with enemy at the same position");
    }


    @Test
    void testProjectilePlayerCollision() {
        // Simulate the enemy shooting
        projectile.updateEnemyBullet();
        assertTrue(projectile.checkPlayerCollision(playerShip));
    }
}
