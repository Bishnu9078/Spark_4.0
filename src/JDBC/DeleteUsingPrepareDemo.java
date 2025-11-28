package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUsingPrepareDemo {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mystd",
                    "root",
                    "Bishnu@068"
            );

            // ⭐ CHANGE 1: Delete query
            String query = "DELETE FROM student WHERE id=?";

            PreparedStatement pstmt = con.prepareStatement(query);

            // ⭐ CHANGE 2: Take ID from user
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID to delete: ");
            int deleteId = sc.nextInt();

            // ⭐ CHANGE 3: Set parameter
            pstmt.setInt(1, deleteId);

            // ⭐ CHANGE 4: Run delete
            int rows = pstmt.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted " + rows + " row(s)");
            else
                System.out.println("No record found for ID " + deleteId);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
