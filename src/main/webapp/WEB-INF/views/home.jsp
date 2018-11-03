<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Patients Record</title>
	</head>
	<body>
		<h1>Add new record</h1>
		<hr />
		<a th:href="@{/home?lang=en}">English</a>
		<br/>
		<a th:href="@{/home?lang=fr}">French</a>
		<div th:errors="${patient.*}">...</div>
		<div class="addForm">
			<form action="home" method="POST" th:object="${patient}">
				<table>
					<tr>
						<td th:text="#{label.firstName}"></td>
						<td><input th:field="*{patient.firstName}" /></td>
						<td><span th:errors="*{patient.firstName}"></span></td>
					</tr>
					<tr>
						<td>Enter middle name</td>
						<td><input th:field="*{patient.midName}" /></td>
						<td><span th:errors="*{patient.midName}"></span></td>
					</tr>
					<tr>
						<td>Enter last name</td>
						<td><input th:field="*{patient.lastName}" /></td>
						<td></td>
					</tr>
					<tr>
						<td>Enter email address</td>
						<td>
							<input type="email" name="emailAdd" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Enter Date of Birth</td>
						<td>
							<input type="date" name="patient.birthDate" />
						</td>
					</tr>
					<tr>
						<td>Enter Address</td>
						<td>
							<textarea name="address" rows="3"></textarea>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Enter Contact Number</td>
						<td>
							<input type="number" name="contactNumber" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td>Select Gender</td>
						<td>
							<select th:field="*{patient.gender.id}">
								<option value="0">Select One</option>
								<option th:each="gender:${genderList}" th:value="${gender.id}" th:text="${gender.description}"></option>
							</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</table>
			</form>
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
		<a th:href="@{/view}">View all records</a>
		</div>
		
	</body>
</html>