package com.goncalomatias1.l05gr06;

import com.goncalomatias1.l05gr06.Controller.Menu.ArenaController;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.EnemyWave;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.States.Menu.GameOverState;
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
        arenaModel = new ArenaModel(100, 30);
        arenaController = new ArenaController(arenaModel);

        application = mock(Application.class);

        enemy = new Enemy(5, 5, 1, 10);
        enemyWave = new EnemyWave();
        enemyWave.getEnemies().add(enemy);

        enemyWave2 = arenaModel.getEnemyWave();
        for (int i = 0; i < 5; i++) {
            enemyWave2.getEnemies().add(new Enemy(5, i, 1, 10));
        }

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
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        enemyWave.moveEnemiesRight();

        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getX() + 1, enemy.getPosition().getX());
        }
    }

    @Test
    void testEnemyWaveMovementLeft() {
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        enemyWave.moveEnemiesLeft();

        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getX() - 1, enemy.getPosition().getX());
        }
    }

    @Test
    void testEnemyWaveMovementDown() {
        List<Position> initialPositions = enemyWave.getEnemies().stream()
                .map(Enemy::getPosition)
                .map(p -> new Position(p.getX(), p.getY()))
                .collect(Collectors.toList());

        enemyWave.moveEnemiesDown();

        for (int i = 0; i < enemyWave.getEnemies().size(); i++) {
            Enemy enemy = enemyWave.getEnemies().get(i);
            Position initialPosition = initialPositions.get(i);
            assertEquals(initialPosition.getY() + 1, enemy.getPosition().getY());
        }
    }


    @Test
    void testGameOverWhenEnemyReachesShield() {
        arenaController.step(application, GUI.ACTION.NONE);

        verify(application).setState(any(GameOverState.class));
    }
}
