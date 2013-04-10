package com.FaceBack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MessageWS extends HttpServlet {
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		JSONObject res = new JSONObject();
		String type = req.getParameter("type");

		if ("readMessage".equals(type)) {
			String email = req.getParameter("email");
			List<Message> lst = getMessage(email);
			if (lst!=null && lst.size() > 0) {
				JSONArray jsonList = new JSONArray();
				for (Message m : lst) {
					JSONObject jsonMessage = new JSONObject();
					jsonMessage.put("message", m.getMessage());
					jsonMessage.put("to_email", m.getEmail());
					jsonMessage.put("to_name", m.getName());
					jsonMessage.put("from_email", m.getFrom());
					jsonMessage.put("year", m.getYear());
					jsonList.add(jsonMessage);
				}
				res.put("message", jsonList);
			}
			else
			{
				res.put("message", "");
			}
			System.out.println(res.toJSONString());
		}
		else if ("writeMessage".equals(type)) {
			String to_email = req.getParameter("to_email");
			String to_name = req.getParameter("to_name");
			String from_email = req.getParameter("from_email");
			String message = req.getParameter("message");
			int year = 2000;
			try {
				year = Integer.parseInt(req.getParameter("year"));
			} catch (Exception ex)
			{
				
				year = 0;
			}

			new MessageDAO().add(to_email, year, message, to_name, from_email);
			res.put("result", "success");
		}

		resp.setContentType("application/json");
		resp.getWriter().println(res.toJSONString());
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req, resp);
	}

	private List<Message> getMessage(String email) {
		MessageDAO mDAO = new MessageDAO();
		ArrayList<Message> msgList = mDAO.retrieve(email);
		return msgList;
	}

}
