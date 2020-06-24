package ToDoApplication.DAO;

import ToDoApplication.Model.ToDo;
import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao {



    public String addToDo(ToDo todo){
        String msg = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try{
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME,"root", "");
            String query = "INSERT INTO " + Constant.TODO_TABLE + "(entryName, entryContent, date, time, user_id) VALUES (?,?,?,?,?)";
             preparedStatement = connection.prepareStatement(query);
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
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
