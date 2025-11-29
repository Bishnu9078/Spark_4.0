package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectUsingPrepareDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd",
                    "root",
                    "Bishnu@068"
            );

            // ⭐ CHANGE 1: Write SELECT query
            String query = "SELECT * FROM student";

            // ⭐ CHANGE 2: Prepare statement
            PreparedStatement pstmt = con.prepareStatement(query);

            // ⭐ CHANGE 3: Execute query
            ResultSet rs = pstmt.executeQuery();

            // ⭐ CHANGE 4: Fetch rows
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("stdName") + " | " +
                                rs.getInt("age")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

