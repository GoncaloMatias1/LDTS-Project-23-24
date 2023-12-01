package NewGameStructure.View.Menu;


import NewGameStructure.Model.Menu.ArenaModel;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;

public class ArenaView {
    private ArenaModel model;

    public ArenaView(ArenaModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.YELLOW);
        // Desenhar limites usando model.getWidth() e model.getHeight()
        // ...
        // Desenhar playerShip usando model.getPlayerShip().draw(graphics)
        // ...
    }
}

