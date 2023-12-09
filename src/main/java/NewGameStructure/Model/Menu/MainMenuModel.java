package NewGameStructure.Model.Menu;

import NewGameStructure.Application;
import NewGameStructure.Position;
import NewGameStructure.States.Menu.ControlsState;

public class MainMenuModel {
    private Application app; // Reference to Application
    private static final String[] menuItems = {"PLAY", "CONTROLS", "QUIT"};
    private Position selectorPos;
    private int selectedItem = 0;

    public MainMenuModel(Application app){
        this.app = app;
        this.selectorPos = new Position(100 / 2 - 6, 30 / 2);
    };
    public void select() {
        switch (selectedItem) {
            case 0: // PLAY
                app.setState(new ControlsState(new ControlsModel(new ArenaModel(100, 30))));
                break;
            case 1: // CONTROLS
                // Handle CONTROLS selection
                break;
            case 2: // QUIT
                app.setState(null); // Exit the game
                break;
        }
    }
    public String[] getMenuItems(){
        return menuItems;
    }
    public int getSelectedItem(){
        return selectedItem;
    }
    public void addEntry(){
        selectedItem++;
        if (selectedItem==3) selectedItem = 0;
    }

    public void removeEntry(){
        selectedItem--;
        if (selectedItem==-1) selectedItem = 2;
    }
    public Position getSelectorPos(){
        return selectorPos;
    }
}
