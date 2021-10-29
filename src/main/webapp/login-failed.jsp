<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./css/style.min.css">
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
<div class="layer"></div>
<main class="page-center">
  <article class="sign-up">
    <h1 class="sign-up__title">Welcome back!</h1>
    <p style="color: red;" class="sign-up__subtitle">Username or Password is Incorrect</p>
    <form class="sign-up-form form" action="login" method="POST">
      <label class="form-label-wrapper">
        <p class="form-label">Username</p>
        <input class="form-input" name ="userName" type="text" placeholder="Enter your username" required>
      </label>
      <label class="form-label-wrapper">
        <p class="form-label">Password</p>
        <input class="form-input" name ="passWord" type="password" placeholder="Enter your password" required>
      </label>
      <button type="submit" class="form-btn primary-default-btn transparent-btn">Sign in</button>
    </form>
  </article>
</main>
<!-- Chart library -->
<script src="./plugins/chart.min.js"></script>
<!-- Icons library -->
<script src="plugins/feather.min.js"></script>
<!-- Custom scripts -->
<script src="js/script.js"></script>
</body>
</html>