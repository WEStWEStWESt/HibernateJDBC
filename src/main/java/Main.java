import dao.driver.JdbcManager;
import dao.entity.Answers;
import dao.entity.Questions;
import dao.entity.Users;
import dao.impl.AnswerTableImplementation;
import dao.impl.LinksTableImplementation;
import dao.impl.QuestionTableImplementation;
import dao.impl.UserTableImplementation;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
         Connection connection = JdbcManager.connection();

        /*System.out.println(new UserTableImplementation().addUser(new Users("Lexa")));

        System.out.println(new LinksTableImplementation().askQuestion(
                new Users("Lexa"),
                new Questions("Are you imbicil ?")
        ));

        System.out.println(new AnswerTableImplementation().addAnswer(
                           new Answers("No, I'm crazy )))"), connection));
        //new QuestionTableImplementation().removeQuestion("Hi, what`s up?");*/

//        System.out.println(new LinksTableImplementation().
//                answerQuestion("WESt_1", "Hi, what`s up?", "go to JPAI"));


        System.out.println(new LinksTableImplementation().getStatistics());
        //System.out.println(new UserTableImplementation().getUser("WESt"));
        //new AnswerTableImplementation().deleteAnswer(1, connection);
        //new UserTableImplementation().removeUser("WESt");

    }
}
