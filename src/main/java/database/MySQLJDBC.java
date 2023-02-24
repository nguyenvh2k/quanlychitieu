package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDBC  {
    
    public static Connection getConnection() {
        Connection c = null;
        String url = "jdbc:mysql://ap-southeast.connect.psdb.cloud/dev?sslMode=VERIFY_IDENTITY";
        String username = "hfbgtnevgh4enns8c5vv";
        String password = "pscale_pw_gpfkBNY1CiJURuJBiKKml4GNBz3WwX1mNRnlvfzrpwS";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    
    public static  void closeConnection(Connection connection) {
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
