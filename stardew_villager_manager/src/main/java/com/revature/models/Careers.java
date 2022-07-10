package com.revature.models;

public class Careers {

		private int career_id;
		private String career;
		
		//boilerplate code-------------
		
		public Careers() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Careers(int career_id, String career) {
			super();
			this.career_id = career_id;
			this.career = career;
		}

		public Careers(String career) {
			super();
			this.career = career;
		}

		@Override
		public String toString() {
			return "Careers [career_id=" + career_id + ", career=" + career + "]";
		}

		public int getCareer_id() {
			return career_id;
		}

		public void setCareer_id(int career_id) {
			this.career_id = career_id;
		}

		public String getCareer() {
			return career;
		}

		public void setCareer(String career) {
			this.career = career;
		}
	
		
	
}
