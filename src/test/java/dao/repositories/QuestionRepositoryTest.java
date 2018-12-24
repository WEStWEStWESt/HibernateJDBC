package dao.repositories;

import beans.entities.hibernate.Question;
import dao.repositories.interfaces.IQuestionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class QuestionRepositoryTest {

    private static String TEST_QUESTION = "test_question";
    private IQuestionRepository repository;

    @Before
    public void setUp() {
        repository = new QuestionRepository();
        repository.addQuestion(TEST_QUESTION);
    }

    @After
    public void tearDown() {
        repository.removeQuestion(TEST_QUESTION);
    }

    @Test
    public void getQuestion() {
        final Question QUESTION = repository.getQuestion(TEST_QUESTION);
        assertNotNull(QUESTION);
    }

    @Test
    public void addQuestion() {
        repository.addQuestion(TEST_QUESTION);
        String ACTUAL_QUESTION = repository.getQuestion(TEST_QUESTION).getQuestion();
        assertThat(ACTUAL_QUESTION, is(equalTo(TEST_QUESTION)));
    }

    @Test
    public void removeQuestion() {
        repository.removeQuestion(TEST_QUESTION);
        final Question NULL_QUESTION = repository.getQuestion(TEST_QUESTION);
        assertNull(NULL_QUESTION);
    }
}