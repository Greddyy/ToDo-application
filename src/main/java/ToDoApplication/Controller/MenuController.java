package ToDoApplication.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuController {
    Scanner input = new Scanner(System.in);

    public void menuNavigation() throws SQLException {
        String read = input.nextLine();
        switch (read) {
            case "1":
                LoginController.loginMenu();
                break;
            case "2":
                RegistrationController.registerMenu();
                break;
            case "3":
                System.exit(1);
        }

    }
}
