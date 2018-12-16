package dao.repositories.interfaces;


import beans.entities.hibernate.Question;

public interface IQuestionRepository {
    Question getQuestion(String question);

    void addQuestion(String question);

    void removeQuestion(String question);
}
