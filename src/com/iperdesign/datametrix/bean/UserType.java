package com.iperdesign.datametrix.bean;

public class UserType {
	private int id;
	private String value;
	
	public UserType(){
		super();
	}
	
	public UserType(int id, String value){
		this.id = id;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
