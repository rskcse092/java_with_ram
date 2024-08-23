package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPostgresRead {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/test"; // Replace with your database details
        String user = "postgres"; // Replace with your PostgreSQL username
        String password = "postgres"; // Replace with your PostgreSQL password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load PostgreSQL JDBC Driver (optional for newer versions)
            Class.forName("org.postgresql.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(url, user, password);

            // Create a statement to execute SQL queries
            statement = connection.createStatement();

            // SQL query to read data from the table (replace with your table name)
            String query = "SELECT * FROM emp";

            // Execute the query and get the result set
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Assuming your table has columns 'id' and 'name', adjust accordingly
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sal = resultSet.getString("sal");

                // Print the retrieved data
                System.out.println("ID: " + id + ", Name: " + name + ", sal:" + sal);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error executing query.");
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
