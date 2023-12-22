package com.goncalomatias1.l05gr06.Model.Game.Entities;

import com.goncalomatias1.l05gr06.Model.Game.Entities.PlayerShip;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PlayerShipTest {

    private PlayerShip playerShip;
    private final int screenWidth = 80;
    private final int initialLives = 3;

    @Mock
    private TextGraphics mockGraphics;

    @Mock
    private Projectile mockProjectile;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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

    @Test
    void draw_ShouldInvokeGraphicsSetCharacter() {
        playerShip.draw(mockGraphics);
        verify(mockGraphics).setCharacter(anyInt(), anyInt(), any(TextCharacter.class));
    }

    @Test
    void shoot_ShouldCreateProjectileAtCorrectPosition() {
        var projectile = playerShip.shoot();

        assertNotNull(projectile, "Shoot should create a new projectile");
        assertEquals(playerShip.getPosition().getX(), projectile.getPosition().getX(), "Projectile X should match player ship's X");
        assertEquals(playerShip.getPosition().getY() - 1, projectile.getPosition().getY(), "Projectile should be just above the player ship");
    }
}
