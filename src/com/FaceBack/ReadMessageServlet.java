package com.FaceBack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ReadMessageServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		String email = req.getParameter("email");
		if (email==null || "".equals(email)){
			email = "";
			HttpSession session=req.getSession();	
			email = (String)session.getAttribute("useremail");
		}
		
		MessageDAO mDAO = new MessageDAO();
		MemberDAO memberDao = new MemberDAO();
		
		if (email!=null && !"".equals(email))
		{
			ArrayList<Message> msgList = mDAO.retrieve(email);
			ArrayList<Member> writeToMemberList =  memberDao.getWriteToMemberList(email);
			req.setAttribute("msgList", msgList);
			req.setAttribute("memberList", writeToMemberList);
			req.getRequestDispatcher("read.jsp").forward(req, resp);
		}
		else{
			resp.sendRedirect("/");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req, resp);
	}
}
