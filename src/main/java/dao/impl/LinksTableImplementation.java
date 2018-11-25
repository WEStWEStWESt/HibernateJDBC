package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Entity;
import dao.entity.Link;
import dao.entity.Questions;
import dao.entity.Users;
import dao.sections.SqlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LinksTableImplementation extends AbstractTableImplementation {
    private final String USER_ID = "user_id";
    private final String QUESTION_ID = "question_id";
   // private final String ANSWER_ID = "answer_id";

    public int askQuestion(Users user, Questions question) throws SQLException {
        Connection connection = null;
        int result = 0;
        int userId;
        int questionId;
        try {
            String userName = user.getName();
            String content = question.getQuestion();

            connection = JdbcManager.connection();
            connection.setAutoCommit(false);

            if ((userId = selectEntity(userName,
                         SqlQuery.SELECT_USER.getSql(),
                         connection)) < 0) {
                throw new RuntimeException("*** The user is not exist ***");
            }
            user.setId(userId);
            if (selectEntity(content,
                             SqlQuery.SELECT_QUESTION.getSql(),
                             connection) < 0){
                insertEntity(content,
                              SqlQuery.INSERT_QUESTION.getSql(),
                              connection);
                if ((questionId = selectEntity(content,
                        SqlQuery.SELECT_QUESTION.getSql(),
                        connection)) > -1) {
                    question = new Questions(questionId, content);
                }
            }
            result = insertLink(user, question, connection);

            connection.commit();
        } catch (Exception e) {
            assert connection != null;
            connection.rollback();
        } finally {
            JdbcManager.closeConnection(connection);
        }
        return result;
    }

    private Link selectLink(int userId, int questionId, Connection connection) throws SQLException {
        ResultSet set = null;
        Link link = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(SqlQuery.SELECT_QUESTION_LINK.getSql())){
            statement.setInt(FIRST_ARGUMENT, userId);
            statement.setInt(SECOND_ARGUMENT, questionId);
            set = statement.executeQuery();
            if (set.next()) {
                link = new Link(set.getInt(USER_ID), set.getInt(QUESTION_ID));
            }
        } finally {
            JdbcManager.closeResultSet(set);
        }
        return link;
    }

    private int insertLink(Users user, Questions question, Connection connection) throws SQLException {
        int userId = user.getId();
        int questionId = question.getId();
        int result = 0;
        if (selectLink(userId, questionId, connection) == null) {
            try (PreparedStatement statement =
                         connection.prepareStatement(SqlQuery.INSERT_QUESTION_LINK.getSql())){
                statement.setInt(FIRST_ARGUMENT, userId);
                statement.setInt(SECOND_ARGUMENT, questionId);
                result = statement.executeUpdate();
            }
        }
        return result;
    }
}
