<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Patients</title>
		
		<spring:url value="/css/styles.css" var="styles" />
		<link rel="stylesheet" type="text/css" href="${styles}" th:href="@{/css/styles.css}">
	</head>
	<body>
		<h1>List of Patients</h1>
		<hr />
		<p align="right"><a href="<c:url value="/home" />">HOME</a></p>
			<div class="patients">
				<table class="customTable">
					<thead>
						<tr>
							<th>ID</th>
							<th>First Name</th>
							<th>Middle Name</th>
							<th>Last Name</th>
							<th>Email Address</th>
							<th>Address</th>
							<th>Contact Number</th>
							<th>Gender</th>
							<th>Date of Birth</th>
						</tr>
					</thead>
					<c:forEach items="${patientList}" var="patient" >
					<tr>
						<td><c:out value="${patient.id}" /></td>
						<td><c:out value="${patient.firstName}" /></td>
						<td><c:out value="${ patient.midName }" /></td>
						<td><c:out value="${patient.lastName}" /></td>
						<td><c:out value="${ patient.emailAdd }" /></td>
						<td><c:out value="${ patient.address }" /></td>
						<td><c:out value="${ patient.contactNumber }" /></td>
						<td><c:out value="${ patient.gender }"/></td>
						<td><c:out value="${ patient.birthDate }" /></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		
	</body>
</html>