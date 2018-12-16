package dao.impl;
/*
import dao.driver.JdbcManagerConnectionPool;
import beans.entities.AbstractEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class AbstractTableImplementation {

    final int FIRST_ARGUMENT = 1;
    final int SECOND_ARGUMENT = 2;
    final int THIRD_ARGUMENT = 3;
    final String ID = "id";
    final String NAME = "name";
    final String QUESTION = "question";
    final String ANSWER = "answer";

    int selectEntity(String content, String sql, Connection connection) throws SQLException {
        ResultSet resultSet = null;
        int result = -1;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(FIRST_ARGUMENT, content);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getInt(ID);
            }
        } finally {
            JdbcManagerConnectionPool.getInstance().closeResultSet(resultSet);
        }
        return result;
    }

    int insertEntity(String content, String sql, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(FIRST_ARGUMENT, content);
            return statement.executeUpdate();
        }
    }

}
*/