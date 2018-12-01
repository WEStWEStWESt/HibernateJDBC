package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Questions;
import dao.sections.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionTableImplementation extends AbstractTableImplementation {

    public int addQuestion(Questions questions, Connection connection) throws SQLException {
        int result = 0;
        String question = questions.getQuestion();
        if (selectEntity(question,
                         SqlQuery.SELECT_QUESTION.getSql(),
                         connection) < 0){
            result = insertEntity(question,
                                  SqlQuery.INSERT_QUESTION.getSql(),
                                  connection);
        }
        return result;
    }

    public void deleteQuestion(int id, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DELETE_QUESTION.getSql())) {
            statement.setInt(FIRST_ARGUMENT, id);
            statement.execute();
        }
    }
}
