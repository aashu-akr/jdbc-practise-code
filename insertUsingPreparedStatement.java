//parameterized query - used when we are dealing with dynamic  or parameterized queries


import java.sql.*;
import java.util.*;

public class insertUsingPreparedStatement {
    
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
            String q = "insert into table1(tName,tCity) values(?,?)";

            //get the PreparedStatement object
            PreparedStatement pstmt = con.prepareStatement(q);

            // set values in the query

            pstmt.setString(1, "ashu");
            pstmt.setString(2, "asmoli");

            pstmt.executeUpdate();//no data is returned, //no need to pass the query again

            System.out.println("query inserted..");
    
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
