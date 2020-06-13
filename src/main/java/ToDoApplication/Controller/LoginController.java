package ToDoApplication.Controller;

import ToDoApplication.DAO.UserDAO;
import ToDoApplication.View.Menu;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginController {
    public  static  Scanner input = new Scanner(System.in);

    public static void loginMenu() throws SQLException {

        //if login true, user is able to do CRUD operation with application
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        UserDAO userDAO = new UserDAO();
        String msg = userDAO.loginUser(username,password);
        if (msg.contains("successful")){
            Menu menu = new Menu();
            menu.userMenu();
        }
        else {
            System.out.println("Wrong credentials2");
        }



    }
}
