package dao.repositories.interfaces;


import dao.entity.Questions;

public interface IQuestionRepository {
    Questions getQuestion(String question);

    void addQuestion(String question);

    void removeQuestion(String question);
}
