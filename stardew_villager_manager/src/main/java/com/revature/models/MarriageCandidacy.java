package com.revature.models;

public class MarriageCandidacy {

	private int marriage_candidacy_id;
	private String marriage_candidacy;
	
	//boilerplate code-----------------
	
	public MarriageCandidacy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarriageCandidacy(int marriage_candidacy_id, String marriage_candidacy) {
		super();
		this.marriage_candidacy_id = marriage_candidacy_id;
		this.marriage_candidacy = marriage_candidacy;
	}

	public MarriageCandidacy(String marriage_candidacy) {
		super();
		this.marriage_candidacy = marriage_candidacy;
	}

	@Override
	public String toString() {
		return "MarriageCandidacy [marriage_candidacy_id=" + marriage_candidacy_id + ", marriage_candidacy="
				+ marriage_candidacy + "]";
	}

	public int getMarriage_candidacy_id() {
		return marriage_candidacy_id;
	}

	public void setMarriage_candidacy_id(int marriage_candidacy_id) {
		this.marriage_candidacy_id = marriage_candidacy_id;
	}

	public String getMarriage_candidacy() {
		return marriage_candidacy;
	}

	public void setMarriage_candidacy(String marriage_candidacy) {
		this.marriage_candidacy = marriage_candidacy;
	}
	
	
	
}
