<%@ page import="java.util.*, com.sms.Student"%>
<%@ page session="true"%>
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
<title>Admin Dashboard</title>
<link rel="stylesheet" href="styles.css">
</head>

<body>
	<%
	List<Student> students = (List<Student>) session.getAttribute("students");

	if (students == null) {
		response.sendRedirect("./index.jsp");
		return;
	}
	%>
	<div class="root-model">

		<h2>
			Welcome,
			<%=session.getAttribute("username")%>!
		</h2>
		<div class="title">
			<div class="lablel">
				<h3>Students List</h3>
			</div>
			<div class="logout-link">
				<a href="/SMS/logout">Logout</a>
			</div>
		</div>
		<div class="add-btn">
			<a href="/SMS/newStudent.jsp">New Student</a>
		</div>
		<div class="list-model">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Roll no</th>
						<th>Department</th>
						<th>Course</th>
						<th>Score</th>
					</tr>
				</thead>
				<tbody id="tb-body">
					<%
					for (Student s : students) {
					%>
					<tr onclick="updateStudent(event)">
						<td id="<%=s.getId()%>"><%=s.getId()%></td>
						<td id="<%=s.getId()%>"><%=s.getName()%></td>
						<td id="<%=s.getId()%>"><%=s.getAge()%></td>
						<td id="<%=s.getId()%>"><%=s.getRoll_no()%></td>
						<td id="<%=s.getId()%>"><%=s.getDepartment()%></td>
						<td id="<%=s.getId()%>"><%=s.getCourse()%></td>
						<td id="<%=s.getId()%>"><%=s.getScore()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>

	</div>
	<script src="script.js"></script>
</body>
</html>