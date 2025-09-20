package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/fs")
public class FirstServlet extends GenericServlet {
	public static void main(String[] args) {

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		String place = req.getParameter("pl");

		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='orange'>" + "<h1>Student name is " + name + " from " + place + "</h1>"
				+ "</body></html>");

		out.close();
	}
}
