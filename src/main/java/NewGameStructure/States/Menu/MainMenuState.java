package NewGameStructure.States.Menu;


import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.MainMenuController;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.MainMenuView;
import NewGameStructure.View.View;

public class MainMenuState extends State<MainMenuModel> {
    private Application application;
    public MainMenuState(MainMenuModel mainMenuModel,Application application){
        super(mainMenuModel);
        this.application = application;
    }
    @Override
    protected View<MainMenuModel> getView() {
        return new MainMenuView(getModel());
    }

    @Override
    protected Controller<MainMenuModel> getController() {
        return new MainMenuController(getModel(),application);
    }
}
