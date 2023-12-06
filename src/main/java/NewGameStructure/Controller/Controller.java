package NewGameStructure.Controller;

import NewGameStructure.Application;
import NewGameStructure.GUI;
import java.io.IOException;

public abstract class Controller<T> {
    private T model;
    public Controller(T model){
        this.model = model;
    }
    public T getModel(){
        return model;
    }
    public abstract void step(Application application, GUI.ACTION action) throws IOException;
}
