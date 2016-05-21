package com.stanislav.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stanislav.spring.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	
	
}
