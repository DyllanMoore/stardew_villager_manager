package com.revature.models;

public class Movies {

	private int movie_id;
	private String movie;

	
	//boilerplate code---------------
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movies(int movie_id, String movie) {
		super();
		this.movie_id = movie_id;
		this.movie = movie;
	}


	public Movies(String movie) {
		super();
		this.movie = movie;
	}


	@Override
	public String toString() {
		return "Movies [movie_id=" + movie_id + ", movie=" + movie + "]";
	}


	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public String getMovie() {
		return movie;
	}


	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	
}
