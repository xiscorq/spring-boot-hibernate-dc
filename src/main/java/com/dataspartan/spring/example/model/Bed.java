package com.dataspartan.spring.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bed")
public class Bed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "type")
	private String bedType;
	
	public Bed() {
		
	}

	public Bed(long id, String bedType) {		
		this.id = id;
		this.bedType = bedType;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	
	@Override
	public String toString() {
		return "Bed [id=" + id + ", bedType=" + bedType + "]";
	}
}
