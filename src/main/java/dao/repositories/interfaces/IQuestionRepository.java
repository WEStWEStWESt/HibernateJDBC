package dao.repositories.interfaces;


import beans.entities.hibernate.Questions;

public interface IQuestionRepository {
    Questions getQuestion(String question);

    void addQuestion(String question);

    void removeQuestion(String question);
}
