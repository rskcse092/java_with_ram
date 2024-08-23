package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPostgresCreateTable {

    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Load PostgreSQL JDBC Driver (optional for modern Java versions)
            Class.forName("org.postgresql.Driver");

            // Step 2: Establish the connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a statement to execute SQL queries
            statement = connection.createStatement();

            // Step 4: Define the SQL CREATE TABLE query
            String createTableSQL = "CREATE TABLE employees (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name VARCHAR(100) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "department VARCHAR(50))";

            // Step 5: Execute the CREATE TABLE query
            statement.execute(createTableSQL);

            System.out.println("Table 'employees' created successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
