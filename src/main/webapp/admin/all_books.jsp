<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin: All Books</title>
    <%@ include file="allCss.jsp" %> <!-- Include all necessary CSS -->
</head>
<body>
    <%@ include file="navbar.jsp" %> <!-- Include the navigation bar -->

    <div class="container mt-4">
        <h3 class="text-center">Hello Admin</h3>

        <table class="table table-striped">
            <thead class="bg-primary text-white">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Book Name</th> <!-- Fixed typo from "Boook Name" to "Book Name" -->
                    <th scope="col">Author</th>
                    <th scope="col">Price</th>
                    <th scope="col">Categories</th>
                    <th scope="col">Status</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Book Title 1</td> <!-- Sample data -->
                    <td>Author 1</td> <!-- Sample data -->
                    <td>$20.00</td> <!-- Sample data -->
                    <td>Fiction</td> <!-- Sample data -->
                    <td>Available</td> <!-- Sample data -->
                    <td>
                        <a href="#" class="btn btn-sm btn-primary">Edit</a>
                        <a href="#" class="btn btn-sm btn-danger">Delete</a> <!-- Fixed typo from "btn-denger" to "btn-danger" -->
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Book Title 2</td> <!-- Sample data -->
                    <td>Author 2</td> <!-- Sample data -->
                    <td>$15.00</td> <!-- Sample data -->
                    <td>Non-fiction</td> <!-- Sample data -->
                    <td>Out of Stock</td> <!-- Sample data -->
                    <td>
                        <a href="#" class="btn btn-sm btn-primary">Edit</a>
                        <a href="#" class="btn btn-sm btn-danger">Delete</a> <!-- Fixed typo from "btn-denger" to "btn-danger" -->
                    </td>
                </tr>
                <!-- Additional rows can be added here -->
            </tbody>
        </table>
    </div>

<div style="margin-top:370px;"></div>
    <%@ include file="footer.jsp" %> <!-- Include the footer -->
</body>
</html>
