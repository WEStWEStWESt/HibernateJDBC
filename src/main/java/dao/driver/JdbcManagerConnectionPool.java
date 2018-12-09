package dao.driver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

public class JdbcManagerConnectionPool {
    private static ComboPooledDataSource dataSource;
    private static JdbcManagerConnectionPool ourInstance;

    private JdbcManagerConnectionPool() {
        dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5433/postgres");
            dataSource.setUser("postgres");
            dataSource.setPassword("WESt14441987");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static JdbcManagerConnectionPool getInstance() {
        if(ourInstance == null){
            ourInstance = new JdbcManagerConnectionPool();
        }
        return ourInstance;
    }



    public Connection connection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("*** The connection is not available ***");
        }
        return connection;
    }

    public void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("*** The connection is not exist ***");
            }
        }
    }

    /* при работе с транзакциями рекоменд.закрывать resultSet & statement !!!*/
    public void closeStatement(Statement statement){
        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("*** The statement is not exist ***");
            }
        }
    }

    public void closeResultSet(ResultSet resultSet){
        if( resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("*** The resultSet is not exist ***");
            }
        }
    }

}
