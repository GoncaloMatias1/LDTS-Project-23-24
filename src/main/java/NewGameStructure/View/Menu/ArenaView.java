package NewGameStructure.View.Menu;


import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.View.View;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.TextColor;

public class ArenaView extends View<ArenaModel> {
    public ArenaView(ArenaModel arenaModel){
        super(arenaModel);
    }


    public void draw(GUI gui) {
        gui.getScreen().clear();
        gui.getGraphics().setForegroundColor(TextColor.ANSI.YELLOW);
        // Desenhar limites usando model.getWidth() e model.getHeight()
        // ...
        // Desenhar playerShip usando model.getPlayerShip().draw(graphics)
        // ...
    }
}

