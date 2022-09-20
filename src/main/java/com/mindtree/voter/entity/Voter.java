package com.mindtree.voter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Voter {
	
	@Id
	private String id;
	private String name;
	private String gender;
	private String state;
	private String city;
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voter(String id, String name, String gender, String state, String city) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.state = state;
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
