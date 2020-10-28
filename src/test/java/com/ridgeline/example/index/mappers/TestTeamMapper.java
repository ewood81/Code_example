package com.ridgeline.example.index.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ridgeline.example.index.entity.Team;
import com.ridgeline.example.index.model.dto.TeamDTO;

public class TestTeamMapper {
	
	private TeamMapper teamMapper;
	
	@BeforeEach
	public  void setup() {
		teamMapper = new TeamMapper();
	}
	
	@Test
	@DisplayName("TeamMapper - DTO to Entity success")
	public void testMapDTOToEntitySuccess() {
		TeamDTO teamDTO = new TeamDTO();
		
		teamDTO.setName("Wasington Nationals");
		teamDTO.setLocation("Washington DC");
		teamDTO.setBallpark("Nationals Park");
		teamDTO.setChampionships("1");
		
		Team team = teamMapper.mapDTOToEntity(teamDTO);
		
		assertNotNull(team);
		
		assertEquals(teamDTO.getName(), team.getName());
		assertEquals(teamDTO.getLocation(), team.getLocation());
		assertEquals(teamDTO.getBallpark(), team.getBallpark());
		assertEquals(teamDTO.getChampionships(), team.getChampionships());
	}
	
	@Test
	@DisplayName("TeamMapper Entity to DTO success")
	public void testMapEntityToDTOSuccess() {
		Team team = new Team();
		
		team.setName("Wasington Nationals");
		team.setLocation("Washington DC");
		team.setBallpark("Nationals Park");
		team.setChampionships("1");
		
		TeamDTO teamDTO = teamMapper.mapEntityToDTO(team);
		
		assertNotNull(teamDTO);
		
		assertEquals(team.getName(), teamDTO.getName());
		assertEquals(team.getLocation(), teamDTO.getLocation());
		assertEquals(team.getBallpark(), teamDTO.getBallpark());
		assertEquals(team.getChampionships(), teamDTO.getChampionships());
	}
}
