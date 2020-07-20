package ToDoApplication.Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenuController {
    Scanner input = new Scanner(System.in);

    public void userMenuNavigation() throws SQLException {
        String insert = input.nextLine();
        switch (insert) {
            case "1":
                Controller.addEntry();
                break;
            case "2":
                Controller.getEntries();
                break;
            case "3":
                Controller.deleteEntryById();
                break;
        }

    }
}
