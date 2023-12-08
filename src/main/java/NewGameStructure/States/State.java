package NewGameStructure.States;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.GUI;
import NewGameStructure.View.View;

import java.io.IOException;

public abstract class State<T> {
    protected T model;
    protected Controller<T> controller;
    protected View<T> view;

    public State(T model) {
        this.model = model;
        this.view = getView();
        this.controller = getController();
    }

    public void setModel(T model) {
        this.model = model;
    }

    protected abstract View<T> getView();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
        gui.getScreen().refresh();
    }
}
