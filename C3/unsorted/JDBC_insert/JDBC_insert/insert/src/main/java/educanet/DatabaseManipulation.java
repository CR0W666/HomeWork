package educanet;

import java.sql.*;

public class DatabaseManipulation {

    public static void insert(int species, String name, int weight, String birthdate) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/c3zoo", "root", "");



        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO zvirata VALUES(NULL, ?, ?, ?, ?, NULL);");

        preparedStatement.setInt(1, species);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, weight);
        preparedStatement.setString(4, birthdate);

        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.close();
    }

}
