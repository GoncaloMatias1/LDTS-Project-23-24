package com.goncalomatias1.l05gr06.Controller;

import com.goncalomatias1.l05gr06.Application;
import com.goncalomatias1.l05gr06.GUI;
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
