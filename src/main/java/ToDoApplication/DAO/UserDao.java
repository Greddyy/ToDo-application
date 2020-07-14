package ToDoApplication.DAO;

import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;

public class UserDao extends BaseDao {

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


    public User loginUser(String username, String  password) {

        User user = null;
        ResultSet resultSet = null;
        String msg = "";
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
             connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME,  "root",  "");
            preparedStatement = connection.prepareStatement("SELECT  * FROM  " + Constant.USER_TABLE + " Where username = ? AND password = ?");
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                short id = resultSet.getShort("id");
                String username2 = resultSet.getString("username");
                String password2 = resultSet.getString("password");
                String email = resultSet.getString("email");
                boolean isAdmin = resultSet.getBoolean("admin");
                user = new User(id, username2,password2,email,isAdmin);
            }
        } catch (SQLException e) {
            System.out.println("Wrong credentials!");
        } finally {
            closeResource(connection, preparedStatement, resultSet);

        }
       return user;

    }

    public String deleteUser(User user){
        return null;
    }
    public String searcUserBy(){
        return null;
    }

    public String registerUser(User user){

        String msg = "";
        PreparedStatement preparedStatement = null;
        Connection connection =null;

        try{

            connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            String query = "INSERT INTO " + Constant.USER_TABLE + " (username, password, email, admin) VALUES (?,?,?,?) ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isAdmin());

            preparedStatement.executeUpdate();
            msg = "New user successfully added!";
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "Failure adding new user";
        } finally {
            closeResource(connection, preparedStatement);
        }
        return msg;
    }
}
