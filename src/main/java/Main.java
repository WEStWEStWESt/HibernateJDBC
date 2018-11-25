import dao.driver.JdbcManager;
import dao.entity.Users;
import dao.impl.UserTableImplementation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JdbcManager.connection();
        System.out.println("true");

        System.out.println(new UserTableImplementation().addUser(new Users("WESt")));
    }
}
