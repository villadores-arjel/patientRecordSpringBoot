<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Patients Record</title>
	</head>
	<body>
		<h1>Add new record</h1>
		<hr />
		<div class="addForm">
			<sf:form action="home" method="post" modelAttribute="patient">
				<table>
					<tr>
						<td>Enter first name</td>
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
		<a href="<c:url value="/view" />">View all records</a>
		</div>
	</body>
</html>