package cn.admin.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.ecom.connection.DbCon;
import cn.ecom.dao.BookDao;
import cn.ecom.dao.BookDaoImpl;
import cn.ecom.model.BookDtls;

@WebServlet("/admin/add_books")
@MultipartConfig // Ensures support for multipart requests for file uploads
public class BooksAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data and validate input
        String bookName = request.getParameter("bname");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String categories = request.getParameter("categories");
        String status = request.getParameter("bstatus");
        Part part = request.getPart("bimg");

        // Check if any required field is missing
        if (bookName == null || author == null || price == null || categories == null || status == null || part == null || part.getSize() == 0) {
            request.setAttribute("errorMessage", "All fields are required, and a file must be uploaded.");
            request.getRequestDispatcher("add_books.jsp").forward(request, response);
            return;
        }

        // Get the file name and prepare to save the file
        String fileName = part.getSubmittedFileName();

        // Define path to save the file (use a safe path under the project directory)
        String uploadDir = getServletContext().getRealPath("") + File.separator + "book";
        File uploadDirectory = new File(uploadDir);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs(); // Create directory if it doesn't exist
        }

        // Define the file path to save
        String imagePath = uploadDir + File.separator + fileName;
        try {
            part.write(imagePath); // Save the image file to the directory
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to save the uploaded file.");
            request.getRequestDispatcher("add_books.jsp").forward(request, response);
            return;
        }

        // Create a BookDtls object and populate it with form data
        BookDtls book = new BookDtls(bookName, author, price, categories, status, fileName);

        // Add book using BookDao
        try {
            BookDao bookDao = new BookDaoImpl(DbCon.getConnection());
            boolean isAdded = bookDao.addBook(book);
            if (isAdded) {
                response.sendRedirect("all_books.jsp?success=Book added successfully");
            } else {
                request.setAttribute("errorMessage", "Failed to add the book. Please try again.");
                request.getRequestDispatcher("add_books.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while adding the book. Please contact support.");
            request.getRequestDispatcher("add_books.jsp").forward(request, response);
        }
    }
}
