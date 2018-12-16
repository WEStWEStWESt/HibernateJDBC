/*import dao.driver.HibernateFactoryManager;
import dao.driver.JdbcManagerConnectionPool;
import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.IUser;
import dao.impl.AnswerTableImplementation;
import dao.impl.LinksTableImplementation;
import dao.impl.QuestionTableImplementation;
import dao.impl.UserTableImplementation;*/

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

 /*      Connection connection = JdbcManagerConnectionPool.getInstance().connection();

        System.out.println(new UserTableImplementation().addUser(new IUser("ZMEY")));

        System.out.println(new LinksTableImplementation().askQuestion(
                new IUser("ZMEY"),
                new Question("???")
        ));

        System.out.println(new AnswerTableImplementation().addAnswer(
                           new Answer("!!!"), connection));
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
