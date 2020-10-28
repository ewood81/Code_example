package com.ridgeline.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamModel {
	
	@JsonProperty("Team Name")
	private String name;
	
	@JsonProperty("Team Location")
	private String location;
	
	@JsonProperty("Home Ballpark")
	private String ballpark;
	
	@JsonProperty("# of Championships")
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

	@Override
	public String toString() {
		return "TeamModel [name=" + name + ", location=" + location + ", ballpark=" + ballpark + ", championships="
				+ championships + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ballpark == null) ? 0 : ballpark.hashCode());
		result = prime * result + ((championships == null) ? 0 : championships.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamModel other = (TeamModel) obj;
		if (ballpark == null) {
			if (other.ballpark != null)
				return false;
		} else if (!ballpark.equals(other.ballpark))
			return false;
		if (championships == null) {
			if (other.championships != null)
				return false;
		} else if (!championships.equals(other.championships))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
