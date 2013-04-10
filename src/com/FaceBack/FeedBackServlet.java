package com.FaceBack;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class FeedBackServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String feedback = req.getParameter("feedback");
		new FeedBackDAO().add(feedback);
		
		//resp.setContentType("text/html");
		//resp.getWriter().println("<p>Thank you for feedback!</p><a href='./index.html'>back</a>");
		resp.sendRedirect("/");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		doGet(req,resp);
	}
}
