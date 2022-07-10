package com.revature.models;

public class Villagers {
	
	private int villager_id;
	private String villager_name;
	private String villager_birthday;
	private Genders gender;
	private MarriageCandidacy marriagecandidacy;
	private Addresses address;
	private Careers career;
	private Movies movie;
	
	//boilerplate code------------------
	public Villagers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Villagers(int villager_id, String villager_name, String villager_birthday, Genders gender,
			MarriageCandidacy marriagecandidacy, Addresses address, Careers career, Movies movie) {
		super();
		this.villager_id = villager_id;
		this.villager_name = villager_name;
		this.villager_birthday = villager_birthday;
		this.gender = gender;
		this.marriagecandidacy = marriagecandidacy;
		this.address = address;
		this.career = career;
		this.movie = movie;
	}

	public Villagers(String villager_name, String villager_birthday, Genders gender,
			MarriageCandidacy marriagecandidacy, Addresses address, Careers career, Movies movie) {
		super();
		this.villager_name = villager_name;
		this.villager_birthday = villager_birthday;
		this.gender = gender;
		this.marriagecandidacy = marriagecandidacy;
		this.address = address;
		this.career = career;
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Villagers [villager_id=" + villager_id + ", villager_name=" + villager_name + ", villager_birthday="
				+ villager_birthday + ", gender=" + gender + ", marriagecandidacy=" + marriagecandidacy + ", address="
				+ address + ", career=" + career + ", movie=" + movie + "]";
	}

	public int getVillager_id() {
		return villager_id;
	}

	public void setVillager_id(int villager_id) {
		this.villager_id = villager_id;
	}

	public String getVillager_name() {
		return villager_name;
	}

	public void setVillager_name(String villager_name) {
		this.villager_name = villager_name;
	}

	public String getVillager_birthday() {
		return villager_birthday;
	}

	public void setVillager_birthday(String villager_birthday) {
		this.villager_birthday = villager_birthday;
	}

	public Genders getGender() {
		return gender;
	}

	public void setGender(Genders gender) {
		this.gender = gender;
	}

	public MarriageCandidacy getMarriagecandidacy() {
		return marriagecandidacy;
	}

	public void setMarriagecandidacy(MarriageCandidacy marriagecandidacy) {
		this.marriagecandidacy = marriagecandidacy;
	}

	public Addresses getAddress() {
		return address;
	}

	public void setAddress(Addresses address) {
		this.address = address;
	}

	public Careers getCareer() {
		return career;
	}

	public void setCareer(Careers career) {
		this.career = career;
	}

	public Movies getMovie() {
		return movie;
	}

	public void setMovie(Movies movie) {
		this.movie = movie;
	}
	
	
	

}
