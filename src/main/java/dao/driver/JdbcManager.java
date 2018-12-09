package dao.driver;

import java.sql.*;
/*
public class JdbcManager {
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("*** The driver connection failed ***");
        }
    }

    public static Connection connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres",
                                                     "postgres", "WESt1987");
        } catch (SQLException e) {
            System.out.println("*** The connection is not available ***");
        }
        return connection;
    }

    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("*** The connection is not exist ***");
            }
        }
    }

    при работе с транзакциями рекоменд.закрывать resultSet & statement !!!
    public static void closeStatement(Statement statement){
        if( statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("*** The statement is not exist ***");
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if( resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("*** The resultSet is not exist ***");
            }
        }
    }

}
        */