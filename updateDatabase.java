import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.DriverManager;

public class updateDatabase {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //making credintials to be used in connections
            String url = "jdbc:mysql://localhost:3306/students";
            String userName = "root";
            String password = "aashu150198";
            //setting up a connection
            Connection con = DriverManager.getConnection(url, userName, password);

            //making a query
            String q = "update table1 set tName = ?, tCity = ? where tId = ?";

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter new name: ");
            String name = bf.readLine();

            System.out.println("enter new city: ");
            String city = bf.readLine();

            System.out.println("enter id: ");
            int id = Integer.parseInt(bf.readLine());

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);

            pstmt.executeUpdate();

            System.out.println("database updated...");
            con.close();            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
