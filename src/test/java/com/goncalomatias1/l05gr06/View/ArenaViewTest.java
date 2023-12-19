package com.goncalomatias1.l05gr06.View;

import static org.mockito.Mockito.*;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Game.EnemyWave;
import com.goncalomatias1.l05gr06.Model.Game.Entities.PlayerShip;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.View.Menu.ArenaView;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Collections;

class ArenaViewTest {

    @Mock
    private ArenaModel mockModel;

    @Mock
    private GUI mockGui;

    @Mock
    private TextGraphics mockGraphics;

    @Mock
    private Screen mockScreen;

    private ArenaView arenaView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockGui.getScreen()).thenReturn(mockScreen);
        when(mockGui.getGraphics()).thenReturn(mockGraphics);
        arenaView = new ArenaView(mockModel);
    }

    @Test
    void testDraw() throws IOException {
        // Arrange
        when(mockModel.getProjectiles()).thenReturn(Collections.emptyList());
        when(mockModel.getEnemyProjectiles()).thenReturn(Collections.emptyList());
        when(mockModel.getShields()).thenReturn(Collections.emptyList());
        when(mockModel.getPlayerShip()).thenReturn(mock(PlayerShip.class));
        when(mockModel.getEnemyWave()).thenReturn(mock(EnemyWave.class));

        // Act
        arenaView.draw(mockGui);

        // Assert
        verify(mockScreen, times(1)).clear();
        verify(mockGraphics, atLeastOnce()).setForegroundColor(any(TextColor.class));
        verify(mockModel.getPlayerShip(), times(1)).draw(mockGraphics);
        verify(mockModel.getEnemyWave(), times(1)).draw(mockGraphics);
        verify(mockScreen, times(1)).refresh();
    }

}
