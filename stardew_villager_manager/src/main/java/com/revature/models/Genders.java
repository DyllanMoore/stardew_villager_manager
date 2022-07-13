package com.revature.models;

public class Genders {

	private int gender_id;
	private String gender;
	
	//boilerplate code-------------------
	
	public Genders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genders(int gender_id, String gender) {
		super();
		this.gender_id = gender_id;
		this.gender = gender;
	}

	public Genders(String gender) {
		super();
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Genders [gender_id=" + gender_id + ", gender=" + gender + "]";
	}

	public int getGender_id() {
		return gender_id;
	}

	public void setGender_id(int gender_id) {
		this.gender_id = gender_id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}