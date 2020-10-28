package com.ridgeline.example.index.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ridgeline.example.index.entity.Team;
import com.ridgeline.example.index.model.dto.TeamDTO;

public class TeamMapper {
	private static Logger log = LoggerFactory.getLogger(TeamMapper.class);
	
	public Team mapDTOToEntity(TeamDTO teamDTO) {
		Team team = null;
		
		if(null != teamDTO) {
			log.info("Mapping TeamDTO object to a Team entity object...");
			
			team = new Team();
			
			team.setName(teamDTO.getName());
			team.setLocation(teamDTO.getLocation());
			team.setBallpark(teamDTO.getBallpark());
			team.setChampionships(teamDTO.getChampionships());
		}
		
		return team;
	}
	
	public TeamDTO mapEntityToDTO(Team team) {
		TeamDTO teamDTO = null;
		
		if(null != team) {
			log.info("Mapping team entity object to a TeamDTO object...");
			
			teamDTO = new TeamDTO();
			
			teamDTO.setName(team.getName());
			teamDTO.setLocation(team.getLocation());
			teamDTO.setBallpark(team.getBallpark());
			teamDTO.setChampionships(team.getChampionships());
		}
		
		return teamDTO;
	}
}
