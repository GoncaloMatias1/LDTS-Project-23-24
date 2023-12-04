package NewGameStructure;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.MainMenuState;
import NewGameStructure.States.State;


import java.io.IOException;


public class Application {
    private GUI gui;
    private State state;
    public Application(){
        this.gui = new GUI();
        this.state = new MainMenuState(new MainMenuModel());
    }
    public static void main(String[] args) throws IOException {
        new Application();
    }

    private static void run() throws IOException{

    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
}

