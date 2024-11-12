package cn.ecom.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.ecom.model.BookDtls;

public class BookDaoImpl implements BookDao {
    private Connection conn;

    public BookDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addBook(BookDtls book) {
        boolean isAdded = false;
        try {
            String sql = "INSERT INTO book_dtls (bookname, authorname, price, bookCategories, status, photo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getBookName());
            ps.setString(2, book.getAuthorName());
            ps.setString(3, book.getPrice());
            ps.setString(4, book.getBookCategories());
            ps.setString(5, book.getStatus());
            ps.setString(6, book.getPhoto());

            int result = ps.executeUpdate();
            if (result == 1) {
                isAdded = true;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Good for logging/debugging
        }
        return isAdded;
    }

    @Override
    public List<BookDtls> getAllBooks() {
        List<BookDtls> list = new ArrayList<BookDtls>();
        BookDtls b = null;

        try {
        	String sql = "SELECT Id, bookName, authorName, price, bookCategories, status, photo FROM book_dtls";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new BookDtls();

                b.setBookId(rs.getInt("id")); // Use column name instead of index
                b.setBookName(rs.getString("bookName"));
                b.setAuthorName(rs.getString("authorName"));
                b.setPrice(rs.getString("price"));
                b.setBookCategories(rs.getString("bookCategories"));
                b.setStatus(rs.getString("status"));
                b.setPhoto(rs.getString("photo"));
                

                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }

        return list;
    }
}
