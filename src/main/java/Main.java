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

/*  private static String TEST_VALUE = "test";
    private IUserRepository userRepository;
    private IQuestionRepository questionRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepository();
        questionRepository = new QuestionRepository();
        userRepository.addUser(TEST_VALUE);
    }

    @After
    public void tearDown() {
        userRepository.removeUser(TEST_VALUE);
    }

    @Test
    @SuppressWarnings("ALL")
    public void askQuestion() {
        ILinkRepository repository = new LinkRepository();
        User user = userRepository.getUser(TEST_VALUE);
        questionRepository.addQuestion(TEST_VALUE);

        Question question = questionRepository.getQuestion(TEST_VALUE);
        repository.askQuestion(user, question);

        final List<Link> ACTUAL_LINK = repository.getLink(user, question);
        assertNotNull(ACTUAL_LINK);
    }*/


        /*Connection connection = JdbcManagerConnectionPool.getInstance().connection();

        System.out.println(new UserTableImplementation().addUser(new IUser("ZMEY")));

        System.out.println(new LinksTableImplementation().askQuestion(
                new IUser("ZMEY"),
                new Question("???")
        ));

        System.out.println(new AnswerTableImplementation().addAnswer(
                           new Answer("!!!"), connection));
        //new QuestionTableImplementation().removeQuestion("Hi, what`s up?");

        System.out.println(new LinksTableImplementation().
               answerQuestion("ZMEY", "???", "!!!"));*/


        //System.out.println(new LinksTableImplementation().getStatistics());
        //System.out.println(new UserTableImplementation().getUser("WESt"));
        //new AnswerTableImplementation().deleteAnswer(1, connection);

    }
}
