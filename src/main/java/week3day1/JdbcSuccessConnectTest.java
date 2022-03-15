package week3day1;

import week3day1.utils.JdbcConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSuccessConnectTest {
    public static void main(String[] args) throws SQLException {
        //String url = "jdbc:mysql://localhost:3306/jdbc-demo";
        //String user = "root";
        //String password = "password";

        Connection con = DriverManager.getConnection(
                JdbcConfig.getUrl(),
                JdbcConfig.getUser(),
                JdbcConfig.getPassword());
        System.out.println("connection has been built");

        if (con != null) {
            con.close();
        }
    }
}
