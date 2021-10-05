package SucculentQueryLang;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        String query =  "SELECT Z.jmeno" +
                        "FROM Zvirata AS Z" +
                        "         JOIN Druhy AS D ON (Z.druh = D.id)" +
                        "WHERE D.id NOT IN" +
                        "      (" +
                        "          SELECT MR.druh" +
                        "          FROM Ma_Rad AS MR" +
                        "      );";

        Connection connection = connectToDB("jdbc:mysql://localhost/c3zoo", "root", "");
        printResults(executeQuery(connection, query));
        connection.close();

    }

    public static Connection connectToDB(String uri, String usr, String pass) throws SQLException {
         return DriverManager.getConnection(
                uri, usr, pass
        );
    }

    public static void printResults(ResultSet result) throws SQLException {
        while(result.next()) {
            String animalName = result.getString("jmeno");
            String animalSpecies = result.getString("druh");
            System.out.println(animalName + "\t" + animalSpecies);
        }
    }

    public static ResultSet executeQuery(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

}
