package JDBC;

import java.sql.*;
import java.util.Scanner;

public class StudentCRUDMenu {

    private static final String URL = "jdbc:mysql://localhost:3306/mystd?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "Bishnu@068";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            boolean running = true;

            while (running) {
                System.out.println("\n=== Student Menu ===");
                System.out.println("1. Insert");
                System.out.println("2. Select all");
                System.out.println("3. Update (by id)");
                System.out.println("4. Delete (by id)");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int opt = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (opt) {
                    case 1 -> insertStudent(con, sc);
                    case 2 -> selectAll(con);
                    case 3 -> updateStudent(con, sc);
                    case 4 -> deleteStudent(con, sc);
                    case 5 -> {
                        running = false;
                        System.out.println("Exiting...");
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection con, Scanner sc) {
        String sql = "INSERT INTO student (id, stdName, age) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter id: ");
            ps.setInt(1, sc.nextInt());
            sc.nextLine();
            System.out.print("Enter name: ");
            ps.setString(2, sc.nextLine());
            System.out.print("Enter age: ");
            ps.setInt(3, sc.nextInt());
            sc.nextLine();

            int rows = ps.executeUpdate();
            System.out.println("Inserted " + rows + " row(s).");
        } catch (SQLException e) {
            System.out.println("Insert failed:");
            e.printStackTrace();
        }
    }

    private static void selectAll(Connection con) {
        String sql = "SELECT id, stdName, age FROM student";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nID | Name | Age");
            System.out.println("---------------------");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%d | %s | %d%n",
                        rs.getInt("id"),
                        rs.getString("stdName"),
                        rs.getInt("age"));
            }
            if (!found) System.out.println("No records found.");
        } catch (SQLException e) {
            System.out.println("Select failed:");
            e.printStackTrace();
        }
    }

    private static void updateStudent(Connection con, Scanner sc) {
        String sql = "UPDATE student SET stdName = ?, age = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter id to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new name: ");
            String name = sc.nextLine();
            System.out.print("Enter new age: ");
            int age = sc.nextInt();
            sc.nextLine();

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Updated " + rows + " row(s).");
            else System.out.println("No record found with id " + id);
        } catch (SQLException e) {
            System.out.println("Update failed:");
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection con, Scanner sc) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            System.out.print("Enter id to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Deleted " + rows + " row(s).");
            else System.out.println("No record found with id " + id);
        } catch (SQLException e) {
            System.out.println("Delete failed:");
            e.printStackTrace();
        }
    }
}
