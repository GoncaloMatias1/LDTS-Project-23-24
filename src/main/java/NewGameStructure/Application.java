package NewGameStructure;

import NewGameStructure.States.Menu.MainMenuState;
import NewGameStructure.States.State;


import java.io.IOException;


public class Application {
    private State state;
    public Application(){
        state = new MainMenuState();
    }
    public static void main(String[] args) throws IOException {
        // Call the run() method to start the game
        Application.run();
    }

    private static void run() throws IOException{
        ScreenCreator.createScreen();
    }

    public State getState(){
        return state;
    }
}

