package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Basic {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load and register succefully........");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=6113");
			System.out.println("login succefully...");
			stmt = con.createStatement();
			stmt.execute("insert into btm.student values(2,'jilubha',99.90)");
			System.out.println("value insert successfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (stmt != null) {
					try {
						stmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("close");
		}

	}
}
