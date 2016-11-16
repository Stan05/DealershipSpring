<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
	<%@include file="bootstrap.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<div class="text-center" style="margin: 0 auto;width: 40%">
		<div class="login-form-1">
			<c:if test="${not empty exist}">
				<div class="error">${exist}</div>
			</c:if>
			<sf:form id="register-form" class="text-center" commandName="userForm" method="POST">
				<div class="login-form-main-message">
					<sf:errors path="*" element="div" cssErrorClass="login-form-main-message" />
				</div>
				<div class="main-login-form">
					<div class="login-group">
						<div class="form-group">
							<sf:label path="username" class="sr-only">Username </sf:label>
							<sf:input type="text" class="form-control" path="username" id="username" placeholder="Username"/>
						</div>
						<div class="form-group">
							<sf:label path="password" class="sr-only">Password</sf:label>
							<sf:input type="password" class="form-control" id="password" path="password" placeholder="Password"/>
						</div>
						<div class="form-group">
							<sf:label path="matchingPassword" class="sr-only">Password Confirm</sf:label>
							<sf:input type="password" class="form-control" id="matchingPassword" path="matchingPassword" placeholder="Confirm Password"/>
						</div>	
						<div class="form-group">
							<sf:label path="email" class="sr-only">Email</sf:label>
							<sf:input type="text" class="form-control" id="email" path="email" placeholder="Email"/>
						</div>
						<div class="form-group">
							<sf:label path="name" class="sr-only">Name</sf:label>
							<sf:input type="text" class="form-control" id="name" path="name" placeholder="Name"/>
						</div>
						<div class="form-group">
							<sf:label path="city" class="sr-only">City</sf:label>
							<sf:input type="text" class="form-control" id="city" path="city" placeholder="City"/>
						</div>	
						<div class="form-group">
							<sf:label path="phoneNumber" class="sr-only">Phone Number</sf:label>
							<sf:input type="text" class="form-control" id="phoneNumber" path="phoneNumber" placeholder="Phone Number"/>
						</div>
					</div>
					<input type="submit" value="Register">
				</div>
				<div class="etc-login-form">
					<p>already have an account? <a href="<c:url value="/view/all"/>">login here</a></p>
				</div>
			</sf:form>
		</div>
	</div>
</body>
</html>