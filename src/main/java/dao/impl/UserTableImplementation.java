package dao.impl;

import dao.driver.JdbcManager;
import dao.entity.Link;
import dao.entity.Users;
import dao.sections.SqlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserTableImplementation extends AbstractTableImplementation{

    public int addUser(Users users) throws SQLException {
        int result = 0;
        String name;
        try (Connection connection = JdbcManager.connection()) {
            name = users.getName();
            if (selectEntity(name,
                             SqlQuery.SELECT_USER.getSql(),
                             connection) > -1) {
                result = insertEntity(name,
                                      SqlQuery.INSERT_USER.getSql(),
                                      connection);
            }
        }
        return result;
    }

    public Users getUser(String name) throws SQLException {
        try (Connection connection = JdbcManager.connection()) {
            Users user = null;
            int id;
            if ((id = selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection)) > -1) {
                user = new Users(id, name);
            }
            return user ;
        }
    }

    public void deleteUser(String name) throws SQLException {
        Connection connection = null;
        QuestionTableImplementation questionHandler = new QuestionTableImplementation();
        AnswerTableImplementation answerHandler = new AnswerTableImplementation();
        LinksTableImplementation linkHandler = new LinksTableImplementation();
        try {
            connection= JdbcManager.connection();
            connection.setAutoCommit(false);

            int userId;
            if ((userId = selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection)) == -1) {
                throw new SQLException("*** unknown user ***");
            }

            List<Link> links;
            if ((links = linkHandler.getAllUserLinks(userId, connection)) != null) {
                for (Link link: links) {
                    int questionID = link.getQuestionId();
                    int answerID = link.getAnswerId();
                    linkHandler.deleteLink(link.getId(), connection);
                    if (questionID != 0) {
                        questionHandler.deleteQuestion(questionID , connection);
                    }
                    if (answerID != 0) {
                        answerHandler.deleteAnswer(answerID, connection);
                    }
                }
            }
            deleteUser(userId, connection);

            connection.commit();
        } catch (Exception e){
            assert connection != null;
            connection.rollback();
        } finally {
            JdbcManager.closeConnection(connection);
        }
    }

    private void deleteUser(int id, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DELETE_USER.getSql())) {
            statement.setInt(FIRST_ARGUMENT, id);
            statement.execute();
        }
    }
}
