package com.sms;

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


@WebServlet("/login")
public class LoginValidation extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        System.out.println(username);
        
        if(validate(username,password)) {
        	HttpSession session = req.getSession();
        	session.setAttribute("username", username);
        	//req.getRequestDispatcher("/dashboard.jsp").forward(req, res);
        }
        else {
        	req.setAttribute("errorMessage", "Invalid username/password");
        	//req.getRequestDispatcher("/index.jsp").forward(req, res);
        }
		
	}
	
	public boolean validate(String username,String password) {
		
		try {
			DB db = new DB();
			db.query("select * from admin");
			while(db.res.next()) {
				if(username.equals(db.res.getString("username")) && password.equals(db.res.getString("password"))) return true; 
			}
			
		}
		catch(Exception err) {
			System.out.println(err);
		}
		
		return false;
		
	}
	
}
