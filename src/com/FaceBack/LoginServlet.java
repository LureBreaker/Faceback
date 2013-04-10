package com.FaceBack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.*;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String isReg = req.getParameter("hidReg");
		String type = req.getParameter("type");
		
		if ("logout".equals(type)){
			HttpSession session=req.getSession();
			session.removeAttribute("useremail");
			resp.sendRedirect("/");
			return;
		}
		
		MemberDAO memberDao = new MemberDAO();
		MessageDAO mDAO = new MessageDAO();
		
		
		if ("true".equals(isReg)){
			String name = req.getParameter("name");
			Member isMember = memberDao.retrieve(email);
			if (isMember==null)
				memberDao.add(name, email, password);
		}
		
		Member member = memberDao.retrieve(email, password);
		if (member!=null){
			HttpSession session=req.getSession();
			session.setAttribute("useremail", email);
			resp.sendRedirect("/readmessage");
		}
		else
		{
			req.setAttribute("error", "Login Failed");
			req.getRequestDispatcher("/").forward(req, resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req,resp);
	}
}
