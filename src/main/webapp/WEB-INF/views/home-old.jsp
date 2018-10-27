<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Patients Record</title>
	</head>
	<body>
		<h1>Add new record</h1>
		<hr />
		<spring:url value="/home?lang=en" var="linkEn" />
		<spring:url value="/home?lang=fr" var="linkFr" />
		<a href="${ linkEn }">English</a>
		<br/>
		<a href="${ linkFr }">French</a>
		<div class="addForm">
			<sf:form action="home" method="post" modelAttribute="patient">
				<table>
					<tr>
						<td><spring:message code="label.firstName"/></td>
						<td><sf:input path="firstName" /></td>
						<td><sf:errors path="firstName" /></td>
					</tr>
					<tr>
						<td>Enter middle name</td>
						<td><sf:input path="midName" /></td>
						<td><sf:errors path="midName" /></td>
					</tr>
					<tr>
						<td>Enter last name</td>
						<td><sf:input path="lastName" /></td>
						<td><sf:errors path="lastName" /></td>
					</tr>
					<tr>
						<td>Enter email address</td>
						<td>
							<input type="email" name="emailAdd" />
						</td>
						<td><sf:errors path="emailAdd" /></td>
					</tr>
					<tr>
						<td>Enter Date of Birth</td>
						<td>
							<input type="date" name="birthDate" />
						</td>
						<td><sf:errors path="birthDate" /></td>
					</tr>
					<tr>
						<td>Enter Address</td>
						<td>
							<textarea name="address" rows="3"></textarea>
						</td>
						<td><sf:errors path="address" /></td>
					</tr>
					<tr>
						<td>Enter Contact Number</td>
						<td>
							<input type="number" name="contactNumber" />
						</td>
						<td><sf:errors path="contactNumber" /></td>
					</tr>
					<tr>
						<td>Select Gender</td>
						<td>
							<select name="gender">
								<option value="M">Male</option>
								<option value="F">Female</option>
							</select>
						</td>
						<td><sf:errors path="gender" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</sf:form>
		</div>
		<hr />
		<h1>Search Record</h1>
		<div class="searchRecord">
			<form action="search" method="post">
				<table>
					<tr>
						<td>Enter name</td>
						<td><input type="text" name="name" /></td>
						<td><input type="submit" value="Search" /></td>
					</tr>
				</table>
			</form>
		<a href="<c:url value="/view" />" th:href="@{/view}">View all records</a>
		</div>
		
	</body>
</html>