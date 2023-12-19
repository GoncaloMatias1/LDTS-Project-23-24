package com.goncalomatias1.l05gr06;

import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.Menu.MainMenuState;
import com.goncalomatias1.l05gr06.States.State;

import java.io.IOException;

public class Application {
    private GUI gui;
    private static State state;
    public Application() throws IOException{
        this.gui = new GUI(100, 30);
        this.state = new MainMenuState(new MainMenuModel());
    }
    public static void main(String[] args) throws IOException{
        new Application().run();
    }

    private void run() throws IOException{
        int frameTime = 60;
        while (state!=null){
            long startTime = System.currentTimeMillis();
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
    public void setState(State state) {
        this.state = state;
    }
    public State getState(){
        return state;
    }
    public GUI getGui() {
        return gui;
    }
}