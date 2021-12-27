package com.javatpoint.mypackage;

import java.util.List;

public class QuestionBag {
	
	private int id;  
	private String qname;  
	private List answers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public List getAnswers() {
		return answers;
	}
	public void setAnswers(List answers) {
		this.answers = answers;
	}

}
