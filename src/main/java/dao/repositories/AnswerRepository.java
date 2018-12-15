package dao.repositories;

import dao.entity.Answers;
import dao.repositories.interfaces.IAnswerRepository;

public class AnswerRepository extends AbstractRepository implements IAnswerRepository {

    @Override
    public Answers getAnswer(String answer) {
        return null;
    }

    @Override
    public void addAnswer(String answer) {

    }

    @Override
    public void removeAnswer(String answer) {

    }
}
