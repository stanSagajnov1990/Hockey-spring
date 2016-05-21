package com.stanislav.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stanislav.spring.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	public List<Game> findByGameDateBetween(Date start, Date end);
	
}
