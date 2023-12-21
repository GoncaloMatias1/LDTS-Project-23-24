package com.goncalomatias1.l05gr06.Controller.Menu;


import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Game.EnemyWave;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Enemy;
import com.goncalomatias1.l05gr06.Model.Game.Entities.PlayerShip;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.Position;
import com.goncalomatias1.l05gr06.States.Menu.GameOverState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private ArenaModel mockArenaModel;
    private Application mockApplication;
    private GUI mockGUI;

    @BeforeEach
    void setUp() {
        mockArenaModel = mock(ArenaModel.class);
        mockApplication = mock(Application.class);
        mockGUI = mock(GUI.class);
        arenaController = new ArenaController(mockArenaModel);

        when(mockApplication.getGui()).thenReturn(mockGUI);
        when(mockGUI.getWidth()).thenReturn(100);
        when(mockGUI.getHeight()).thenReturn(30);
    }

    @Test
    public void testStepGameOverWhenNoLives() {
        when(mockArenaModel.getEnemyWave()).thenReturn(mock(EnemyWave.class));
        when(mockArenaModel.getPlayerShip()).thenReturn(mock(PlayerShip.class));
        when(mockArenaModel.getPlayerShip().isAlive()).thenReturn(false);
        arenaController.step(mockApplication, GUI.ACTION.NONE);
        verify(mockApplication).setState(any(GameOverState.class));
    }

    @Test
    public void testGameOverWhenAliensReachShields() {
        EnemyWave mockEnemyWave = mock(EnemyWave.class);
        when(mockArenaModel.getEnemyWave()).thenReturn(mockEnemyWave);

        PlayerShip mockPlayerShip = mock(PlayerShip.class);
        when(mockArenaModel.getPlayerShip()).thenReturn(mockPlayerShip);
        when(mockPlayerShip.isAlive()).thenReturn(true);

        List<Enemy> mockEnemies = mock(List.class);
        when(mockEnemies.get(anyInt())).thenReturn(mock(Enemy.class));
        when(mockEnemies.get(anyInt()).getPosition()).thenReturn(new Position(0, arenaController.getGameOverArea()));
        when(mockEnemyWave.getEnemies()).thenReturn(mockEnemies);

        arenaController.step(mockApplication, GUI.ACTION.NONE);

        verify(mockApplication).setState(any(GameOverState.class));
    }

}
