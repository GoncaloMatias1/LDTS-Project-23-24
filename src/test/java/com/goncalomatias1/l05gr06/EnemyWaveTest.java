package com.goncalomatias1.l05gr06;

import com.goncalomatias1.l05gr06.Model.Game.EnemyWave;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

class EnemyWaveTest {

    private EnemyWave enemyWave;
    private TextGraphics mockGraphics;

    @BeforeEach
    void setUp() {
        mockGraphics = Mockito.mock(TextGraphics.class);
        enemyWave = new EnemyWave();
    }

    @Test
    void enemyWaveInitialization_createsCorrectNumberOfEnemies() {
        List<Enemy> enemies = enemyWave.getEnemies();
        assertEquals(48, enemies.size());
    }


    @Test
    void draw_invokesDrawOnAllEnemies() {
        // Arrange
        EnemyWave enemyWave = new EnemyWave();
        TextGraphics mockGraphics = mock(TextGraphics.class);

        // Act
        enemyWave.draw(mockGraphics);

        // Assert
        for (Enemy enemy : enemyWave.getEnemies()) {
            Position pos = enemy.getPosition();
            verify(mockGraphics).setCharacter(eq(pos.getX()), eq(pos.getY()), anyChar());
        }
    }



    @Test
    void randomShot_returnsProjectile() {
        Projectile projectile = enemyWave.randomShot();
        assertNotNull(projectile);
    }

    @Test
    void moveEnemiesRight_movesAllEnemiesRight() {
        List<Enemy> enemies = enemyWave.getEnemies();
        List<Integer> initialXPositions = getXPositions(enemies);

        enemyWave.moveEnemiesRight();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            assertEquals(initialXPositions.get(i) + 1, enemy.getPosition().getX());
        }
    }

    @Test
    void moveEnemiesLeft_movesAllEnemiesLeft() {
        List<Enemy> enemies = enemyWave.getEnemies();
        List<Integer> initialXPositions = getXPositions(enemies);

        enemyWave.moveEnemiesLeft();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            assertEquals(initialXPositions.get(i) - 1, enemy.getPosition().getX());
        }
    }

    @Test
    void moveEnemiesDown_movesAllEnemiesDown() {
        List<Enemy> enemies = enemyWave.getEnemies();
        List<Integer> initialYPositions = getYPositions(enemies);

        enemyWave.moveEnemiesDown();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            assertEquals(initialYPositions.get(i) + 1, enemy.getPosition().getY());
        }
    }

    private List<Integer> getXPositions(List<Enemy> enemies) {
        List<Integer> positions = new ArrayList<>();
        for (Enemy enemy : enemies) {
            positions.add(enemy.getPosition().getX());
        }
        return positions;
    }

    private List<Integer> getYPositions(List<Enemy> enemies) {
        List<Integer> positions = new ArrayList<>();
        for (Enemy enemy : enemies) {
            positions.add(enemy.getPosition().getY());
        }
        return positions;
    }
}
