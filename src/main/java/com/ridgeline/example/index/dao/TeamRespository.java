package com.ridgeline.example.index.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ridgeline.example.index.entity.Team;

public interface TeamRespository extends CrudRepository<Team, Integer> {
	
	@Query("SELECT t FROM Team t WHERE t.id = :id")
	public Team findTeamByID(@Param("id") Integer id);
}
