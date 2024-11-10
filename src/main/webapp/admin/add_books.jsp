<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin: Add Books</title>
    <%@ include file="allCss.jsp" %>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-4">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center mb-4">Add New Book</h3>

                        <form action="../BooksAdd" method="post">
                            <c:if test="${not empty errorMessage}">
                                <p style="color:red;">${errorMessage}</p>
                            </c:if>

                            <label for="bookName">Book Name:</label>
                            <input type="text" id="bookName" name="bookName" required><br><br>

                            <label for="author">Author:</label>
                            <input type="text" id="author" name="author" required><br><br>

                            <label for="price">Price:</label>
                            <input type="text" id="price" name="price" required><br><br>

                            <label for="bookCategory">Category:</label>
                            <input type="text" id="bookCategory" name="bookCategory"><br><br>

                            <label for="status">Status:</label>
                            <input type="text" id="status" name="status"><br><br>

                            <button type="submit">Add Book</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
