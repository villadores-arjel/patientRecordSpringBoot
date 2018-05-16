<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Patients</title>
	</head>
	<body>
		<h1>List of Patients</h1>
		<hr />
		<p align="right"><a href="<c:url value="/home" />">HOME</a></p>
		<c:forEach items="${patientList}" var="patient" >
			<div class="patients">
				<table>
					<tr>
						<td><c:out value="${patient.id}" /></td>
						<td><c:out value="${patient.firstName}" /></td>
						<td><c:out value="${patient.lastName}" /></td>
					</tr>
				</table>
			</div>
		</c:forEach>
	</body>
</html>