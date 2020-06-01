package ToDoApplication;

import ToDoApplication.Controller.Controller;
import ToDoApplication.View.Menu;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        Menu menu = new Menu();
        menu.mainMEnu();
        controller.menuNavigation();


    }
}
