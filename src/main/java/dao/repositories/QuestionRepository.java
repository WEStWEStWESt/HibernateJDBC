package dao.repositories;

import dao.entity.Questions;
import dao.repositories.interfaces.IQuestionRepository;

public class QuestionRepository extends AbstractRepository implements IQuestionRepository {

    @Override
    public Questions getQuestion(String question) {
        return null;
    }

    @Override
    public void addQuestion(String question) {

    }

    @Override
    public void removeQuestion(String question) {

    }
}
