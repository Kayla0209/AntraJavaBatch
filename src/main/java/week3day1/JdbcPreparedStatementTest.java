package week3day1;

import week3day1.utils.JdbcConfig;

import java.sql.*;

public class JdbcPreparedStatementTest {
    public static void main(String[] args) throws SQLException {
        try (
            Connection conn = DriverManager.getConnection(
                    JdbcConfig.getUrl(),
                    JdbcConfig.getUser(),
                    JdbcConfig.getPassword()
            );
            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into books value (?, ?, ?)"
            );
            PreparedStatement pstmtSelect = conn.prepareStatement("select * from books");
        ) {
            // set all the parameters
            pstmt.setString(1, "Python"); // 1 is the position, and "Python" is the value
            pstmt.setInt(2, 100);
            pstmt.setInt(3, 100);
            int rowsInserted = pstmt.executeUpdate(); // returns number of rows affected by the SQL statement
            System.out.println(rowsInserted + " records are inserted");

            // partial changes
            pstmt.setString(1, "C++");
            rowsInserted = pstmt.executeUpdate();
            System.out.println(rowsInserted + " records are inserted");

            ResultSet rset = pstmtSelect.executeQuery(); // returns a ResultSet obj
            while (rset.next()) {
                String title = rset.getString("title");
                String price = rset.getString("price");
                int qty = rset.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
            }
        }
    }
}
