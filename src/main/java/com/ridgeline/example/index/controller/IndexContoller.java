package com.ridgeline.example.index.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ridgeline.example.index.model.dto.TeamDTO;
import com.ridgeline.example.index.service.interfaces.TeamService;

@RestController
public class IndexContoller {
	private static Logger log = LoggerFactory.getLogger(IndexContoller.class);
	
	private TeamService teamService;
	
	@Autowired
	public IndexContoller(TeamService teamService) {
		this.teamService = teamService;
	}
	
	
	@PostMapping("/index/team")
	public void postTeam(@RequestBody TeamDTO teamDTO) {
		log.info("Saving team object to the database...");
		
		teamService.addTeamToDatabase(teamDTO);
	}
}
