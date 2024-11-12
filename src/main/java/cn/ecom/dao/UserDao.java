package cn.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cn.ecom.connection.DbCon;
import cn.ecom.model.User;

public class UserDao {

    // Method to register a user
    public boolean registerUser(User user) throws ClassNotFoundException {
        boolean isRegistered = false;

        // Check if a user with the same username or email already exists
        if (isUserExists(user.getUsername(), user.getEmail())) {
            System.out.println("User with the same username or email already exists.");
            return false;
        }

        String sql = "INSERT INTO users (username, email, phone_number, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbCon.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Set values to the prepared statement
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setString(4, user.getPassword()); // Store plain password (consider hashing in the future)

            // Execute the query
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                isRegistered = true;
                System.out.println("User registered successfully.");
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return isRegistered;
    }

    // Method to check if a user with the same username or email already exists
    private boolean isUserExists(String username, String email) throws ClassNotFoundException {
        String checkUserSql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";

        try (Connection conn = DbCon.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(checkUserSql)) {

            stmt.setString(1, username);
            stmt.setString(2, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    return true;  // User with same username or email already exists
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL Error during user existence check: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Method to validate user login
    public boolean isValidUser(String username, String password) {
        boolean isValid = false;
        String sql = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DbCon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (storedPassword.equals(password)) {
                        isValid = true; // Validate plain-text password (consider hashing)
                    }
                }
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("SQL Error during user validation: " + e.getMessage());
            e.printStackTrace();
        }

        return isValid;
    }
}
