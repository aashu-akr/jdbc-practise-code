import java.util.*;
import java.sql.*;

public class selectDaata {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //making credintials to be used in connections
            String url = "jdbc:mysql://localhost:3306/students";
            String userName = "root";
            String password = "aashu150198";
            //setting up a connection
            Connection con = DriverManager.getConnection(url, userName, password);

            String q = "select * from table1";

            //simple query so statement is used
            Statement stmt = con.createStatement();
            
            //storing the data in the result set
            ResultSet set = stmt.executeQuery(q);

            while(set.next())
            {
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(id +": "+name +": "+ city);
            }

            System.out.println("data feteched...");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
}
