package com.goncalomatias1.l05gr06.Model.Menu;

import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.goncalomatias1.l05gr06.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class ArenaModelTest {
    private ArenaModel arenaModel;
    private final int width = 20;
    private final int height = 15;

    @BeforeEach
    void setUp() {
        arenaModel = new ArenaModel(width, height);
    }

    @Test
    void playerShipShouldMoveLeft() {
        int initialX = arenaModel.getPlayerShip().getPosition().getX();
        arenaModel.movePlayerShipLeft();
        assertEquals(initialX - 1, arenaModel.getPlayerShip().getPosition().getX());
    }

    @Test
    void playerShipShouldMoveRight() {
        int initialX = arenaModel.getPlayerShip().getPosition().getX();
        arenaModel.movePlayerShipRight();
        assertEquals(initialX + 1, arenaModel.getPlayerShip().getPosition().getX());
    }

    @Test
    void playerShootShouldAddProjectile() {
        arenaModel.playerShoot();
        assertFalse(arenaModel.getProjectiles().isEmpty());
    }

    @Test
    void enemyShootShouldAddProjectile() {
        arenaModel.enemyShoot();
        assertFalse(arenaModel.getEnemyProjectiles().isEmpty());
    }

    @Test
    void initializeShieldsShouldCreateShields() {
        arenaModel.initializeShields(width, height);
        assertFalse(arenaModel.getShields().isEmpty());
    }

    @Test
    void increaseScoreShouldAddPoints() {
        int initialScore = arenaModel.getScore();
        int pointsToAdd = 10;
        arenaModel.increaseScore(pointsToAdd);
        assertEquals(initialScore + pointsToAdd, arenaModel.getScore());
    }

    @Test
    void playerHitShouldDecreaseLives() {
        int initialLives = arenaModel.getPlayerShip().getLives();
        arenaModel.playerHit();
        assertEquals(initialLives - 1, arenaModel.getPlayerShip().getLives());
    }


}
