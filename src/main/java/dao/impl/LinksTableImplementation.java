package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Answers;
import dao.entity.Link;
import dao.entity.Questions;
import dao.entity.Users;
import dao.sections.SqlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinksTableImplementation extends AbstractTableImplementation {
    private final String USER_ID = "user_id";
    private final String QUESTION_ID = "question_id";
    private final String ANSWER_ID = "answer_id";

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

    public int answerQuestion(String userName, String questionValue, String answerValue) throws SQLException {
        /* Открыть соединение
         * открываем транзакцию
         * получить идентификатор пользователя
         * идентификатор вопроса
         * ищем связь, где есть идентификаторы нужных пользователя и вопроса, и пустое поле с ответом
         * если связи нет - откат
         * добавляем ответ в базу, если его нет
         * модифицируем связь
         * закрываем транзакцию*/
        Link link;
        int result = 0;
        Connection connection = null;

        try {
            connection = JdbcManager.connection();
            connection.setAutoCommit(false);

            int userId;
            int questionId;
            int answerId;

            if ((userId = selectEntity(userName, SqlQuery.SELECT_USER.getSql(), connection)) == -1) {
                throw new SQLException("*** Unknown user ***");
            }

            if ((questionId = selectEntity(questionValue, SqlQuery.SELECT_QUESTION.getSql(), connection)) == -1) {
                throw new SQLException("*** Unknown question ***");
            }

            if ((link = selectLink(userId, questionId, connection)) == null) {
                throw new SQLException("*** The question is not asked");
            }

            Answers answer = new Answers(answerValue);
            new AnswerTableImplementation().addAnswer(answer, connection);

            answerId = selectEntity(answerValue, SqlQuery.SELECT_ANSWER.getSql(), connection);

            result += updateLink(answerId, link.getId(), connection);

            connection.commit();

        } catch (SQLException e) {
            assert connection != null;
            connection.rollback();
        } finally {
            JdbcManager.closeConnection(connection);
        }
        return result;
    }

    public List<Link> getAllUserLinks(int userId, Connection connection) throws SQLException {
        ResultSet resultSet = null;
        List<Link> links;
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.SELECT_USER_LINK.getSql())) {
            /* задать действительное значение user id в запросе
             * исполнить запрос
             * извлеч значения из result set */
            statement.setInt(FIRST_ARGUMENT, userId);
            resultSet = statement.executeQuery();
            links = new ArrayList<>();
            while (resultSet.next()){
                links.add(new Link(resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("question_id"),
                        resultSet.getInt("answer_id")));
            }

            return links.size() > 0 ? links : null;


        } finally {
            JdbcManager.closeResultSet(resultSet);
        }
    }

    public void deleteLink(int id, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DELETE_LINK.getSql())) {
            statement.setInt(FIRST_ARGUMENT, id);
            statement.execute();
        }
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
                link = new Link(set.getInt(ID),set.getInt(USER_ID), set.getInt(QUESTION_ID), set.getInt(ANSWER_ID));
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

    private int updateLink(int answer_id, int id, Connection connection) throws SQLException {
       try (PreparedStatement statement =
                    connection.prepareStatement(SqlQuery.UPDATE_LINK.getSql())) {
           statement.setInt(FIRST_ARGUMENT, answer_id);
           statement.setInt(SECOND_ARGUMENT, id);

           return statement.executeUpdate();
       }
    }
}
