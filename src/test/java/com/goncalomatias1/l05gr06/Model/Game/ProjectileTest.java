package com.goncalomatias1.l05gr06.Model.Game;

import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Entities.PlayerShip;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

class ProjectileTest {

    private Projectile projectile;
    private Enemy enemy;
    private PlayerShip playerShip;
    private final int projectileStartX = 5;
    private final int projectileStartY = 5;
    private final int screenWidth = 80;
    private final int initialLives = 3;

    @Mock
    private TextGraphics mockGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        enemy = new Enemy(projectileStartX, projectileStartY, 3, 10);
        playerShip = new PlayerShip(screenWidth / 2, 20, screenWidth, initialLives);
        projectile = new Projectile(projectileStartX, projectileStartY - 1);
    }

    @Test
    void testProjectileInitialization() {
        assertNotNull(projectile, "Projectile should be initialized");
        assertEquals(projectileStartX, projectile.getPosition().getX(), "Projectile X position should be initialized correctly");
        assertEquals(projectileStartY - 1, projectile.getPosition().getY(), "Projectile Y position should be initialized correctly");
    }

    @Test
    void testProjectileMovement() {
        projectile.update();
        assertEquals(projectileStartY - 2, projectile.getPosition().getY(), "Projectile should move up by speed units after update");
    }

    @Test
    void testProjectileEnemyCollision() {
        projectile = new Projectile(enemy.getPosition().getX(), enemy.getPosition().getY());
        assertTrue(projectile.checkCollision(enemy), "Projectile should collide with enemy at the same position");
    }

    @Test
    void testProjectilePlayerCollision() {
        Projectile enemyProjectile = new Projectile(playerShip.getPosition().getX(), playerShip.getPosition().getY() - 1);

        enemyProjectile.updateEnemyBullet();

        assertTrue(enemyProjectile.checkPlayerCollision(playerShip), "Enemy projectile should collide with player ship");
    }


    @Test
    void draw_ShouldInvokeGraphicsSetCharacter() {
        projectile.draw(mockGraphics);
        verify(mockGraphics).setCharacter(eq(projectile.getPosition().getX()), eq(projectile.getPosition().getY()), eq('|'));
    }


    @Test
    void shoot_ShouldReturnProjectileAtCorrectPosition() {
        Projectile newProjectile = playerShip.shoot();
        assertEquals(playerShip.getPosition().getX(), newProjectile.getPosition().getX(), "Projectile X position should match player ship's X position");
        assertEquals(playerShip.getPosition().getY() - 1, newProjectile.getPosition().getY(), "Projectile Y position should be just above the player ship's Y position");
    }
}
