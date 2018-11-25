package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class AbstractTableImplementation {

    final int FIRST_ARGUMENT = 1;
    final int SECOND_ARGUMENT = 2;
    final String ID = "id";
    final String NAME = "name";

    Entity selectEntity(String content, String sql, Connection connection) throws SQLException {
        ResultSet resultSet = null;
        Entity entity = null;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(FIRST_ARGUMENT, content);
            resultSet = statement.executeQuery();

            if (resultSet.next())
                entity = new Entity(resultSet.getInt(ID), resultSet.getString(NAME));
        } finally {
            JdbcManager.closeResultSet(resultSet);
        }
        return entity;
    }

    int insertEntity(String content, String sql, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(FIRST_ARGUMENT, content);
            return statement.executeUpdate();
        }
    }

}
