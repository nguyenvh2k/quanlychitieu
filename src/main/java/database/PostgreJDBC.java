package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreJDBC {
    
    public static Connection getConnection() {
        Connection connection = null;
        String host = "db.uoddykgmypogipcizabv.supabase.co";
        String port = "5432";
        String dbname = "postgres";
        String user = "postgres";
        String pass = "iLOVEYOU124@#$%^&*()";
        String dburl = "jdbc:postgresql://" + host + ":" + port + "/" + dbname + "?loggerLevel=OFF";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dburl, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void printInforDB(Connection connection) {
        if (connection != null) {
            try {
                DatabaseMetaData mtdt = connection.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
