package com.FaceBack;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.FaceBack.*;

public class MemberDAO {
	static{
		ObjectifyService.register(Member.class);
	}
	
	public void add(String name, String email, String password){
		System.out.println("here1");
		Objectify obj = ObjectifyService.begin();
		System.out.println("here2");
		Member msg = new Member(name, email, password);
		System.out.println("here3");
		obj.put(msg);
		System.out.println("here4");
	}
	
	public Member retrieve(String email, String password){
		
		Objectify obj = ObjectifyService.begin();
		Query<Member> query = obj.query(Member.class);
		query.filter("email =",email);
		query.filter("password =",password);
		if (query.count()==1){
			return query.get();
		}
		
		return null;
	}
	
	public Member retrieve(String email){
		
		Objectify obj = ObjectifyService.begin();
		Query<Member> query = obj.query(Member.class);
		query.filter("email =",email);
		if (query.count()==1){
			return query.get();
		}
		
		return null;
	}

	public ArrayList<Member> getWriteToMemberList(String from){
		ArrayList<Member> memberList = new ArrayList<Member>();
		ArrayList<String> emailList = new ArrayList<String>();
		Objectify obj = ObjectifyService.begin();
		Query<Message> query = obj.query(Message.class);
		query.filter("from =",from);
		
		for(Message rMsg: query){
			String email = rMsg.getEmail();
			if (!emailList.contains(email)){
				emailList.add(email);
				Member m = new Member();
				m.setName(rMsg.getName());
				m.setEmail(rMsg.getEmail());
				memberList.add(m);
			}
		}
		
		return memberList;
	}
	
}
