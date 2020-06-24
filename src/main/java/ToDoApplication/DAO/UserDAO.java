package ToDoApplication.DAO;

import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;

public class UserDao {


    public User loginUser(String username, String  password) {

        User user = null;
        ResultSet resultSet = null;
        String msg = "";
        PreparedStatement preparedStatement = null;

        try {
            Connection connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME,  "root",  "");
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

        try{

            Connection connection = DriverManager.getConnection(Constant.URL + Constant.DB_NAME, "root", "");
            String query = "INSERT INTO " + Constant.USER_TABLE + " (username, password, email, admin) VALUES (?,?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setBoolean(4, user.isAdmin());

            preparedStatement.executeUpdate();
            msg = "New user successfully added!";
        } catch (SQLException e) {
            e.printStackTrace();
            msg = "Failure adding new user";
        }
        return msg;
    }
}
