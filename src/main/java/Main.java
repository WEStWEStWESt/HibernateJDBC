/*import dao.driver.HibernateFactoryManager;
import dao.driver.JdbcManagerConnectionPool;
import beans.entities.hibernate.Answers;
import beans.entities.hibernate.Questions;
import beans.entities.hibernate.Users;
import dao.impl.AnswerTableImplementation;
import dao.impl.LinksTableImplementation;
import dao.impl.QuestionTableImplementation;
import dao.impl.UserTableImplementation;*/

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

 /*      Connection connection = JdbcManagerConnectionPool.getInstance().connection();

        System.out.println(new UserTableImplementation().addUser(new Users("ZMEY")));

        System.out.println(new LinksTableImplementation().askQuestion(
                new Users("ZMEY"),
                new Questions("???")
        ));

        System.out.println(new AnswerTableImplementation().addAnswer(
                           new Answers("!!!"), connection));
        //new QuestionTableImplementation().removeQuestion("Hi, what`s up?");

        System.out.println(new LinksTableImplementation().
               answerQuestion("ZMEY", "???", "!!!"));
*/


        //System.out.println(new LinksTableImplementation().getStatistics());
        //System.out.println(new UserTableImplementation().getUser("WESt"));
        //new AnswerTableImplementation().deleteAnswer(1, connection);
        //new UserTableImplementation().removeUser("WESt");

    }
}
