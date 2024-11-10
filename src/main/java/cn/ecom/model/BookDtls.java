package cn.ecom.model;

import java.math.BigDecimal;

public class BookDtls {
    private int bookId; // corresponds to book Id
    private String bookName; // corresponds to bookname
    private String author;
    private BigDecimal price; // corresponds to price, using BigDecimal for money precision
    private String bookCategory; // corresponds to bookCategory
    private String status; // corresponds to status

    // Default constructor
    public BookDtls() {
        super();
    }

    // Parameterized constructor
    public BookDtls(int bookId, String bookName, String author, BigDecimal price, String bookCategory, String status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookCategory = bookCategory;
        this.status = status;
    }

    // Getter and setter methods
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookDtls [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
                + ", bookCategory=" + bookCategory + ", status=" + status + "]";
    }
}
