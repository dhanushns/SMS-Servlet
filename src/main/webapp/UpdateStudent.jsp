<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sms.Student"%>
<%-- adjust package --%>
<%
String username = (String) session.getAttribute("username");
if (username == null) {
	response.sendRedirect("./index.jsp");
	return;
}
%>
<%
String idParam = request.getParameter("id");
Student studentToUpdate = null;

if (idParam != null) {
	int searchId = Integer.parseInt(idParam);
	List<Student> students = (List<Student>) session.getAttribute("students");
	if (students != null) {
		for (Student s : students) {
	if (s.getId() == searchId) {
		studentToUpdate = s;
		break;
	}
		}
	}
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Update Student</title>
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
				<h3>Update student details</h3>
			</div>
			<div class="logout-link">
				<a href="/SMS/logout">Logout</a>
			</div>
		</div>

		<div class="add-form">
			<%
			if (studentToUpdate != null) {
			%>
			<form action="updateStudent" method="post">
				<%-- Include hidden id so server knows which student to update --%>
				<input type="hidden" name="id"
					value="<%=studentToUpdate.getId()%>" />

				<div class="group g1">
					<div class="block b1">
						<label for="name">Student Name <span class="required">*</span></label>
						<input type="text" placeholder="name" name="name" required
							value="<%=studentToUpdate.getName()%>" />
					</div>
					<div class="block b2">
						<label for="age">Student Age <span class="required">*</span></label>
						<input type="number" placeholder="age" name="age" required
							value="<%=studentToUpdate.getAge()%>" />
					</div>
				</div>
				<div class="group g2">
					<div class="block b1">
						<label for="rollno">Student Roll No <span class="required">*</span></label>
						<input type="number" placeholder="roll no" name="rollno" required
							value="<%=studentToUpdate.getRoll_no()%>" />
					</div>
					<div class="block b2">
						<label for="department">Department <span class="required">*</span></label>
						<select name="department" required>
							<option value="">Select department</option>
							<option
								<%="Information Technology".equals(studentToUpdate.getDepartment()) ? "selected" : ""%>>Information
								Technology</option>
							<option
								<%="Computer Science and Eng".equals(studentToUpdate.getDepartment()) ? "selected" : ""%>>Computer
								Science and Eng</option>
							<option
								<%="Mechanical".equals(studentToUpdate.getDepartment()) ? "selected" : ""%>>Mechanical</option>
							<option
								<%="Artificial Intelligence and DataScience".equals(studentToUpdate.getDepartment()) ? "selected" : ""%>>Artificial
								Intelligence and DataScience</option>
							<option
								<%="Civil".equals(studentToUpdate.getDepartment()) ? "selected" : ""%>>Civil</option>
						</select>
					</div>
				</div>
				<div class="group g3">
					<div class="block b1">
						<label for="course">Course <span class="required">*</span></label>
						<select name="course" required>
							<option value="">Select course</option>
							<option
								<%="Java".equals(studentToUpdate.getCourse()) ? "selected" : ""%>>Java</option>
							<option
								<%="Python".equals(studentToUpdate.getCourse()) ? "selected" : ""%>>Python</option>
							<option
								<%="Web Technology".equals(studentToUpdate.getCourse()) ? "selected" : ""%>>Web
								Technology</option>
							<option
								<%="Cloud Technology".equals(studentToUpdate.getCourse()) ? "selected" : ""%>>Cloud
								Technology</option>
							<option
								<%="CyberSecurity".equals(studentToUpdate.getCourse()) ? "selected" : ""%>>CyberSecurity</option>
						</select>
					</div>
					<div class="block b2">
						<label for="score">Score <span class="required">*</span></label> <input
							type="number" name="score" placeholder="student score" required
							value="<%=studentToUpdate.getScore()%>" />
					</div>
				</div>
				<div class="group g4">
					<button type="submit">Update Student</button>
					<button class="delete-btn" id="<%=idParam%>" type="button"
						onclick="deleteStudent(event)">Delete Student</button>
				</div>
			</form>
			<%
			} else {
			%>
			<p>
				Student not found. Please <a href="dashboard.jsp">go back</a>.
			</p>
			<%
			}
			%>
		</div>

	</div>
	<script src="script.js"></script>
</body>
</html>
