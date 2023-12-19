package com.goncalomatias1.l05gr06.View;

import com.goncalomatias1.l05gr06.GUI;

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
