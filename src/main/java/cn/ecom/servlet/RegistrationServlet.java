package cn.ecom.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.ecom.model.User;
import cn.ecom.dao.UserDao;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");

        // Create User object
        User user = new User(username, email, phoneNumber, password);

        // Create UserDAO object to interact with the database
        UserDao userDao = new UserDao();
        boolean isRegistered = false;

        // Register the user and handle exceptions
        try {
            isRegistered = userDao.registerUser(user);
        } catch (ClassNotFoundException e) {
            // Log and send error response if there's a problem with the JDBC driver
            e.printStackTrace();
            request.setAttribute("errorMessage", "JDBC Driver not found. Please contact support.");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
            return;
        }

        // Handle response based on whether the registration was successful
        if (isRegistered) {
            // Set a success message in request
            request.setAttribute("successMessage", "Registration successful! Please log in.");
            // Redirect to login page with success message
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            // If registration fails, redirect back to registration page with error
            request.setAttribute("errorMessage", "Error in registration. Username or email might already exist.");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
