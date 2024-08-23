package org.example ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPostgresUpdateRows {

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

            // Step 3: Define the SQL UPDATE query using placeholders for parameters
            String updateSQL = "UPDATE employees SET department = ? WHERE age > ?";

            // Step 4: Prepare the statement
            pstmt = connection.prepareStatement(updateSQL);

            // Step 5: Set the parameters for the update query
            pstmt.setString(1, "Updated Department"); // Set the new department value
            pstmt.setInt(2, 25); // Set the condition (update where age > 25)

            // Step 6: Execute the update query
            int rowsAffected = pstmt.executeUpdate();

            // Step 7: Check the number of rows updated
            System.out.println(rowsAffected + " rows updated successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL error occurred.");
            e.printStackTrace();
        } finally {
            // Step 8: Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
