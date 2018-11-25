package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Questions;
import dao.sections.SqlQuery;

import java.sql.Connection;
import java.sql.SQLException;

public class QuestionTableImplementation extends AbstractTableImplementation {

    public int addQuestion(Questions questions, Connection connection) throws SQLException {
        int result = 0;
        String question = questions.getQuestion();
        if (selectEntity(question,
                         SqlQuery.SELECT_QUESTION.getSql(),
                         connection) == null){
            result = insertEntity(question,
                                  SqlQuery.INSERT_QUESTION.getSql(),
                                  connection);
        }
        return result;
    }
}
