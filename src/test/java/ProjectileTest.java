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
        projectile = new Projectile(5, 5);
        Enemy enemy = new Enemy(5, 4, 3, 10);
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
        Enemy enemy = new Enemy(5, 4, 3, 10);

        projectile.update();

        assertTrue(projectile.checkCollision(enemy), "Projectile should collide with enemy at the same position");
    }


    @Test
    void testProjectilePlayerCollision() {
        projectile.updateEnemyBullet();
        assertTrue(projectile.checkPlayerCollision(playerShip));
    }
}
