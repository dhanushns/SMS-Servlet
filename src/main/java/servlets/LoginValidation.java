package servlets;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.DB;
import com.sms.Student;

@WebServlet("/login")
public class LoginValidation extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		System.out.println(username);

		if (validate(username, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			DB db = new DB();
			db.query("select * from student");
			List<Student> studentList = new ArrayList<>();
			try {
				while (db.res.next()) {
					studentList.add(new Student(db.res.getInt("id"), db.res.getString("name"), db.res.getInt("age"),
							db.res.getInt("rollno"), db.res.getString("department"), db.res.getString("course"),
							db.res.getInt("score")));
				}
				session.setAttribute("students", studentList);
				res.sendRedirect("./dashboard.jsp");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			req.setAttribute("errorMessage", "Invalid username/password");
			req.getRequestDispatcher("/index.jsp").forward(req, res);
		}

	}

	public boolean validate(String username, String password) {

		try {
			DB db = new DB();
			db.query("select * from admin");
			while (db.res.next()) {
				if (username.equals(db.res.getString("username")) && password.equals(db.res.getString("password")))
					return true;
			}

		} catch (Exception err) {
			System.out.println(err);
		}

		return false;

	}

}
