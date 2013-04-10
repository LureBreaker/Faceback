package com.FaceBack;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SendMsgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String email = req.getParameter("email");
		int year = Integer.parseInt(req.getParameter("year"));
		String happening = req.getParameter("happening");
		String name = req.getParameter("name");
		String from = req.getParameter("from");
		HttpSession session=req.getSession();
		from = (String)session.getAttribute("useremail");
		System.out.println(from);
		new MessageDAO().add(email, year, happening,name,from);
		
		resp.sendRedirect("sendMsg.html");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGet(req, resp);
	}
}
