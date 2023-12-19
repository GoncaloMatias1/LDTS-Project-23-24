package com.goncalomatias1.l05gr06.Model;

import com.goncalomatias1.l05gr06.Model.Game.Entities.Shield;
import com.goncalomatias1.l05gr06.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {

    private Shield shield;
    private final Position position = new Position(5, 5);

    @Mock
    private TextGraphics mockGraphics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        shield = new Shield(position);
    }

    @Test
    void shieldInitialization_withMaximumLives() {
        assertEquals(4, shield.getLives());
    }

    @Test
    void draw_invokesSetCharacterWithCorrectColor() {
        shield.draw(mockGraphics);
        verify(mockGraphics).setCharacter(position.getX(), position.getY(), shield.getShieldCharacter());
    }

    @Test
    void takeDamage_decreasesLivesAndUpdatesColor() {
        int initialLives = shield.getLives();
        shield.takeDamage();
        assertEquals(initialLives - 1, shield.getLives());
    }

    @Test
    void isAlive_returnsTrueWhenLivesAboveZero() {
        assertTrue(shield.isAlive());
    }

    @Test
    void isAlive_returnsFalseWhenLivesAreZero() {
        for (int i = 0; i < 4; i++) {
            shield.takeDamage();
        }
        assertFalse(shield.isAlive());
    }
}
