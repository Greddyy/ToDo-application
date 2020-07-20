package ToDoApplication.DAO;

import ToDoApplication.Model.ToDo;
import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao extends BaseDao {


    public void addToDo(ToDo todo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            String query = "INSERT INTO " + Constant.TODO_TABLE + "(entryName, entryContent, date, time, user_id) VALUES (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, todo.getEntryName());
            preparedStatement.setString(2, todo.getEntryContent());
            preparedStatement.setDate(3, todo.getDate());
            preparedStatement.setTime(4, todo.getTime());
            preparedStatement.setShort(5, todo.getUser_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeResource(connection, preparedStatement);
        }

    }


    public ResultSet getEntryById() {
        String query = "";
        query = "SELECT * FROM entry WHERE user_id=?";

        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setShort(1, Constant.LOGGED_IN_USER_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeResource(connection, preparedStatement, resultSet);
        }
        return resultSet;
    }

    public void deleteEntryById(short entry_id) {
        String query = "";
        query = "DELETE FROM entry where id=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setShort(1, entry_id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            closeResource(connection, preparedStatement);
        }
    }


}
