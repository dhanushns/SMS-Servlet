package com.sms;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getStudents")
public class DashboardServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session = req.getSession();
		DB db = new DB();
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
        	req.getRequestDispatcher("/dashboard.jsp").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
