import NewGameStructure.Application;
import NewGameStructure.Controller.Menu.ArenaController;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.EnemyWave;
import NewGameStructure.Model.Game.Projectile;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Position;
import NewGameStructure.States.Menu.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MonstersTest {
    private ArenaModel arenaModel;
    private ArenaController arenaController;
    private Application application;
    private Enemy enemy;
    private EnemyWave enemyWave;

    private EnemyWave enemyWave2;

    @BeforeEach
    void setUp() throws IOException {
        // Initialize the ArenaModel with the appropriate dimensions and entities
        arenaModel = new ArenaModel(100, 30);
        arenaController = new ArenaController(arenaModel);

        application = mock(Application.class);

        enemy = new Enemy(5, 5, 1);
        enemyWave = new EnemyWave();
        enemyWave.getEnemies().add(enemy);

        // Initialize an enemy wave and add it to the arena model
        enemyWave2 = arenaModel.getEnemyWave();
        for (int i = 0; i < 5; i++) { // Assuming you want a few enemies for the test
            enemyWave2.getEnemies().add(new Enemy(5, i, 1));
        }

        // Set the last enemy's position to trigger game over
        Enemy lastEnemy = enemyWave2.getEnemies().get(enemyWave2.getEnemies().size() - 1);
        lastEnemy.getPosition().setY(arenaModel.getShields().get(0).getPosition().getY());
    }

    @Test
    void testEnemyMovement() {
        int initialX = enemy.getPosition().getX();
        int initialY = enemy.getPosition().getY();

        enemy.moveLeft();
        assertEquals(initialX - 1, enemy.getPosition().getX());

        enemy.moveRight();
        assertEquals(initialX, enemy.getPosition().getX());

        enemy.moveDown();
        assertEquals(initialY + 1, enemy.getPosition().getY());

    }

    @Test
    void testEnemyHit() {
        enemy.hit();
        assertFalse(enemy.isAlive());
    }

    @Test
    void testEnemyShot() {
        Projectile projectile = enemy.shoot();
        assertNotNull(projectile);
        assertEquals(enemy.getPosition().getY() + 1, projectile.getPosition().getY());
    }

    @Test
    void testEnemyWaveInitialization() {
        assertFalse(enemyWave.getEnemies().isEmpty());
    }

    @Test
    void testEnemyWaveMovementRight() {
        // Store initial positions
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        // Move enemies right
        enemyWave.moveEnemiesRight();

        // Check if all enemies have moved right by 1 position
        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getX() + 1, enemy.getPosition().getX());
        }
    }

    @Test
    void testEnemyWaveMovementLeft() {
        // Store initial positions
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        // Move enemies left
        enemyWave.moveEnemiesLeft();

        // Check if all enemies have moved left by 1 position
        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getX() - 1, enemy.getPosition().getX());
        }
    }

    @Test
    void testEnemyWaveMovementDown() {
        // Store initial positions
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        // Move enemies down
        enemyWave.moveEnemiesDown();

        // Check if all enemies have moved down by 1 position
        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getY() + 1, enemy.getPosition().getY());
        }
    }

    @Test
    void testEnemyRemoval() {
        int initialSize = enemyWave.getEnemies().size();
        enemyWave.removeEnemies(List.of(enemy));
        assertEquals(initialSize - 1, enemyWave.getEnemies().size());
    }

    @Test
    void testGameOverWhenEnemyReachesShield() {
        // Simulate the game loop step where the last enemy reaches the shield
        arenaController.step(application, GUI.ACTION.NONE); // Replace with a non-null action if necessary

        // Verify that the application's setState method was called with a GameOverState instance
        verify(application).setState(any(GameOverState.class));
    }
}
