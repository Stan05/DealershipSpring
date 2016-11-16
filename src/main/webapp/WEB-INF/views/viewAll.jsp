<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<title>Insert title </title>
</head>
<body>
	<%@include file="header.jsp"%>
	<table class="table table-inverse">
		<tr>
			<th>Brand</th>
			<th>Model</th>
			<th>Year</th>
			<th>Fuel</th>
			<th>Mileage</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${advertisementFormList}" var="item">
			<tr>
				<td>${item.brand}</td>
				<td>${item.model}</td>
				<td>${item.firstRegistration}</td>
				<td>${item.fuel}</td>
				<td>${item.mileage }</td>
				<td>${item.price}</td>
				<td><a href='<c:url value="/view/${item.id}"/>'><span class="glyphicon glyphicon-option-horizontal"> </span></a></td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href='<c:url value="/advertisement/delete/${item.id}"/>'><span class="glyphicon glyphicon-trash"> </span>  DELETE</a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>	
</body>
</html>