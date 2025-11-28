package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUsingPrepareDemo {

    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd",
                    "root",
                    "Bishnu@068"
            );

            String query = "INSERT INTO student (id, stdName, age) VALUES (?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);



            pstmt.setInt(1, 101);
            pstmt.setString(2, "Ankit");
            pstmt.setInt(3, 13);
            int update = pstmt.executeUpdate();

            pstmt.setInt(1, 102);
            pstmt.setString(2, "Ankit");
            pstmt.setInt(3, 13);
            pstmt.executeUpdate();

            System.out.println("Multiple rows updated ");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
