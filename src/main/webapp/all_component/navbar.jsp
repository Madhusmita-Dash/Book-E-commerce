<div class="container-fluid p-3">
  <div class="row">
    <div class="col-md-3">
      <h3 class="text-success"><i class="fas fa-book"></i> E-Book</h3>
    </div>

    <div class="col-md-6">
      <form class="form-inline" style="display: flex;">
        <input class="form-control mr-2" type="search" placeholder="Search" aria-label="Search" style="flex-grow: 1;">
        <button class="btn btn-primary" type="submit">Search</button>
      </form>
    </div>

    <div class="col-md-3 text-right">
      <%
      if (session == null || session.getAttribute("username") == null) {
      %>
        <!-- Show Login and Register buttons if the user is not logged in -->
        <a href="login.jsp" class="btn btn-primary mr-1"><i class="fas fa-user"></i> Login</a>
        <a href="registration.jsp" class="btn btn-success"><i class="fas fa-user-plus"></i> Register</a>
      <%
      } else {
          // User is logged in, retrieve the username
          String username = (String) session.getAttribute("username");
      %>
        <!-- Display the username and Logout option if the user is logged in -->
        <div class="btn-group">
          <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user" style="color: #fafafa;"></i> <%= username %> <i class="arrow_carrot-down"></i>
          </button>
          <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="LogoutServlet">Logout</a>
          </div>
        </div>
      <%
      }
      %>
    </div>
  </div>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-primary">
  <div class="container">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link text-white" href="#"><i class="fas fa-home"></i> Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="#"><i class="fas fa-book"></i> Recent Book</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="#"><i class="fas fa-plus"></i> New Book</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="#"><i class="fas fa-archive"></i> Old Book</a>
      </li>
    </ul>
    <div>
      <a href="#" class="btn btn-light"><i class="fas fa-cog"></i> Setting</a>
      <a href="#" class="btn btn-light"><i class="fas fa-envelope"></i> Contact Us</a>
    </div>
  </div>
</nav>
