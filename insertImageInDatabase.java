import java.util.*;
import java.io.*;
import java.sql.*;

public class insertImageInDatabase {
    public static void main(String[] args) {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //making credintials to be used in connections
        String url = "jdbc:mysql://localhost:3306/students";
        String userName = "root";
        String password = "aashu150198";
        Connection con = DriverManager.getConnection(url, userName, password);

        //make query
        String q = "insert into images(pic) values(?)";

        PreparedStatement pstmt = con.prepareStatement(q);

        FileInputStream fis = new FileInputStream("new1.jpg");

        pstmt.setBinaryStream(1,fis, fis.available());
        //fis.available - return number of binary stream available
        pstmt.executeUpdate();
        
        System.out.println("image inserted");
        con.close();
    
    }
    catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }
    }
}
