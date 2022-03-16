package week3day1_jdbc;

import week3day1_jdbc.utils.JdbcConfig;

import java.sql.*;

public class JdbcBatchProcessingPreparedStatTest {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        JdbcConfig.getUrl(),
                        JdbcConfig.getUser(),
                        JdbcConfig.getPassword()
                );
                PreparedStatement pstmt = conn.prepareStatement(
                        "insert into books values (?, ?, ?)"
                );
        ) {
            conn.setAutoCommit(false);

            pstmt.setString(1, "G");
            pstmt.setInt(2, 123);
            pstmt.setInt(3, 321);
            pstmt.addBatch();

            pstmt.setString(1, "Jso");
            pstmt.setInt(2, 345);
            pstmt.addBatch();

            int[] returnCodes = pstmt.executeBatch();
            for (int code : returnCodes) {
                System.out.println(code + ", ");
            }
            conn.commit();
        }
    }
}