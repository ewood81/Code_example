package com.ridgeline.example.index.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;

	private String location;	

	private String ballpark;
	
	private String championships;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBallpark() {
		return ballpark;
	}

	public void setBallpark(String ballpark) {
		this.ballpark = ballpark;
	}

	public String getChampionships() {
		return championships;
	}

	public void setChampionships(String championships) {
		this.championships = championships;
	}	
}
