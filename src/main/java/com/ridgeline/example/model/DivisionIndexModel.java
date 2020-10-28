package com.ridgeline.example.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ridgeline.example.index.model.interfaces.IndexModel;

public class DivisionIndexModel implements IndexModel, Serializable {
	private static final long serialVersionUID = 1L;

	@JsonUnwrapped()
	private DivisionModel divisionModel;
	
	@JsonUnwrapped()
	private List<TeamModel> teamModel;

	public DivisionModel getDivisionModel() {
		return divisionModel;
	}

	public void setDivisionModel(DivisionModel divisionModel) {
		this.divisionModel = divisionModel;
	}

	public List<TeamModel> getTeamModel() {
		return teamModel;
	}

	public void setTeamModel(List<TeamModel> teamModel) {
		this.teamModel = teamModel;
	}

	@Override
	public String toString() {
		return "DivisionIndexModel [divisionModel=" + divisionModel + ", teamModel=" + teamModel + "]";
	}
}
