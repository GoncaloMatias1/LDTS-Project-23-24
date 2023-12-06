package NewGameStructure.View;

import NewGameStructure.GUI;
import com.googlecode.lanterna.graphics.TextGraphics;

public class View<T> {
    private T model;

    public View(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public void draw(GUI gui){}
}
