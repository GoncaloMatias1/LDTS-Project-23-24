package NewGameStructure.States.Menu;


import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.MainMenuController;
import NewGameStructure.Model.Menu.MainMenuModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.MainMenuView;
import NewGameStructure.View.View;

public class MainMenuState extends State<MainMenuModel> {
    public MainMenuState(MainMenuModel mainMenuModel){
        super(mainMenuModel);
    }
    @Override
    protected View<MainMenuModel> getView() {
        return new MainMenuView(getModel());
    }

    @Override
    protected Controller<MainMenuModel> getController() {
        return new MainMenuController(getModel());
    }


}
