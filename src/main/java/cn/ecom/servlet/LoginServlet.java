package cn.ecom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.ecom.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if the user is an admin
        if ("admin@gmail.com".equals(username) && "admin".equals(password)) {
            response.sendRedirect("admin/home.jsp");
            return; // Stop further processing after redirect
        }

        // Check if the user is a valid non-admin user
        UserDao userDao = new UserDao();
        boolean isValidUser = userDao.isValidUser(username, password);

        if (isValidUser) {
            // Create session and set username attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to user's home page
            response.sendRedirect("index.jsp");
        } else {
            // Invalid credentials, forward to login page with an error message
            request.setAttribute("errorMessage", "Invalid username or password. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
