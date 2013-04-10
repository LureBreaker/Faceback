package com.FaceBack;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class FeedBackDAO {
	
	static{
		ObjectifyService.register(FeedBack.class);
	}
	
	public void add(String feedback){
		Objectify obj = ObjectifyService.begin();
		FeedBack fb = new FeedBack(feedback);
		obj.put(fb);
	}
}
