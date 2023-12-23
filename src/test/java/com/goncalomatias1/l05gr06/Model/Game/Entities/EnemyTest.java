package com.goncalomatias1.l05gr06.Model.Game.Entities;

import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    private Enemy enemy;
    private final int startX = 5;
    private final int startY = 5;
    private final int initialLives = 3;
    private final int pointsAward = 10;

    @Mock
    private TextGraphics mockGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        enemy = new Enemy(startX, startY, initialLives, pointsAward);
    }

    @Test
    void enemyInitialization_withCorrectAttributes() {
        assertEquals(startX, enemy.getPosition().getX());
        assertEquals(startY, enemy.getPosition().getY());
        assertEquals(initialLives, enemy.getLives());
        assertEquals(pointsAward, enemy.getPointsAward());
    }

    @Test
    void moveLeft_ShouldDecrementXCoordinate() {
        enemy.moveLeft();
        assertEquals(startX - 1, enemy.getPosition().getX());
    }

    @Test
    void moveRight_ShouldIncrementXCoordinate() {
        enemy.moveRight();
        assertEquals(startX + 1, enemy.getPosition().getX());
    }

    @Test
    void moveDown_ShouldIncrementYCoordinate() {
        enemy.moveDown();
        assertEquals(startY + 1, enemy.getPosition().getY());
    }

    @Test
    void draw_ShouldInvokeCorrectMethods() {
        enemy.draw(mockGraphics);
        // Check that the correct color and character are set depending on pointsAward
        if (pointsAward == 50) {
            verify(mockGraphics).setForegroundColor(TextColor.ANSI.RED);
            verify(mockGraphics).setCharacter(startX, startY, 'M');
        } else {
            verify(mockGraphics).setForegroundColor(TextColor.ANSI.YELLOW);
            verify(mockGraphics).setCharacter(startX, startY, 'W');
        }
    }

    @Test
    void isAlive_ReturnsTrueWhenLivesAboveZero() {
        assertTrue(enemy.isAlive());
    }

    @Test
    void isAlive_ReturnsFalseWhenLivesAreZero() {
        for (int i = 0; i < initialLives; i++) {
            enemy.hit();
        }
        assertFalse(enemy.isAlive());
    }


    @Test
    void hit_ShouldDecreaseLivesByOne() {
        int livesBefore = enemy.getLives();
        enemy.hit();
        assertEquals(livesBefore - 1, enemy.getLives());
    }

    @Test
    void shoot_ReturnsProjectileInCorrectPosition() {
        Projectile projectile = enemy.shoot();
        assertEquals(enemy.getPosition().getX(), projectile.getPosition().getX());
        assertEquals(enemy.getPosition().getY() + 1, projectile.getPosition().getY());
    }

    @Test
    void turnToMysteryShip_ShouldSetLivesAndPoints() {
        enemy.turnToMisteryShip();
        assertEquals(3, enemy.getLives());
        assertEquals(50, enemy.getPointsAward());
    }

    @Test
    void isAlive_ReturnsFalseWhenLivesAreNegative() {
        enemy.setLives(-1);

        assertFalse(enemy.isAlive());
    }

}
