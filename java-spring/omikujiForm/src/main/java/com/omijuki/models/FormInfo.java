package com.omijuki.models;

public class FormInfo {

	//member variables
	private Integer year;
	private String city;
	private String name;
	private String hobby;
	private String livingThing;
	private String message;
	
	public FormInfo() {}

	public FormInfo(Integer year, String city, String name, String hobby, String livingThing, String message) {
		this.year = year;
		this.city = city;
		this.name = name;
		this.hobby = hobby;
		this.livingThing = livingThing;
		this.message = message;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getLivingThing() {
		return livingThing;
	}

	public void setLivingThing(String livingThing) {
		this.livingThing = livingThing;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
