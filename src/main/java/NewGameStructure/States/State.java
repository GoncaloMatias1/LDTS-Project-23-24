package NewGameStructure.States;

public abstract class State<T> {
    private T model;

    public State(T model){
        this.model = model;
    }
}
