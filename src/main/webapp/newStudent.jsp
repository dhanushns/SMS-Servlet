<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = (String) session.getAttribute("username");
if (username == null) {
	response.sendRedirect("./index.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - New Student</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="root-model">
		<h2>
			Welcome,
			<%=session.getAttribute("username")%>!
		</h2>
		<div class="title">
			<div class="lablel">
				<h3>Add new student</h3>
			</div>
			<div class="logout-link">
				<a href="/SMS/logout">Logout</a>
			</div>
		</div>

		<div class="add-form">
			<form action="addStudent" method="post">
				<div class="group g1">
					<div class="block b1">
						<label for="name">Student Name <span class="required">*</span></label>
						<input type="text" placeholder="name" name="name" required>
					</div>
					<div class="block b2">
						<label for="age">Student Age <span class="required">*</span></label>
						<input type="number" placeholder="age" name="age" required>
					</div>
				</div>
				<div class="group g2">
					<div class="block b1">
						<label for="rollno">Student Roll No <span class="required">*</span></label>
						<input type="number" placeholder="roll no" name="rollno" required>
					</div>
					<div class="block b2">
						<label for="department">Department <span class="required">*</span></label>
						<select name="department" required>
							<option>Select department</option>
							<option>Information Technology</option>
							<option>Computer Science and Eng</option>
							<option>Mechanical</option>
							<option>Artificial Intelligence and DataScience</option>
							<option>Civil</option>
						</select>
					</div>
				</div>
				<div class="group g3">
					<div class="block b1">
						<label for="course">Course <span class="required">*</span></label>
						<select name="course" required>
							<option>Select course</option>
							<option>Java</option>
							<option>Python</option>
							<option>Web Technology</option>
							<option>Cloud Technology</option>
							<option>CyberSecurity</option>
						</select>
					</div>
					<div class="block b2">
						<label for="score">Score <span class="required">*</span></label> <input
							type="number" name="score" placeholder="student score" required>
					</div>
				</div>
				<div class="group g4">
					<button type="submit">Add Student</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>