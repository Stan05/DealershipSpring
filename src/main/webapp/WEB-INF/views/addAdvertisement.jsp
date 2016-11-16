<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<html>
<head>
	<%@include file="bootstrap.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title </title>
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container" style="padding-left: 2%">
		<sf:form method="POST" commandName="advertisementForm">
			<sf:errors path="*" element="div" cssErrorClass="erorrs"/>
			<div class="form-group row" >
				<sf:label path="brand" class="col-sm-2 col-form-label">Brand: </sf:label>
				<div class="col-xs-3">
					<sf:input path="brand"  class="form-control"/>
				</div>
			</div>
			
			<div class="form-group row" >
				<sf:label path="model" class="col-sm-2 col-form-label">Model: </sf:label>
				<div class="col-xs-3">
					<sf:input path="model" class="form-control" />
				</div>
			</div>
			
			<div class="form-group row" >
				<sf:label path="firstRegistration" class="col-sm-2 col-form-label">First Registration: </sf:label>
				<div class="col-xs-2">
					<sf:select path="firstRegistration" class="form-control">
						<c:forEach begin="${beginYear}" end="${endYear}" var="year">
							<sf:option value="${year }">${year }</sf:option>
						</c:forEach>
					</sf:select>
				</div>
			</div>
			
			<div class="form-group row" >	
				<sf:label path="fuel" class="col-sm-2 col-form-label">Fuel: </sf:label>
					<div class="col-xs-4" style="margin-left: 2%">
						<div class="radio">
							<sf:radiobutton path="fuel" value="Diesel" />Diesel
						</div>
						<div class="radio">
							<sf:radiobutton path="fuel" value="Gasoline"/>Gasoline
						</div>
						<div class="radio">
							<sf:radiobutton path="fuel" value="Gasoline/Gas"/>Gasoline/Gas
						</div>
					</div>
			</div>
			
			<div class="form-group row" >
				<sf:label path="mileage" class="col-sm-2 col-form-label">Mileage: </sf:label>
				<div class="col-xs-3">
					<sf:input path="mileage" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group row" >
				<sf:label path="features" class="col-sm-2 col-form-label">Features: </sf:label>		
				<div class="col-xs-4">
						<sf:checkboxes items="${features }" itemLabel="featureName" path="features"  element="p" cssClass="checkbox" cssStyle="display:inline;"/>
				</div>
			</div>
			
			<div class="form-group row" >
				<label class="col-sm-2 col-form-label">Name: </label>
				<div class="col-xs-3">
					<input type="text" value="${ user.userContact.name}" readonly="readonly" class="form-control">
				</div>
			</div>
			
			<div class="form-group row" >
				<label class="col-sm-2 col-form-label">Phone Number: </label>
				<div class="col-xs-3">
					<input type="text" value="${ user.userContact.phoneNumber}" readonly="readonly" class="form-control">
				</div>
			</div>
			
			<div class="form-group row" >
				<label class="col-sm-2 col-form-label">Email: </label>
				<div class="col-xs-3">
					<input type="text" value="${ user.userContact.email}" readonly="readonly" class="form-control">
				</div>
			</div>	
				
			<div class="form-group row" >
				<label class="col-sm-2 col-form-label">City:  </label>
				<div class="col-xs-3">
					<input type="text" value="${ user.userContact.city}" readonly="readonly" class="form-control">
				</div>
			</div>
			
			<div class="form-group row" >		
				<sf:label path="price" class="col-sm-2 col-form-label">Price: </sf:label>
				<div class="col-xs-3">
					<sf:input path="price"  class="form-control"/>
				</div>
			</div>
			<div class="form-group row" >		
				<input type="submit" value="Save"  class="btn btn-primary">
				<a onclick="history.back()"  class="btn btn-primary">Cancel</a>
			</div>
		</sf:form>
	</div>
</body>
</html>