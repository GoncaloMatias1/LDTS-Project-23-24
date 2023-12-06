package NewGameStructure.Model.Menu;

import OldGame.Objects.Characteristics.Position;

public class MainMenuModel {
    private static final String[] menuItems = {"PLAY", "CONTROLS", "QUIT"};
    protected Position selectorPos;
    private int selectedItem = 0;

    public MainMenuModel(){};
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
