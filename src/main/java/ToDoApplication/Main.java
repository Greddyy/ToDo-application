package ToDoApplication;

import ToDoApplication.Controller.Controller;
import ToDoApplication.Controller.MenuController;
import ToDoApplication.Controller.RegistrationController;
import ToDoApplication.Controller.UserMenuController;
import ToDoApplication.View.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Menu menu = new Menu();
        menu.mainMEnu();
        MenuController menuController = new MenuController();
        menuController.menuNavigation();
        UserMenuController userMenuController = new UserMenuController();
        userMenuController.userMenuNavigation();


    }
}
