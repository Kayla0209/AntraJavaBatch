package week3day1_jdbc;

import week3day1_jdbc.utils.JdbcConfig;

import java.sql.*;

public class JdbcMetaDataTest {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        JdbcConfig.getUrl(),
                        JdbcConfig.getUser(),
                        JdbcConfig.getPassword()
                );
                Statement stmt = conn.createStatement();
        ) {
            ResultSet reSet = stmt.executeQuery("select * from books");
            ResultSetMetaData rsetMD = reSet.getMetaData();
            int numColumns = rsetMD.getColumnCount();

            // print column class names
            for (int i = 1; i <= numColumns; i++) {
                System.out.printf("%-10s", rsetMD.getColumnName(i));
                // format: % means following is an argument that will be formatted
                //         - means resulting in left alignment
                //         30 fills the string up to a length of 30 characters, adding spaces at the end
                //         s means we are formatting a string
            }
            System.out.println();

            // print column contents for all the rows
            while (reSet.next()) {
                for (int i = 1; i <= numColumns; i++) {
                    System.out.printf("%-30s", reSet.getString(i));
                }
                System.out.println();
            }
        }
    }
}
