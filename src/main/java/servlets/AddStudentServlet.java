package servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.Student;
import com.sms.DB;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			
			DB db = new DB();
			String query = "INSERT INTO student (name,age,rollno,department,course,score) VALUES (" +
					"'" + req.getParameter("name") + "'" + "," +
					"'" + req.getParameter("age") + "'" + "," + 
					"'" + req.getParameter("rollno") + "'" + "," + 
					"'" + req.getParameter("department") + "'" + "," +
					"'" + req.getParameter("course") + "'" + "," + 
					"'" + req.getParameter("score") + "'" + ")";
			db.insert(query);
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
//				System.out.println("==>" + " " + studentList.get(0).getName());
				res.sendRedirect("./dashboard.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
			res.sendRedirect("./dashboard.jsp");
		}
		catch(Exception err) {
			System.out.println(err);
		}
		
	}

}
