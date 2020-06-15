package ToDoApplication.DAO;

import ToDoApplication.Model.User;
import ToDoApplication.Utils.Constant;

import java.sql.*;

public class Domain {
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
}
