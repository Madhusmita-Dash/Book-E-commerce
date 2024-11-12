package cn.ecom.model;

public class BookDtls {
    private int bookId;
    private String bookName;
    private String authorName;
    private String price;
    private String bookCategories;
    private String status;
    private String photo;

    // Constructor
    public BookDtls() {}

    public BookDtls(String bookName, String authorName, String price, String bookCategories, String status, String photo) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.bookCategories = bookCategories;
        this.status = status;
        this.photo = photo;
    }

    // Getters and Setters
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(String bookCategories) {
        this.bookCategories = bookCategories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "BookDtls [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" +
                price + ", bookCategories=" + bookCategories + ", status=" + status + ", photo=" + photo + "]";
    }
}
