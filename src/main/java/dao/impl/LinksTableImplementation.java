package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Questions;
import dao.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;

public class LinksTableImplementation extends AbstractTableImplementation {

    public int askQuestion(Users users, Questions questions) throws SQLException {
        Connection connection = null;
        int result = 0;
        try {
            connection = JdbcManager.connection();
            connection.setAutoCommit(false);






            connection.commit();

        } catch (SQLException e) {
           connection.rollback();
        } finally {
            JdbcManager.closeConnection(connection);
        }
        return result;
    }

}
