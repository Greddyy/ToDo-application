package ToDoApplication.Controller;

import java.util.Scanner;

public class MenuController {
    Scanner input = new Scanner(System.in);

    public void menuNavigation() {

        String read = input.nextLine();
        switch (read) {
            case "1":
                loginMenu();
                break;
            case "2":
                registerMenu();
                break;
            case "3":
                System.exit(1);
        }

    }
}
