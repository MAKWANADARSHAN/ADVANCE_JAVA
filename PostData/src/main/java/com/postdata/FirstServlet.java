package com.postdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fs")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("i");
		int id = Integer.parseInt(sid);
		String sname = req.getParameter("nm");
		String sdept = req.getParameter("dp");
		String sprec = req.getParameter("pr");
		Double prec = Double.parseDouble(sprec);

		PrintWriter out = resp.getWriter();

		out.println("<html><body bgcolor='purple'>" + "<h1>Student name is " + sname + "  from " + sdept + " </h1>"
				+ " </body></html>");

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=6113");
			pstmt = con.prepareStatement("insert into btm.students values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, sname);
			pstmt.setString(3, sdept);
			pstmt.setDouble(4, prec);
			pstmt.executeUpdate();
			System.out.println("data.................");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
