package ToDoApplication.View;

import java.util.Scanner;

public class Menu {

    public void mainMEnu(){
        System.out.println();
        System.out.println("\tWelcome to ToDo App!");
        System.out.println("Please choose your activity: ");
        System.out.println("1. Login." +
                "\n2. Register." +
                "\n3. Exit.");
    }

    public void userMenu(){
        System.out.println("Welcome to the user menu!");
        System.out.println("1. Add new entry." +
                "\n 2. Check all entries." +
                "\n3. Delete entries." +
                "\n4. Exit to main menu.");
    }

    public  void adminMenu(){
        System.out.println("Welcome to the admin menu!");
        System.out.println("1. Check all users." +
                "\n2. Check all entries (of all users)"+
                "\n3. Delete user" +
                "\n4. Delete entry" +
                "\n5. Exit to main menu");
    }


    }

