package com.FaceBack;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

import com.FaceBack.Message;

public class MessageDAO {
	static{
		ObjectifyService.register(Message.class);
	}
	
	public void add(String email,int year, String message,String name,String from){
		Objectify obj = ObjectifyService.begin();
		Message msg = new Message(email, year, message,name,from);
		obj.put(msg);
	}
	
	public ArrayList<Message> retrieve(String email){
		ArrayList<Message> msgList = new ArrayList<Message>();
		Objectify obj = ObjectifyService.begin();
		Query<Message> query = obj.query(Message.class);
		query.filter("email =",email);
		for(Message rMsg: query){
			msgList.add(rMsg);
		}
		if(msgList.size()==0){
			return null;
		}else
			return msgList;
	}
	
	
}
