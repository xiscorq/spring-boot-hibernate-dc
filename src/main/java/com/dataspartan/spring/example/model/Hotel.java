package com.dataspartan.spring.example.model;

public class Hotel {

	public void setId(long id) {
		this.id = id;
	}

	private long id;


	private String name;


	private String description;


	private int stars;
	
	
	private int example;

	public Hotel() {

	}

	public Hotel(String name, String description, int stars) {
		this.name = name;
		this.description = description;
		this.stars = stars;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", desc=" + description + ", stars=" + stars + "]";
	}

}
