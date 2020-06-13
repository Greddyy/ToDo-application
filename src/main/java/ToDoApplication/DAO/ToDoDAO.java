package ToDoApplication.DAO;

import ToDoApplication.Model.ToDo;
import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

    public User getUser(String username){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        boolean isAdmin = false;
        User user = null;
        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME,"root", "");
            preparedStatement = connection.prepareStatement("SELECT * FROM " + Constant.USER_TABLE + " Where username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                short id = resultSet.getShort("id");
                String username2 = resultSet.getString("username");
                String  password2 = resultSet.getString("password");
                String email = resultSet.getString("email");
                boolean admin = resultSet.getBoolean("admin");

                user = new User(id, username2, password2, email, admin);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String addToDo(ToDo todo){
        String msg = "";


        try{
            Connection connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME,"root", "");
            String query = "INSERT INTO " + Constant.TODO_TABLE + "(entryName, entryContent, date, time, user_id) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, todo.getEntryName());
            preparedStatement.setString(2, todo.getEntryContent());
            preparedStatement.setDate(3, todo.getDate());
            preparedStatement.setTime(4, todo.getTime());
            preparedStatement.setShort(5,todo.getUser_id());
            preparedStatement.executeUpdate();
            msg = "new entry added successfully";

        } catch (SQLException e) {
            e.printStackTrace();
            msg = "failure adding new entry";
        }
        return msg;
    }



    public  ResultSet getAllEntries(){
        String query = "";
        query = "SELECT * FROM entry";

        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()){
                short id = resultSet.getShort("id");
                String entryName = resultSet.getString("entryName");
                String entryContent = resultSet.getString("entryContent");
                Date date = resultSet.getDate("date");
                Time time = resultSet.getTime("time");
                System.out.println("ID: " + id);
                System.out.println("Entry name: " + entryName);
                System.out.println("Entry content: " + entryContent);
                System.out.println("Date: " + date);
                System.out.println("Time: " + time);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

//    public  List<ToDo> getEntriesList(){
//        String query = "SELECT * FROM entry";
//        List<ToDo> list = new ArrayList<ToDo>();
//        ToDo toDo = null;
//        ResultSet resultSet = null;
//
//        try {
//            Connection connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
//            Statement statement = connection.createStatement();
//            resultSet = statement.executeQuery(query);
//            while (resultSet.next()){
//                toDo.setId(resultSet.getShort("id"));
//                toDo.setEntryName(resultSet.getString("entryName"));
//                toDo.setEntryContent(resultSet.getString("entryContent"));
//                toDo.setDate(resultSet.getDate("date"));
//                toDo.setTime(resultSet.getTime("time"));
//
//                list.add(toDo);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }




}
