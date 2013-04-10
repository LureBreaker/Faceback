package com.FaceBack;

import java.io.Serializable;

import javax.persistence.Id;

public class FeedBack {
	@Id private Long id;
	private String feedback;
	
	public FeedBack(){
		
	}
	
	public FeedBack(String feedback){
		this.feedback = feedback;
	}
	
}
