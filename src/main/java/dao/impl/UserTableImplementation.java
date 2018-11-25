package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Users;
import dao.sections.SqlQuery;
import java.sql.Connection;
import java.sql.SQLException;

public class UserTableImplementation extends AbstractTableImplementation{

    public int addUser(Users users) throws SQLException {
        int result = 0;
        String name;
        try (Connection connection = JdbcManager.connection()) {
            name = users.getName();
            if (selectEntity(name,
                    SqlQuery.SELECT_USER.getSql(),
                    connection) == null) {
                result = insertEntity(name,
                         SqlQuery.INSERT_USER.getSql(),
                         connection);
            }
        }
        return result;
    }

    public Users getUser(String name) throws SQLException {
        try (Connection connection = JdbcManager.connection()) {
            return (Users) selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection);
        }
    }
}
