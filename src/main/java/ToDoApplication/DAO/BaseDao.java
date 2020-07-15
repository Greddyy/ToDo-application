package ToDoApplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class BaseDao {


    protected void closeResource(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    protected void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        if (preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

}
