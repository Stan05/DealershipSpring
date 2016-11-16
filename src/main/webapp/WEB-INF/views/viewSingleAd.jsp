<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<%@include file="bootstrap.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link href=<c:url value='/resources/singleAdStyle.css'/> type="text/css" rel="stylesheet">
	
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container" >
		<div class="form-group row" >
			<label class="col-sm-1">Brand:</label>
			<div class="cube">${advertisementForm.brand}</div> 
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Model:</label>
			<div class="cube">${advertisementForm.model}</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">First Registration:</label>
			<div class="cube">${advertisementForm.firstRegistration}</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Fuel:</label>
			 <div class="cube">${advertisementForm.fuel}</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Mileage:</label>
			<div class="cube"> ${advertisementForm.mileage}</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Features:</label>
			<c:forEach items="${advertisementForm.features}" var="feature">
			<div class="cube">${feature.featureName}</div>
			</c:forEach>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Name:</label>
			 <div class="cube">${advertisementForm.user.userContact.name}</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Phone Number:</label>
			<div class="cube">${advertisementForm.user.userContact.phoneNumber }</div>
		</div>
		<div class="form-group row" >
			 <label class="col-sm-1">Email:</label>
			  <div class="cube">${advertisementForm.user.userContact.email }</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">City:</label>
			<div class="cube">${advertisementForm.user.userContact.city }</div>
		</div>
		<div class="form-group row" >
			<label class="col-sm-1">Price:</label>
			 <div class="cube">${advertisementForm.price}</div>
		</div>
			
		<div class="form-group row" style="padding-left:1%;">
			<a onclick="history.back()"  class="btn btn-primary"><span class="glyphicon glyphicon-globe"> </span> View All</a>
			<sec:authorize access="isAuthenticated()">
				<c:set var="owner" value="${advertisementForm.user.username}" />
				<c:set var="user" value="${pageContext.request.userPrincipal.name }" />
				<c:if test="${user == owner}">
					<a href='<c:url value="/advertisement/delete/${advertisementForm.id}" />'  class="btn btn-primary"> <span class="glyphicon glyphicon-trash"> </span> Delete</a>
				</c:if>
			</sec:authorize>
		</div>
	</div>
</body>
</html>