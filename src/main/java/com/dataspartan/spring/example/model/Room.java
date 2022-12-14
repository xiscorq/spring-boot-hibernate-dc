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
@Table(name = "room")
public class Room {		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "type")
	private String roomType;
	
	@OneToMany(targetEntity=Bed.class)
	private List<Bed> bedList;

	
	public Room() {
		
	}

	public Room(long id, String number, String roomType) {
		super();
		this.id = id;
		this.number = number;
		this.roomType = roomType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public List<Bed> getBedList() {
		return bedList;
	}

	public void setBedList(List<Bed> bedList) {
		this.bedList = bedList;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", number=" + number + ", roomType=" + roomType + "]";
	}
	
	
}
