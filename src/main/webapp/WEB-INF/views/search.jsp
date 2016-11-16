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
	<%@include file="header.jsp" %>
	<div class="container">
		<sf:form method="POST" commandName="searchCriteria">
			<div class="form-group row" >
				<label class="col-sm-2 col-form-label">Registration Year: </label>
				<div class="col-sm-10">
					<sf:label path="fromYear">from: </sf:label>
					<sf:select path="fromYear" class="selectpicker show-menu-arrow">
						<sf:option value="-1"  label="" />
						<sf:options items="${possibleYears }"/>
					</sf:select>
					<sf:label path="toYear">to: </sf:label>
					<sf:select path="toYear" class="selectpicker show-menu-arrow">
					    <sf:option value="-1"  label=""/>
						<sf:options items="${possibleYears }"/>
					</sf:select>
				</div>
			</div>
			<div class="form-group row" >
				<div class="offset-sm-2 col-sm-10">
					<input type="submit" value="Search" class="btn btn-primary">
				</div>
			</div>
		</sf:form>
	</div>
</body>
</html>