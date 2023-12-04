package NewGameStructure.States;

public abstract class State<T> {
    private T model;

    public State(T model){
        this.model = model;
    }

    public void setModel(T model){
        this.model = model;
    }
    public T getModel(){
        return model;
    }
}
