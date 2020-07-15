package ToDoApplication.Controller;

import ToDoApplication.DAO.UserDao;
import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;
import ToDoApplication.View.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginController {
    public static Scanner input = new Scanner(System.in);

    public static void loginMenu()  {

        //if login true, user is able to do CRUD operation with application
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        UserDao userDAO = new UserDao();
        try {
            User user = userDAO.loginUser(username, password);
            Constant.LOGGED_IN_USER_ID = user.getId();
            Menu menu = new Menu();
            menu.userMenu();
        } catch (RuntimeException e) {
            System.out.println("Wrong credentials");

        }
    }
}
