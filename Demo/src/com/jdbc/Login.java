package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username :");
		String uname = sc.next();
		System.out.println("Enter password");
		String pass = sc.next();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/btm", "root", "6113");
			pstmt = con.prepareStatement("select name from user_details where username=? and password=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				System.out.println("Welcome " + name);
			} else {
				System.out.println("username or password is wrong..");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sc.close();
		}
	}
}
