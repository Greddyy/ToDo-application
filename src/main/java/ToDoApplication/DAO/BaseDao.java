package ToDoApplication.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class BaseDao {


    protected void closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        this.closeResource(connection, preparedStatement);
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            closeResource(connection, preparedStatement);

        }catch (SQLException e){

        }
    }

    protected  void closeResource(Connection connection, PreparedStatement preparedStatement){
        try {
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

}
