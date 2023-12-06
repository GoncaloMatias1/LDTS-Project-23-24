package NewGameStructure.Model.Menu;

import NewGameStructure.Position;

public class MainMenuModel {
    private static final String[] menuItems = {"PLAY", "CONTROLS", "QUIT"};
    private Position selectorPos;
    private int selectedItem = 0;

    public MainMenuModel(){
        this.selectorPos = new Position(100 / 2 - 6, 30 / 2);
    };
    public String[] getMenuItems(){
        return menuItems;
    }
    public int getSelectedItem(){
        return selectedItem;
    }
    public Position getSelectorPos(){
        return selectorPos;
    }
}
