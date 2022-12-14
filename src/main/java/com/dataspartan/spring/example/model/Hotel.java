package com.dataspartan.spring.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "stars")
	private int stars;
	
	@OneToMany(targetEntity=Room.class)
	private List<Room> roomList;

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
	
	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", desc=" + description + ", stars=" + stars + "]";
	}

}
