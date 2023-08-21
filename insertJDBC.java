import java.sql.*;
import java.util.*;

public class insertJDBC {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //making credintials to be used in connections
            String url = "jdbc:mysql://localhost:3306/students";
            String userName = "root";
            String password = "aashu150198";

            //create a connection
            Connection con = DriverManager.getConnection(url, userName, password);

            //create a query
            String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
            //query to create table with primary key and 3 rows 

            //create a statement
            Statement stmt = con.createStatement();

            stmt.executeUpdate(q); //we are not getting data in return so we are using update
            // we pass q in statment while firing the query

            System.out.println("table created in database...");

            con.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
