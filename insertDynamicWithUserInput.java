import java.util.*;
import java.io.*;
import java.sql.*;

public class insertDynamicWithUserInput {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //making credintials to be used in connections
            String url = "jdbc:mysql://localhost:3306/students";
            String userName = "root";
            String password = "aashu150198";

            Connection con = DriverManager.getConnection(url, userName, password);

            //making a query
            String q = "insert into table1(tName,tCity) values(?,?)";

            //getting the PreparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the name : ");
            String name = br.readLine();
            System.out.println("enter your city :");
            String city = br.readLine();

            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();

            System.out.println("query inserted...");

            //closing the connection
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
