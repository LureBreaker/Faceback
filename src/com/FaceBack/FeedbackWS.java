package com.FaceBack;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FeedbackWS extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	
		JSONObject res = new JSONObject();
		String type = req.getParameter("type");
		
		
		
		if ("writeFeedback".equals(type)){
			String feedback = req.getParameter("feedback");
			
			new FeedBackDAO().add(feedback);
			res.put("result", "success");
		}
		
		resp.setContentType("application/json");
		resp.getWriter().println(res.toJSONString());
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req, resp);
	}
}
