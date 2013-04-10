package com.FaceBack;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet  {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		System.out.println(name+"-"+ email+"-"+ password);
		
		MemberDAO dao = new MemberDAO();
		System.out.println("pass");
		dao.add(name, email, password);
		
		resp.sendRedirect("sendMsg.html");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGet(req, resp);
	}

}
