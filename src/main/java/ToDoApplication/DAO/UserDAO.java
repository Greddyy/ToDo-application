package ToDoApplication.DAO;

import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;

public class UserDAO {


    public String loginUser(String username, String  password) throws SQLException {
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

            if(resultSet.next()) {
                msg = "Login is successful!";
            } else {
                System.out.println("Wrong login credentials!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return msg;

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
