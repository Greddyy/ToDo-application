package ToDoApplication.Controller;

import ToDoApplication.DAO.UserDAO;
import ToDoApplication.Model.User;

import java.util.Scanner;

public class RegistrationController {
    static Scanner input = new Scanner(System.in);

    public static void registerMenu(){
        System.out.println("Enter your username: ");
        String username = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();
        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Are you an admin? \n Press Y or N");
        boolean isAdmin = input.nextBoolean();
        User user = new User(username, password, email, isAdmin);
        UserDAO userDAO = new UserDAO();
        String msg = userDAO.registerUser(user);
        if(msg.contains("successfully")){
            System.out.println("New user successfully added!");
        } else {
            System.out.println("Something went wrong!");
        }


    }

}
