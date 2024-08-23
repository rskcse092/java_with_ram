package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPostgresInsertRows {

    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load PostgreSQL JDBC Driver (optional for modern Java versions)
            Class.forName("org.postgresql.Driver");

            // Step 2: Establish the connection to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Define the SQL INSERT query using placeholders for parameters
            String insertSQL = "INSERT INTO employees (name, age, department) VALUES (?, ?, ?)";

            // Step 4: Prepare the statement
            pstmt = connection.prepareStatement(insertSQL);

            // Step 5: Insert 10 rows using a loop
            for (int i = 1; i <= 10; i++) {
                pstmt.setString(1, "Employee " + i); // Set name as "Employee i"
                pstmt.setInt(2, 20 + i); // Set age incrementally (e.g., 21, 22,...30)
                pstmt.setString(3, "Department " + (i % 3 + 1)); // Set department cyclically

                pstmt.executeUpdate(); // Execute the insertion
            }

            System.out.println("10 rows inserted successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
