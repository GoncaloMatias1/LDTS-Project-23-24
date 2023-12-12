package NewGameStructure.Model.Menu;

import NewGameStructure.Application;
import NewGameStructure.Position;
import NewGameStructure.States.Menu.ArenaState;
import NewGameStructure.States.Menu.ControlsState;

public class GameOverModel {
    private static final String[] menuItems = {"START AGAIN", "QUIT"};
    private Position selectorPos;
    private int selectedItem = 0;

    public GameOverModel(){
        this.selectorPos = new Position(100 / 2 - 6, 30 / 2);
    };
    public String[] getMenuItems(){
        return menuItems;
    }
    public int getSelectedItem(){
        return selectedItem;
    }
    public void addEntry(){
        selectedItem++;
        if (selectedItem==2) selectedItem = 0;
    }

    public void removeEntry(){
        selectedItem--;
        if (selectedItem==-1) selectedItem = 1;
    }
    public Position getSelectorPos(){
        return selectorPos;
    }
}