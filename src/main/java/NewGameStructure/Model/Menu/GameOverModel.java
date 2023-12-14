package NewGameStructure.Model.Menu;

import NewGameStructure.Application;
import NewGameStructure.FileUtility;
import NewGameStructure.Position;
import NewGameStructure.States.Menu.ArenaState;
import NewGameStructure.States.Menu.ControlsState;

public class GameOverModel {
    private static final String[] menuItems = {"START AGAIN", "QUIT"};
    private Position selectorPos;
    private int selectedItem = 0;
    private int currentScore;

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

    public void setCurrentScore(int score) {
        this.currentScore = score;
        FileUtility.writeScoreToFile(score);
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getHighScore() {
        return FileUtility.getHighScore();
    }

    public void removeEntry(){
        selectedItem--;
        if (selectedItem==-1) selectedItem = 1;
    }
    public Position getSelectorPos(){
        return selectorPos;
    }
}