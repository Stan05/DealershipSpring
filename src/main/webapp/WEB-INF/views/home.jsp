<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<%@include file="bootstrap.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dealership</title>
</head>
<body>
	<div class="text-center" style="margin: 0 auto;width: 40%">
		<h1 class="title">Welcome to my Dealership</h1>
	 	<hr />
		<div id="alerts">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">
		 			<strong>${error}</strong> 
				</div>
			</c:if>
			<c:if test="${not empty logout}">
					<div class="alert alert-success">
		  				<strong>${logout}</strong> 
					</div>
			</c:if>
		</div>
		<div class="login-form-1">
			<form id="login-form" class="text-left" name="login"  method="POST">
				<div class="login-form-main-message"></div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<label for="lg_username" class="sr-only">Username</label>
							<input type="text" class="form-control" id="username" name="username" placeholder="username">
						</div>
						<div class="form-group">
							<label for="lg_password" class="sr-only">Password</label>
							<input type="password" class="form-control" id="password" name="password" placeholder="password">
						</div>
					</div>
					<input name="submit" type="submit" value="Login"  class="login-button" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</div>
			</form>
			<a href='<c:url value="/user/register" />' class="btn btn-info">Register</a>
			<a href='<c:url value="/view/all"/>' class="btn btn-info">View all</a>
		</div>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	if ($("#alerts").text().trim().length) {
		    $("#alerts").fadeOut(2000);
    }
});
</script>

</html>