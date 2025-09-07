package com.getdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fs")
public class FirstSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("i");
		int id = Integer.parseInt(sid);

		// Jdbc logic
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=6113");
			pstmt = con.prepareStatement("select * from btm.students where id=?");

			// set the data
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			PrintWriter out = resp.getWriter();
			if (rs.next()) {
				String nm = rs.getString("name");
				String dp = rs.getString("dept");

				// presentation logic
				out.println("<html><body bgcolor='green'>" + "<h1>Name is " + nm + " from department " + dp + "</h1>"
						+ "</body></html>");
			} else {
				out.println("<html><body bgcolor='red'>" + "<h1>No Data Found</h1>" + "</body></html>");
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
		}

	}
}