package com.goncalomatias1.l05gr06.States.Menu;


import com.goncalomatias1.l05gr06.Controller.Controller;
import com.goncalomatias1.l05gr06.Controller.Menu.MainMenuController;
import com.goncalomatias1.l05gr06.Model.Menu.MainMenuModel;
import com.goncalomatias1.l05gr06.States.State;
import com.goncalomatias1.l05gr06.View.Menu.MainMenuView;
import com.goncalomatias1.l05gr06.View.View;

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
