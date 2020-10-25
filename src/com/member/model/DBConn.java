package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public DBConn() {}
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/kum-bang?serverTimezone=UTC";
		String id = "root";
		String pass = "rlaekfql05";
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("DB 연결\n");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
