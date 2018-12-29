package dao.repositories;

import beans.entities.hibernate.Answer;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.Question;
import beans.entities.hibernate.User;
import dao.repositories.interfaces.IAnswerRepository;
import dao.repositories.interfaces.ILinkRepository;
import dao.repositories.interfaces.IQuestionRepository;
import dao.repositories.interfaces.IUserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkRepositoryTest {

    private static String TEST_VALUE = "test";
    private IUserRepository userRepository;
    private IQuestionRepository questionRepository;
    private IAnswerRepository answerRepository;

    @Before
    public void setUp() {
        userRepository = new UserRepository();
        questionRepository = new QuestionRepository();
        answerRepository = new AnswerRepository();
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
    }

    @Test
    @SuppressWarnings("ALL")
    public void answerQuestion() {

        ILinkRepository repository = new LinkRepository();
        User user = userRepository.getUser(TEST_VALUE);
        questionRepository.addQuestion(TEST_VALUE);
        answerRepository.addAnswer(TEST_VALUE);

        Question question = questionRepository.getQuestion(TEST_VALUE);
        repository.askQuestion(user, question);

        final List<Link> ACTUAL_LINK = repository.getLink(user, question);
        assertNotNull(ACTUAL_LINK);

        Answer answer = answerRepository.getAnswer(TEST_VALUE);
        answer.setAnswer(TEST_VALUE);

        final List<Link> ACTUAL_LINKs = repository.getLink(user, question, answer);
        assertNotNull(ACTUAL_LINKs);
    }
}