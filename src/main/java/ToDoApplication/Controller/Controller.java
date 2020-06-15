package ToDoApplication.Controller;

import ToDoApplication.DAO.Domain;
import ToDoApplication.DAO.ToDoDAO;
import ToDoApplication.Model.ToDo;


import java.time.LocalDateTime;
import java.util.Scanner;

public class Controller {


    public static void addEntry(){
        LocalDateTime localDateTime = LocalDateTime.now();
        java.sql.Date date = java.sql.Date.valueOf(localDateTime.toLocalDate());
        java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the entry: ");
        String entryName = sc.nextLine();
        System.out.println("Content of the entry: ");
        String entryContent = sc.nextLine();
        System.out.println("User id");
        short user_id = sc.nextShort();
        ToDo toDo = new ToDo(entryName, entryContent, date, time, user_id);
//        ???:D
//        Domain domain = new Domain();
//        domain.getUser(Username);
        // toDoDAO should be deleted, right?
//        ToDoDAO toDoDAO = new ToDoDAO();
        String msg = toDoDAO.addToDo(toDo);
        if(msg.contains("successfully")){
            System.out.println("New user successfully added!");
        } else {
            System.out.println("Something went wrong!");
        }

    }

    public static void getEntries(){
        System.out.println("All entries from the table: ");
        ToDoDAO toDoDAO = new ToDoDAO();
        toDoDAO.getAllEntries();
    }
}

