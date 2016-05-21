package com.stanislav.spring.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stanislav.spring.model.Game;
import com.stanislav.spring.repositories.GameRepository;

@Service
@Transactional
public class GameService {
	
	@Autowired
	GameRepository repository;

	public List<Game> getGamesByDate(Date date) {
		LocalDateTime startLDT = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).minusDays(1);
		LocalDateTime endLDT = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).plusDays(1);
		Date startDate = Date.from(startLDT.atZone(ZoneId.systemDefault()).toInstant());
		Date endDate = Date.from(endLDT.atZone(ZoneId.systemDefault()).toInstant());
		
		return repository.findByGameDateBetween(startDate, endDate);
	}
	
	
	
}
