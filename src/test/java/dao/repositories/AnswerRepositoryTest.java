package dao.repositories;

import beans.entities.hibernate.Answer;
import dao.repositories.interfaces.IAnswerRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class AnswerRepositoryTest {

    private static String TEST_ANSWER = "test_answer";
    private IAnswerRepository repository;

    @Before
    public void setUp() {
        repository = new AnswerRepository();
        repository.addAnswer(TEST_ANSWER);
    }

    @After
    public void tearDown() {
        repository.removeAnswer(TEST_ANSWER);
    }

    @Test
    public void getAnswer() {
        final Answer ANSWER = repository.getAnswer(TEST_ANSWER);
        assertNotNull(ANSWER);
    }

    @Test
    public void addAnswer() {
        repository.addAnswer(TEST_ANSWER);
        String ACTUAL_ANSWER = repository.getAnswer(TEST_ANSWER).getAnswer();
        assertThat(ACTUAL_ANSWER, is(equalTo(TEST_ANSWER)));
    }

    @Test
    public void removeAnswer() {
        repository.removeAnswer(TEST_ANSWER);
        final Answer NULL_ANSWER = repository.getAnswer(TEST_ANSWER);
        assertNull(NULL_ANSWER);
    }
}