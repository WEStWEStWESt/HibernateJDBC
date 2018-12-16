package dao.repositories.interfaces;

import beans.entities.hibernate.Answer;

public interface IAnswerRepository {
    Answer getAnswer(String answer);

    void addAnswer(String answer);

    void removeAnswer(String answer);
}
