package com.goncalomatias1.l05gr06.Model.Menu;

import com.goncalomatias1.l05gr06.Model.Menu.GameOverModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOverModelTest {

    private GameOverModel gameOverModel;

    @BeforeEach
    void setUp() {
        gameOverModel = new GameOverModel();
    }

    @Test
    void getMenuItemsShouldReturnCorrectItems() {
        String[] expectedItems = {"START AGAIN", "QUIT"};
        assertArrayEquals(expectedItems, gameOverModel.getMenuItems());
    }

    @Test
    void getSelectedItemInitiallyShouldBeZero() {
        assertEquals(0, gameOverModel.getSelectedItem());
    }

    @Test
    void addEntryShouldCycleThroughMenuItems() {
        gameOverModel.addEntry();
        assertEquals(1, gameOverModel.getSelectedItem());
        gameOverModel.addEntry();
        assertEquals(0, gameOverModel.getSelectedItem());
    }

    @Test
    void removeEntryShouldCycleThroughMenuItems() {
        gameOverModel.removeEntry();
        assertEquals(1, gameOverModel.getSelectedItem());
        gameOverModel.removeEntry();
        assertEquals(0, gameOverModel.getSelectedItem());
    }

}
