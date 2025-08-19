package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddUsingPstmt {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "6113");
			pstmt = con.prepareStatement("insert into btm.student values(?,?,?)");
			pstmt.setInt(1, 101);
			pstmt.setString(2, "JILbha");
			pstmt.setDouble(3, 99.03);
			pstmt.executeUpdate();
			pstmt.setInt(1, 103);
			pstmt.setString(2, "JILbhai");
			pstmt.setDouble(3, 99.04);
			pstmt.executeUpdate();
			System.out.println("update succesfully....");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
