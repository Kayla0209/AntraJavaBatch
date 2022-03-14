package week3day1;

import week3day1.utils.JdbcConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcSuccessConnectionTest {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                JdbcConfig.getUrl(), JdbcConfig.getUser(), JdbcConfig.getPassword());
        System.out.println("connection has been built.");

        if (con != null) {
            con.close();
        }
    }
}
