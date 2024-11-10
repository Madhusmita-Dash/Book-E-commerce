<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin: Home</title>
    <%@ include file="allCss.jsp" %>
    <style type="text/css">
        a {
            text-decoration: none;
            color: black;
        }

        a:hover {
            text-decoration: none;
            color: black;
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %> <!-- Include the admin navbar for navigation -->

    <div class="container mt-4">
        <div class="row p-5">
            <!-- Add Books Card -->
            <div class="col-md-3 mb-4">
                <a href="add_books.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fas fa-plus-square fa-3x text-primary mb-2"></i>
                            <h4>Add Books</h4>
                        </div>
                    </div>
                </a>
            </div>

            <!-- All Books Card -->
            <div class="col-md-3 mb-4">
                <a href="all_books.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fas fa-book-open fa-3x text-danger mb-2"></i>
                            <h4>All Books</h4>
                        </div>
                    </div>
                </a>
            </div>

            <!-- Order Card -->
            <div class="col-md-3 mb-4">
                <a href="orders.jsp">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fas fa-box-open fa-3x text-warning mb-2"></i>
                            <h4>Order</h4>
                        </div>
                    </div>
                </a>
            </div>

            <!-- Logout Card -->
            <div class="col-md-3 mb-4">
                
                <!-- <a href="logout.jsp"> -->
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fas fa-sign-out fa-3x text-primary mb-2"></i>
                            <h4>Logout</h4>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
<div style="margin-top:150px;">
<%@ include file="footer.jsp" %> <!-- Include the footer -->
</div>
    
</body>
</html>
