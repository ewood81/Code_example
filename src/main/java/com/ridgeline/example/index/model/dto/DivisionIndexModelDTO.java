package com.ridgeline.example.index.model.dto;

import java.util.List;

public class DivisionIndexModelDTO {
	private DivisionDTO divisionDTO;
	
	private List<TeamDTO> teamDTOs;

	public DivisionDTO getDivisionDTO() {
		return divisionDTO;
	}

	public void setDivisionDTO(DivisionDTO divisionDTO) {
		this.divisionDTO = divisionDTO;
	}

	public List<TeamDTO> getTeamDTOs() {
		return teamDTOs;
	}

	public void setTeamDTOs(List<TeamDTO> teamDTOs) {
		this.teamDTOs = teamDTOs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((divisionDTO == null) ? 0 : divisionDTO.hashCode());
		result = prime * result + ((teamDTOs == null) ? 0 : teamDTOs.hashCode());
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
		DivisionIndexModelDTO other = (DivisionIndexModelDTO) obj;
		if (divisionDTO == null) {
			if (other.divisionDTO != null)
				return false;
		} else if (!divisionDTO.equals(other.divisionDTO))
			return false;
		if (teamDTOs == null) {
			if (other.teamDTOs != null)
				return false;
		} else if (!teamDTOs.equals(other.teamDTOs))
			return false;
		return true;
	}
}
