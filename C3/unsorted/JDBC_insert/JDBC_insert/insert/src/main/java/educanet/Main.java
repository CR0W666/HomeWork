package educanet;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c3zoo", "root", "");

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery("SELECT * FROM zvirata");

        DatabaseManipulation.insert(69, "Merlin", 420, "2003-2-16");
        
        while(results.next()) {
            System.out.print(results.getString("id") + "| ");
            System.out.print(results.getString("druh"));
            System.out.print(" " + results.getString("jmeno") + ": ");
            System.out.println("vaha: "+results.getString("vaha"));
            System.out.println("------------------");
        }

        

        connection.close();
    }
}
