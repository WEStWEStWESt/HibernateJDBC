package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Entity;
import dao.entity.Users;
import dao.sections.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTableImplementation extends AbstractTableImplementation{

    public int addUser(Users users) throws SQLException {
        int result = 0;
        try (Connection connection = JdbcManager.connection()) {
            if (selectEntity(users.getName(), SqlQuery.SELECT_USER.getSql(), connection) == null) {
                result = insertEntity(users.getName(), SqlQuery.INSERT_USER.getSql(), connection);
            }
        }
        return result;
    }

    public Users getUser(String name) throws SQLException {
        try (Connection connection = JdbcManager.connection()) {
            return (Users) selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection);
        }
    }

    private Entity selectEntity(String content, String sql, Connection connection) throws SQLException {
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

    private int insertEntity(String content, String sql, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(FIRST_ARGUMENT, content);
            return statement.executeUpdate();
        }
    }

}
