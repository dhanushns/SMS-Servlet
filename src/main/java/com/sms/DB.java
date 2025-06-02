package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	Connection connection;
	Statement stmt;
	public ResultSet res;
	private String url = "jdbc:mysql://localhost:3306/sms";
	private String dbuname = "root";
	private String dbpass = "root@14";
	
	public DB(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(this.url,this.dbuname,this.dbpass);
			this.stmt = connection.createStatement();
		}
		catch(Exception err) {
			System.out.println(err);
		}
	}
	
	public void query(String dbQuery) {
		try {
			this.res = this.stmt.executeQuery(dbQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}
	
}
