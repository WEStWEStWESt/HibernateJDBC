package dao.impl;
/*
import dao.driver.JdbcManagerConnectionPool;
import beans.entities.hibernate.Link;
import beans.entities.hibernate.IUser;
import utils.sections.SqlQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserTableImplementation extends AbstractTableImplementation{

    public int addUser(IUser users) throws SQLException {
        int result = 0;
        String name;
        try (Connection connection = JdbcManagerConnectionPool.getInstance().connection()) {
            name = users.getName();
            if (selectEntity(name,
                             SqlQuery.SELECT_USER.getSql(),
                             connection) == -1) {
                result = insertEntity(name,
                                      SqlQuery.INSERT_USER.getSql(),
                                      connection);
            }
        }
        return result;
    }

    public IUser getUser(String name) throws SQLException {
        try (Connection connection = JdbcManagerConnectionPool.getInstance().connection()) {
            IUser user = null;
            int id;
            if ((id = selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection)) > -1) {
                user = new IUser(id, name);
            }
            return user ;
        }
    }

    public void removeUser(String name) throws SQLException {
        Connection connection = null;
        QuestionTableImplementation questionHandler = new QuestionTableImplementation();
        AnswerTableImplementation answerHandler = new AnswerTableImplementation();
        LinksTableImplementation linkHandler = new LinksTableImplementation();
        try {
            connection = JdbcManagerConnectionPool.getInstance().connection();
            connection.setAutoCommit(false);

            int userId;
            if ((userId = selectEntity(name, SqlQuery.SELECT_USER.getSql(), connection)) == -1) {
                throw new SQLException("*** unknown user ***");
            }

            List<Link> links;
            if ((links = linkHandler.getAllBoundedLinks(userId, SqlQuery.SELECT_USER_LINK.getSql(), connection)) != null) {
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
            JdbcManagerConnectionPool.getInstance().closeConnection(connection);
        }
    }

    private void deleteUser(int id, Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SqlQuery.DELETE_USER.getSql())) {
            statement.setInt(FIRST_ARGUMENT, id);
            statement.execute();
        }
    }
}
*/