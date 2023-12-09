package NewGameStructure;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.Model.Menu.ControlsModel;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.ControlsState;
import NewGameStructure.States.Menu.MainMenuState;
import NewGameStructure.States.State;
import com.googlecode.lanterna.graphics.TextGraphics;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public class Application {
    private GUI gui;
    private static State state;
    public Application() throws IOException{
        this.gui = new GUI(100, 30);
        this.state = new MainMenuState(new MainMenuModel(this),this);
    }
    public static void main(String[] args) throws IOException{
        new Application().run();
    }

    private void run() throws IOException{
        int frameTime = 60;
        while (state!=null){
            long startTime = System.currentTimeMillis();
            System.out.println("Current state: " + state.getClass().getSimpleName());
            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() -startTime;
            long sleepTime = frameTime - elapsedTime;

            try{
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e){}
        }
        gui.getScreen().stopScreen();
        System.exit(0);
    }
    public void setState(State newState) {
        this.state = newState;
    }
    public State getState(){
        return state;
    }
}

