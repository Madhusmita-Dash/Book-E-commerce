package cn.admin.servlet;

import cn.ecom.dao.BookDao;
import cn.ecom.model.BookDtls;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/BooksAdd")
public class BooksAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String author = request.getParameter("author");
        String priceStr = request.getParameter("price");
        String bookCategory = request.getParameter("bookCategory");
        String status = request.getParameter("status");

        BigDecimal price = null;
        try {
            price = new BigDecimal(priceStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid price value.");
            request.getRequestDispatcher("add_book.jsp").forward(request, response);
            return;
        }

        BookDtls book = new BookDtls(0, bookName, author, price, bookCategory, status);
        BookDao bookDao = new BookDao();

        boolean isAdded = bookDao.addBook(book);

        if (isAdded) {
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to add the book. Please try again.");
            request.getRequestDispatcher("add_book.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add_book.jsp").forward(request, response);
    }
}
