package cn.ecom.dao;

import java.util.List; // Import the List class
import cn.ecom.model.BookDtls;

public interface BookDao {
   // Method to add a book to the database
   public boolean addBook(BookDtls book);
   
   // Method to retrieve all books from the database
   public List<BookDtls> getAllBooks();
}
