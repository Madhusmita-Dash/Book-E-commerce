package cn.ecom.dao;

import cn.ecom.model.BookDtls;
import java.sql.*;
import java.math.BigDecimal;

public class BookDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ebook_management_system?useSSL=false&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "biswa083.";

    // Static block to explicitly register the MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    // Method to add a new book to the database
    public boolean addBook(BookDtls book) {
        boolean isAdded = false;
        String query = "INSERT INTO book_dtls (bookname, author, price, bookCategory, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement
            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getAuthor());
            stmt.setBigDecimal(3, book.getPrice());
            stmt.setString(4, book.getBookCategory());
            stmt.setString(5, book.getStatus());

            // Execute the update and check if a row was affected
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                isAdded = true;
            }
        } catch (SQLException e) {
            // Print SQL exception details for debugging
            e.printStackTrace();
        }

        return isAdded;
    }
}
