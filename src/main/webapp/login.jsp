<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <%@ include file="all_component/allCss.jsp" %>
</head>
<body>
    <%-- Include Navbar --%>
    <%@ include file="all_component/navbar.jsp" %>

    <div class="container">
        <h2 class="text-center">Login</h2>

        <%-- Check for success message from registration --%>
        <div class="alert alert-success" role="alert" <% if(request.getAttribute("successMessage") == null) { %>style="display:none;"<% } %>>
            <%= request.getAttribute("successMessage") %>
        </div>

        <form action="LoginServlet" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block">Login</button>
        </form>

        <div class="text-center mt-3">
            <p>Don't have an account? <a href="registration.jsp">Register here</a></p>
        </div>
    </div>

    <%-- Include Footer --%>
    
    <%@ include file="all_component/footer.jsp" %>
</body>
</html>
