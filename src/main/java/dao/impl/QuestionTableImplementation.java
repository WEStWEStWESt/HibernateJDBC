package dao.impl;
/*
import dao.driver.JdbcManagerConnectionPool;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.Questions;
import utils.sections.SqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

    public void removeQuestion(String questionValue) throws SQLException {
        Connection connection = null;
        AnswerTableImplementation answerHandler = new AnswerTableImplementation();
        //QuestionTableImplementation questionHandler = new QuestionTableImplementation();
        LinksTableImplementation linkHandler = new LinksTableImplementation();
        try {
            connection = JdbcManagerConnectionPool.getInstance().connection();
            connection.setAutoCommit(false);

            int questionId;
            if((questionId = selectEntity(questionValue, SqlQuery.SELECT_QUESTION.getSql(), connection)) == -1 ){
                throw new SQLException("*** no question ***");
            }

            List<Link> links;
            if ((links = linkHandler.getAllBoundedLinks(questionId, SqlQuery.SELECT_QUESTION_LINK.getSql(), connection)) != null){
                for (Link link: links) {
                    int answerID = link.getAnswerId();
                    linkHandler.deleteLink(link.getId(), connection);
                    if (answerID != 0){
                        answerHandler.deleteAnswer(answerID, connection);
                    }
                }
            }
            deleteQuestion(questionId, connection);
            connection.commit();
        } catch (SQLException e) {
            assert connection != null;
            connection.rollback();
        }finally {
            JdbcManagerConnectionPool.getInstance().closeConnection(connection);
        }
    }

    public void deleteQuestion(int id, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DELETE_QUESTION.getSql())) {
            statement.setInt(FIRST_ARGUMENT, id);
            statement.execute();
        }
    }
}*/
