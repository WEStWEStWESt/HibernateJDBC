package dao.impl;

import dao.entity.Answers;
import dao.sections.SqlQuery;
import java.sql.Connection;
import java.sql.SQLException;

public class AnswerTableImplementation extends AbstractTableImplementation {

    public int addAnswer(Answers answers, Connection connection) throws SQLException {
        int result = 0;
        String answer = answers.getAnswer();
        if (selectEntity(answer,
                         SqlQuery.SELECT_ANSWER.getSql(),
                         connection) < 0){
            result = insertEntity(answer,
                     SqlQuery.INSERT_ANSWER.getSql(),
                     connection);
        }
        return result;
    }
}
