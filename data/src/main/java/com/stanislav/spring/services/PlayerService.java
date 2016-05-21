package com.stanislav.spring.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stanislav.spring.model.Player;
import com.stanislav.spring.model.PlayerStatistics;
import com.stanislav.spring.repositories.PlayerRepository;

@Service
@Transactional
public class PlayerService {
	
	@Autowired
	PlayerRepository repository;
	
	public Player findById(Long id){
		Player player = repository.findOne(id);
		if (player != null) {
			List<PlayerStatistics> playerStatistics = player.getPlayerStatistics();
			for (Iterator<PlayerStatistics> iterator = playerStatistics.iterator(); iterator.hasNext();) {
				iterator.next();
			}
		}
		return player;
	}
	
	public void rent(){
		
	}

	public List<Player> getAllPlayers() {
		return repository.findAll();
	}
	
}
