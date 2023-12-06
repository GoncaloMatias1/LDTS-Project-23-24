package NewGameStructure.View;

import NewGameStructure.GUI;
import com.googlecode.lanterna.graphics.TextGraphics;

public class View<T> {
    private T model;

    protected final int width = 100;
    protected final int height = 300;

    public View(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public void draw(TextGraphics graphics){

    }
}
