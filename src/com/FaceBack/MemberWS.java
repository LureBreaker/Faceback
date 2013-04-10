package com.FaceBack;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MemberWS extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
	
		JSONObject res = new JSONObject();
		String type = req.getParameter("type");
		
		
		if ("retrieveName".equals(type)){
			String email = req.getParameter("email");
			res.put("name", getMemberName(email));
		}
		else if ("login".equals(type)){
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Member member = login(email,password);
			if (member!=null){
				res.put("name", member.getName());
				res.put("email", member.getEmail());
			}else{
				res.put("error", "login failed");
			}
		}
		else if ("registration".equals(type)){
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String name = req.getParameter("name");
			if (register(email,password,name)){
				res.put("name", name);
				res.put("email", email);
				res.put("result", "success");
			}
			res.put("result", "fail");
		}
		else if ("writeToMemberList".equals(type)){
			String email = req.getParameter("email");
			List<Member> lst = getWriteToMemberList(email);
			JSONArray jsonList = new JSONArray();
			for(Member m : lst){
				JSONObject jsonMember = new JSONObject();
				jsonMember.put("name", m.getName());
				jsonMember.put("email", m.getEmail());
				jsonList.add(jsonMember);
			}
			
			res.put("Member",jsonList);
		}
		
		resp.setContentType("application/json");
		resp.getWriter().println(res.toJSONString());
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		doGet(req, resp);
	}

	private String getMemberName(String email)	{
		MemberDAO memberDao = new MemberDAO();
		Member member = memberDao.retrieve(email);
		if (member != null) {
			return member.getName();
		}
		return "";
	}
	
	private Member login(String email, String password)	{
		MemberDAO memberDao = new MemberDAO();
		return memberDao.retrieve(email,password);
	}
	private boolean register(String email, String password, String name){
		MemberDAO memberDao = new MemberDAO();
		Member isMember = memberDao.retrieve(email);
		if (isMember==null){
			memberDao.add(name, email, password);
			return true;
		}
		return false;
	}
	
	private List<Member> getWriteToMemberList(String email){
		MemberDAO memberDao = new MemberDAO();
		return memberDao.getWriteToMemberList(email);
	}
}
