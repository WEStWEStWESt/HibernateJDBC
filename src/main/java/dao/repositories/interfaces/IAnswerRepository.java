package dao.repositories.interfaces;

import dao.entity.Answers;

public interface IAnswerRepository {
    Answers getAnswer(String answer);

    void addAnswer(String answer);

    void removeAnswer(String answer);
}
