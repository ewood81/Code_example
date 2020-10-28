package com.ridgeline.example.index.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridgeline.example.index.dao.TeamRespository;
import com.ridgeline.example.index.entity.Team;
import com.ridgeline.example.index.mappers.TeamMapper;
import com.ridgeline.example.index.model.dto.TeamDTO;
import com.ridgeline.example.index.service.interfaces.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	private TeamRespository teamRepository;
	
	@Autowired
	public TeamServiceImpl(TeamRespository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	@Override
	public void addTeamToDatabase(TeamDTO teamDTO) {		
		if(null != teamDTO) {			
			TeamMapper teamMapper = new TeamMapper();
			
			Team team = teamMapper.mapDTOToEntity(teamDTO);
			
			if(null != team) {
				teamRepository.save(team);
			}
		}
	}
}
