package dao.repositories.interfaces;

import beans.entities.hibernate.Answers;

public interface IAnswerRepository {
    Answers getAnswer(String answer);

    void addAnswer(String answer);

    void removeAnswer(String answer);
}
