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

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		DB db = new DB();
		String query = "UPDATE STUDENT SET name = " + "'" + req.getParameter("name") 
			+ "',"  + "age = " + req.getParameter("age") 
			+ "," + "rollno = " + req.getParameter("rollno")
			+ "," + "department = " + "'" + req.getParameter("department")
			+ "'," + "course = " + "'" + req.getParameter("course")
			+ "'," + "score = "  + req.getParameter("score") + " WHERE id = " + req.getParameter("id");
		
		db.update(query);
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
//			System.out.println("==>" + " " + studentList.get(0).getName());
			res.sendRedirect("./dashboard.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
