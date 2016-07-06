package com.stanislav.spring.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

	public Game getGameById(Long id) {
		return repository.findOne(id);
	}

	public Page<Game> getGames(Pageable pageable, Specification<Game> specification) {
		if(pageable == null){
			pageable = ServiceUtils.pageableForAllEntities();
		}
		return wrapGamePageToEager(repository.findAll(pageable), pageable);
	}

	private Page<Game> wrapGamePageToEager(Page<Game> page, Pageable pageable) {
		return new AbstractPageWrapper<Game>(page, pageable) {
			@Override
			protected Game processEntity(Game entity) {
				return eagerGame(entity);
			}
		};
	}
	
	public Game eagerGame(Game entity) {
		if (entity == null)
		return null;
		
		return repository.eager(entity.getId());
	}

	public int countAccounts(Specification<Game> conditions) {
		return (int) repository.count(conditions);
	}

	
}
