package com.goncalomatias1.l05gr06.Model.Menu;

import com.goncalomatias1.l05gr06.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainMenuModelTest {

    private MainMenuModel mainMenuModel;

    @BeforeEach
    void setUp() {
        mainMenuModel = new MainMenuModel();
    }

    @Test
    void getMenuItemsShouldReturnCorrectItems() {
        String[] expectedItems = {"PLAY", "CONTROLS", "QUIT"};
        assertArrayEquals(expectedItems, mainMenuModel.getMenuItems());
    }

    @Test
    void getSelectedItemInitiallyShouldBeZero() {
        assertEquals(0, mainMenuModel.getSelectedItem());
    }

    @Test
    void addEntryShouldCycleThroughMenuItems() {
        mainMenuModel.addEntry();
        assertEquals(1, mainMenuModel.getSelectedItem());
        mainMenuModel.addEntry();
        assertEquals(2, mainMenuModel.getSelectedItem());
        mainMenuModel.addEntry();
        assertEquals(0, mainMenuModel.getSelectedItem());
    }

    @Test
    void removeEntryShouldCycleThroughMenuItems() {
        mainMenuModel.removeEntry();
        assertEquals(2, mainMenuModel.getSelectedItem());
        mainMenuModel.removeEntry();
        assertEquals(1, mainMenuModel.getSelectedItem());
        mainMenuModel.removeEntry();
        assertEquals(0, mainMenuModel.getSelectedItem());
    }

    @Test
    void getSelectorPosShouldReturnCorrectPosition() {
        Position expectedPosition = new Position(100 / 2 - 6, 30 / 2);
        assertEquals(expectedPosition, mainMenuModel.getSelectorPos());
    }
}
