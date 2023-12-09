package NewGameStructure;

import NewGameStructure.GUI;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.Menu.MainMenuState;
import NewGameStructure.States.Menu.ArenaState;
import NewGameStructure.States.State;
import java.io.IOException;

public class Application {
    private GUI gui;
    private State currentState;

    public Application() throws IOException {
        this.gui = new GUI(100, 30);
        // Inside your Application class constructor
        this.currentState = new MainMenuState(new MainMenuModel(this), this); // If MainMenuModel requires the Application instance.


    }

    public static void main(String[] args) throws IOException {
        new Application().run();
    }

    private void run() throws IOException {
        int frameTime = 1000 / 60; // 60 frames per second
        while (currentState != null) {
            long startTime = System.currentTimeMillis();

            // Update and draw the current state
            if (currentState instanceof ArenaState) {
                ((ArenaState) currentState).update(); // Update game entities in ArenaState
            }
            currentState.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) {
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
                // Handle the interrupted exception
                Thread.currentThread().interrupt();
            }
        }
        gui.getScreen().stopScreen();
        System.exit(0);
    }

    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getState() {
        return currentState;
    }
    public GUI getGui() {
        return gui;
    }
}
