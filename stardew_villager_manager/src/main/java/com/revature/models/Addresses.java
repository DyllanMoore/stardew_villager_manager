package com.revature.models;

public class Addresses {

	private int address_id;
	private String address;
	
	//boilerplate code----------
	
	public Addresses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Addresses(int address_id, String address) {
		super();
		this.address_id = address_id;
		this.address = address;
	}

	public Addresses(String address) {
		super();
		this.address = address;
	}

	@Override
	public String toString() {
		return "Addresses [address_id=" + address_id + ", address=" + address + "]";
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
