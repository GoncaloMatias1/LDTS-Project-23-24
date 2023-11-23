package Model;

import com.goncalomatias1.l05gr06.PlayerShip;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class Arena {
    private int width;
    private int height;
    private PlayerShip playerShip;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        // Assuming the PlayerShip constructor takes the starting x, y, and screen width
        this.playerShip = new PlayerShip(width / 2, height - 3, width);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);

        // desenhar limites
        for (int x = 0; x < width; x++) {
            graphics.setCharacter(x, 0, Symbols.DOUBLE_LINE_HORIZONTAL);
            graphics.setCharacter(x, height - 1, Symbols.DOUBLE_LINE_HORIZONTAL);
        }
        for (int y = 1; y < height - 1; y++) {
            graphics.setCharacter(0, y, Symbols.DOUBLE_LINE_VERTICAL);
            graphics.setCharacter(width - 1, y, Symbols.DOUBLE_LINE_VERTICAL);
        }
        // Draw corners
        graphics.setCharacter(0, 0, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
        graphics.setCharacter(width - 1, 0, Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER);
        graphics.setCharacter(0, height - 1, Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
        graphics.setCharacter(width - 1, height - 1, Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER);

        graphics.setForegroundColor(TextColor.ANSI.DEFAULT);

        // Draw the player ship
        playerShip.draw(graphics);
    }

    public void update() {
    }

    public void handleInput(KeyStroke keyStroke) {
        // Handle player input
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
            playerShip.moveLeft();
        } else if (keyStroke.getKeyType() == KeyType.ArrowRight) {
            playerShip.moveRight();
        }
    }

}
