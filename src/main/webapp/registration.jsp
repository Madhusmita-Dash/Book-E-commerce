<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<%@ include file="all_component/allCss.jsp" %>
<style type="text/css">
  .registration-container {
    margin-top: 50px;
    max-width: 500px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
</head>
<body>
<%@ include file="all_component/navbar.jsp" %>

<div class="container registration-container">
  <h2 class="text-center">Register</h2>
  <form action="RegistrationServlet" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" name="username" required>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="phoneNumber">Phone Number:</label>
      <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" pattern="[0-9]{10}" title="Enter a valid 10-digit phone number" required>
    </div>
    <div class="form-group">
      <label for="password">Password:</label>
      <!-- Simple password validation for minimum 6 characters -->
      <input type="password" class="form-control" id="password" name="password" minlength="6" required>
    </div>
   
    <button type="submit" class="btn btn-danger btn-block">Register</button>
  </form>
  <div class="text-center mt-3">
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
  </div>
</div>

<%@ include file="all_component/footer.jsp" %>
</body>
</html>
