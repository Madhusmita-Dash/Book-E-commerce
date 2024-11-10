<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>Admin: All Orders</title>
    <%@ include file="allCss.jsp" %>
</head>
<body>

<%@ include file="navbar.jsp" %>

<h3 class="text-center">Hello Admin</h3>

<table class="table table-striped">
    <thead class="bg-primary text-white">
        <tr>
            <th scope="col">Order Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Ph No</th>
            <th scope="col">Book Name</th>
            <th scope="col">Author</th>
            <th scope="col">Price</th>
            <th scope="col">Payment</th>
        </tr>
    </thead>
    <tbody>
        <!-- Dynamically generated rows will go here -->
        <!-- Example row -->
        <tr>
            <th scope="row">1</th>
            <td>John Doe</td>
            <td>johndoe@example.com</td>
            <td>123 Main St</td>
            <td>1234567890</td>
            <td>Java Programming</td>
            <td>Author Name</td>
            <td>$29.99</td>
            <td>Paid</td>
        </tr>
    </tbody>
</table>
<div style="margin-top:370px;"></div>
<%@ include file="footer.jsp" %>

</body>
</html>
