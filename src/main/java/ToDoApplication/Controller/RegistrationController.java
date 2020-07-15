package ToDoApplication.Controller;

import ToDoApplication.DAO.UserDao;
import ToDoApplication.Model.User;

import java.sql.SQLException;
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
        try {
            User user = new User(username, password, email, isAdmin);
            UserDao userDAO = new UserDao();
            userDAO.registerUser(user);
        } catch (RuntimeException e){
            System.out.println("Something went wrong! Registration failed.");
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
