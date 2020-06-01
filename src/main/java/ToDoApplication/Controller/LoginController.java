package ToDoApplication.Controller;

import ToDoApplication.Model.UserDAO;
import ToDoApplication.View.Menu;
import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class LoginController {
    public Scanner input = new Scanner(System.in);

    public void loginMenu(){

        //if login true, user is able to do CRUD operation with application
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your enter your password: ");
        String password = input.nextLine();
        UserDAO userDAO = new UserDAO();
        String msg = userDAO.loginUser(username,password);
        if (msg.contains("successful")){
            Menu menu = new Menu();
            menu.userMenu();
        }
        else {
            System.out.println("Wrong credentials");
        }



    }
}
