package com.goncalomatias1.l05gr06.View.Menu;

import com.goncalomatias1.l05gr06.GUI;
import com.goncalomatias1.l05gr06.Model.Game.Projectile;
import com.goncalomatias1.l05gr06.Model.Game.Entities.Shield;
import com.goncalomatias1.l05gr06.Model.Menu.ArenaModel;
import com.goncalomatias1.l05gr06.View.View;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;
import java.io.IOException;

public class ArenaView extends View<ArenaModel> {
    public ArenaView(ArenaModel arenaModel){
        super(arenaModel);
    }

    @Override
    public void draw(GUI gui) {
        TextGraphics graphics = gui.getGraphics();
        gui.getScreen().clear();

        drawBoundaries(graphics);

        drawLives(graphics);

        getModel().getPlayerShip().draw(graphics);

        for (Projectile projectile : getModel().getProjectiles()) {
            projectile.draw(graphics);
        }

        for (Projectile projectile : getModel().getEnemyProjectiles()) {
            projectile.draw(graphics);
        }

        for (Shield shield : getModel().getShields()) {
            shield.draw(graphics);
        }

        getModel().getEnemyWave().draw(graphics);

        drawScore(graphics);

        try {
            gui.getScreen().refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawBoundaries(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        graphics.drawLine(0, 0, getModel().getWidth() - 1, 0, '-'); // Top boundary
        graphics.drawLine(0, getModel().getHeight() - 1, getModel().getWidth() - 1, getModel().getHeight() - 1, '-'); // Bottom boundary
        graphics.drawLine(0, 0, 0, getModel().getHeight() - 1, '|'); // Left boundary
        graphics.drawLine(getModel().getWidth() - 1, 0, getModel().getWidth() - 1, getModel().getHeight() - 1, '|'); // Right boundary
    }

    private void drawLives(TextGraphics graphics) {
        int startX = 2;
        int startY = 1;

        graphics.putString(new TerminalPosition(startX, startY), "LIVES", SGR.BOLD);
        startX += 6;

        String heart = "\u2665";
        graphics.setForegroundColor(TextColor.ANSI.RED);
        graphics.enableModifiers(SGR.BOLD);

        int lives = getModel().getPlayerShip().getLives();
        for (int i = 0; i < lives; i++) {
            graphics.putString(new TerminalPosition(startX + i * 4, startY), heart);
        }
        graphics.disableModifiers(SGR.BOLD);
    }

    private void drawScore(TextGraphics graphics) {
        String scoreText = "Score: " + getModel().getScore();
        int scorePosX = getModel().getWidth() - scoreText.length() - 2;
        int scorePosY = 1;
        graphics.putString(new TerminalPosition(scorePosX, scorePosY), scoreText, SGR.BOLD);
    }
}
