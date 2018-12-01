import dao.driver.JdbcManager;
import dao.entity.Questions;
import dao.entity.Users;
import dao.impl.LinksTableImplementation;
import dao.impl.UserTableImplementation;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JdbcManager.connection();


        //System.out.println(new UserTableImplementation().addUser(new Users("WESt")));
        System.out.println(new UserTableImplementation().getUser("WESt"));
        System.out.println(new LinksTableImplementation().askQuestion(
                new Users("WESt"),
                new Questions("Hi, what`s up?")
        ));
    }
}
