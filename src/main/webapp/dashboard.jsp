<%@ page import="java.util.*, com.sms.Student" %>
    <%@ page session="true" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Admin Dashboard</title>
            <link rel="stylesheet" href="styles.css">
            <script>
            	window.onload = async function(){
            		const response = await fetch("/SMS/getStudents",{
            			method : "GET"
            		});
            	}
            </script>
        </head>

        <body>
            <% List<Student> students = (List<Student>) session.getAttribute("students");

                    if (students == null) {
                    System.out.println("Not");
                    return;
                    }
                    %>
                    <div class="root-model">

                        <h2>Welcome, <%= session.getAttribute("username") %>!</h2>
                        <h3>Students List</h3>
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
                                <tbody>
                                    <% for (Student s : students) { %>
                                        <tr>
                                            <td>
                                                <%= s.getId() %>
                                            </td>
                                            <td>
                                                <%= s.getName() %>
                                            </td>
                                            <td>
                                                <%= s.getAge() %>
                                            </td>
                                            <td>
                                                <%= s.getRoll_no() %>
                                            </td>
                                            <td>
                                                <%= s.getDepartment() %>
                                            </td>
                                            <td>
                                                <%= s.getCourse() %>
                                            </td>
                                            <td>
                                                <%= s.getScore() %>
                                            </td>
                                        </tr>
                                        <% } %>
                                </tbody>
                            </table>
                        </div>

                    </div>
        </body>

        </html>