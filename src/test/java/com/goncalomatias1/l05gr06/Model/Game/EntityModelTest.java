package com.goncalomatias1.l05gr06.Model.Game;

import com.goncalomatias1.l05gr06.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EntityModelTest {
    private EntityModel entityModel;
    private final Position startPosition = new Position(5, 5);

    @BeforeEach
    void setUp() {
        entityModel = new EntityModel(startPosition, 3, true) {
            // This is an anonymous subclass of the abstract EntityModel class
        };
        entityModel.minX = 0;
        entityModel.maxX = 10;
    }

    @Test
    void moveLeft_ShouldDecreaseX_WhenNotAtBoundary() {
        entityModel.moveLeft();
        assertEquals(4, entityModel.getPosition().getX());
    }

    @Test
    void moveLeft_ShouldNotDecreaseX_WhenAtBoundary() {
        entityModel.position.setX(entityModel.minX);
        entityModel.moveLeft();
        assertEquals(entityModel.minX, entityModel.getPosition().getX());
    }

    @Test
    void moveRight_ShouldIncreaseX_WhenNotAtBoundary() {
        entityModel.moveRight();
        assertEquals(6, entityModel.getPosition().getX());
    }

    @Test
    void moveRight_ShouldNotIncreaseX_WhenAtBoundary() {
        entityModel.position.setX(entityModel.maxX);
        entityModel.moveRight();
        assertEquals(entityModel.maxX, entityModel.getPosition().getX());
    }

    @Test
    void setLives_ShouldChangeLivesCount() {
        int newLives = 5;
        entityModel.setLives(newLives);
        assertEquals(newLives, entityModel.getLives());
    }

    @Test
    void isEnemy_ShouldReturnCorrectStatus() {
        assertTrue(entityModel.isEnemy());
    }
}
