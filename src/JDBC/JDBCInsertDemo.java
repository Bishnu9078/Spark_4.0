package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCInsertDemo {

    public static void main(String[] args)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mystd", "root", "Bishnu@068");

            Statement statement = con.createStatement();
            //String query = "select * from student";
            String query = "INSERT INTO student (id, stdName, age) VALUES (4, 'Ankit', 23)";

            //ResultSet rs = statement.executeQuery(query);
            int update = statement.executeUpdate(query);
            System.out.println("Inserted " + update + " rows ");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
