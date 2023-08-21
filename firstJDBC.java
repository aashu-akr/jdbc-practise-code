import java.util.*;
import java.sql.*;

public class firstJDBC{
    public static void main(String[] args) {
        try{
            //loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //making credintials to be used in connections
            String url = "jdbc:mysql://localhost:3306/students";
            String userName = "root";
            String password = "aashu150198";

            //create a connection
            Connection con = DriverManager.getConnection(url, userName, password);
            //checking for successful connection creation
            if(con.isClosed())  System.out.println("Connection is Closed...");
            else    System.out.println("Connection Created Successfully...");

        }
        //catching any exception that is thrown
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}