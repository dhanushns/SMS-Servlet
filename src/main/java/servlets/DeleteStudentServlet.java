package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.DB;
import com.sms.Student;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		int student_id = Integer.parseInt(req.getParameter("id"));
		
		DB db = new DB();
		db.delete("student", student_id);
		HttpSession session = req.getSession();
		db.query("select * from student");
    	List<Student> studentList = new ArrayList<>();
		try {
			while(db.res.next()) {
				studentList.add(new Student(
						db.res.getInt("id"),
						db.res.getString("name"),
						db.res.getInt("age"),
						db.res.getInt("rollno"),
						db.res.getString("department"),
						db.res.getString("course"),
						db.res.getInt("score")
						));
			}
			session.setAttribute("students", studentList);
			res.sendRedirect("./dashboard.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			res.sendRedirect("./dashboard.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
