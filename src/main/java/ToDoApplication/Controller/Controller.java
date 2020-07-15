package ToDoApplication.Controller;


import ToDoApplication.DAO.ToDoDao;
import ToDoApplication.Model.ToDo;
import ToDoApplication.Utils.Constant;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Controller {


    public static void addEntry() {

        LocalDateTime localDateTime = LocalDateTime.now();
        java.sql.Date date = java.sql.Date.valueOf(localDateTime.toLocalDate());
        java.sql.Time time = java.sql.Time.valueOf(localDateTime.toLocalTime());
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the entry: ");
        String entryName = sc.nextLine();
        System.out.println("Content of the entry: ");
        String entryContent = sc.nextLine();
        short user_id = (Constant.LOGGED_IN_USER_ID);
        ToDo toDo = new ToDo(entryName, entryContent, date, time, user_id);
        ToDoDao toDoDao = new ToDoDao();
        try {
            toDoDao.addToDo(toDo);
            System.out.println("New user successfully added!");
        } catch (RuntimeException e) {
            System.out.println("Something went wrong!");
        }

    }

    public static void getEntries() {
        System.out.println("All entries from the table: ");
        ToDoDao toDoDAO = new ToDoDao();
        toDoDAO.getAllEntries();
    }
}

