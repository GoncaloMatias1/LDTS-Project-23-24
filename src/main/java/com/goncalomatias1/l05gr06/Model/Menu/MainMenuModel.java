package com.goncalomatias1.l05gr06.Model.Menu;

import com.goncalomatias1.l05gr06.Position;
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
